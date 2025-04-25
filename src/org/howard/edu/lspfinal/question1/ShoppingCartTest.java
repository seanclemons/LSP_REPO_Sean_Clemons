package org.howard.edu.lspfinal.question1;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Shoes", 50.0);
        assertEquals(50.0, cart.getTotalCost(), 0.001);  // Test for adding valid item
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithNegativePrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("TV", -100.0);  // Test for adding item with negative price
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemWithZeroPrice() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pencil", 0.0);  // Test for adding item with 0 price
    }

    @Test
    public void testApplyDiscountCodeSAVE10() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Phone", 1000.0);
        cart.applyDiscountCode("SAVE10");  // Test for applying "SAVE10"
        assertEquals(900.0, cart.getTotalCost(), 0.001);  
    }

    @Test
    public void testApplyDiscountCodeSAVE20() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Monitor", 500.0);
        cart.applyDiscountCode("SAVE20");  // Test for applying "SAVE20"
        assertEquals(400.0, cart.getTotalCost(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testApplyInvalidDiscountCode() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("INVALIDCODE");  // Test for invalid cod
    }

    @Test
    public void testGetDiscountPercentage() {
        ShoppingCart cart = new ShoppingCart();
        cart.applyDiscountCode("SAVE20");
        assertEquals(20.0, cart.getDiscountPercentage(), 0.001);
    }

    @Test
    public void testGetTotalCostWithNoItems() {
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0.0, cart.getTotalCost(), 0.001);  // Test total cost with empty cart
    }

    @Test
    public void testGetTotalCostWithoutDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Pen", 2.5);
        cart.addItem("Notebook", 5.0);
        assertEquals(7.5, cart.getTotalCost(), 0.001);  // Test total cost without discount
    }

    @Test
    public void testGetTotalCostWithDiscount() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Backpack", 80.0);
        cart.applyDiscountCode("SAVE10");
        assertEquals(72.0, cart.getTotalCost(), 0.001);  // Test total cost with discount
    }
}
