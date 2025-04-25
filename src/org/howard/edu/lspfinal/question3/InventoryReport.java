package org.howard.edu.lspfinal.question3;

/**
 * Represents an Inventory Report that customizes each step of the report process
 */
public class InventoryReport extends Report {
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
