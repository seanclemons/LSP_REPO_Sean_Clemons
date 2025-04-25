package org.howard.edu.lspfinal.question3;

/**
 * Base class for all reports using the Template Method pattern
 * Defines general workflow for generating reports
 */
public abstract class Report {

    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();

    protected abstract void formatData();

    protected abstract void printReport();
}
