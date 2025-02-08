package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Product {
    private final int productId;  
    private String name;
    private double price;
    private String category;
    private String priceRange;

    public Product(int productId, String name, double price, String category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        updatePriceRange();
    }

    private void updatePriceRange() {
        if (price <= 10.0) {
            this.priceRange = "Low";
        } else if (price <= 100.0) {
            this.priceRange = "Medium";
        } else if (price <= 500.0) {
            this.priceRange = "High";
        } else {
            this.priceRange = "Premium";
        }
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPriceRange() { return priceRange; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
        updatePriceRange();  
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("%d,%s,%.2f,%s,%s",
            productId, name, price, category, priceRange);
    }
}

interface FileHandler {
    List<Product> readFile(String filePath) throws IOException;
    void writeFile(String filePath, List<Product> products) throws IOException;
}

class CSVFileHandler implements FileHandler {
    @Override
    public List<Product> readFile(String filePath) throws IOException {
        List<Product> products = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); 
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    products.add(new Product(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Double.parseDouble(parts[2]),
                        parts[3]
                    ));
                }
            }
        }
        return products;
    }

    @Override
    public void writeFile(String filePath, List<Product> products) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ProductID,Name,Price,Category,PriceRange\n");
            for (Product product : products) {
                writer.write(product.toString() + "\n");
            }
        }
    }
}

interface DataTransformer {
    void transform(List<Product> products);
}

class ProductTransformer implements DataTransformer {
    @Override
    public void transform(List<Product> products) {
        for (Product product : products) {
            transformProduct(product);
        }
    }

    private void transformProduct(Product product) {
        product.setName(product.getName().toUpperCase());

        if (product.getCategory().equals("Electronics")) {
            applyElectronicsTransformation(product);
        }
    }

    private void applyElectronicsTransformation(Product product) {
        double discountedPrice = Math.round(product.getPrice() * 0.9 * 100.0) / 100.0;
        product.setPrice(discountedPrice);
        
        if (discountedPrice > 500.0) {
            product.setCategory("Premium Electronics");
        }
    }
}

public class ETLPipeline {
    private final FileHandler fileHandler;
    private final DataTransformer transformer;
    private final String inputPath;
    private final String outputPath;

    public ETLPipeline(FileHandler fileHandler, DataTransformer transformer, 
                      String inputPath, String outputPath) {
        this.fileHandler = fileHandler;
        this.transformer = transformer;
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public void execute() throws IOException {
        List<Product> products = fileHandler.readFile(inputPath);
        transformer.transform(products);
        fileHandler.writeFile(outputPath, products);
    }

    public static void main(String[] args) {
        try {
            FileHandler fileHandler = new CSVFileHandler();
            DataTransformer transformer = new ProductTransformer();
            
            ETLPipeline pipeline = new ETLPipeline(
                fileHandler,
                transformer,
                "data/products.csv",
                "data/transformed_products.csv"
            );
            
            pipeline.execute();
            System.out.println("ETL process completed successfully!");
            
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found. Please ensure 'products.csv' exists in the data directory.");
        } catch (IOException e) {
            System.err.println("Error processing file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}