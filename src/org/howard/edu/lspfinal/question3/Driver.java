package org.howard.edu.lspfinal.question3;

/**
 * Demonstrates  use of he Report template with different types of reports
 */
public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        sales.generateReport();

        System.out.println();

        Report inventory = new InventoryReport();
        inventory.generateReport();
    }
}
