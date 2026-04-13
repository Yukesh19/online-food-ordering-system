package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App app;

    @Before
    public void setup() {
        app = new App();
    }

    // ✅ Successful Order
    @Test
    public void testPlaceOrderSuccess() {
        String result = app.placeOrder(1, "Pizza", 2);
        assertEquals("Order placed successfully!", result);
    }

    // ❌ Duplicate Order
    @Test
    public void testDuplicateOrder() {
        app.placeOrder(1, "Pizza", 2);
        String result = app.placeOrder(1, "Pizza", 2);
        assertEquals("Order already exists!", result);
    }

    // ❌ Invalid Item
    @Test
    public void testInvalidItem() {
        String result = app.placeOrder(2, "Sushi", 1);
        assertEquals("Item not available!", result);
    }

    // ❌ Invalid Quantity
    @Test
    public void testInvalidQuantity() {
        String result = app.placeOrder(3, "Burger", 0);
        assertEquals("Invalid quantity!", result);
    }

    // ✅ Process Order
    @Test
    public void testProcessOrderSuccess() {
        app.placeOrder(4, "Pasta", 1);
        String result = app.processOrder(4);
        assertEquals("Order delivered successfully!", result);
    }

    // ❌ Process Non-existing Order
    @Test
    public void testProcessOrderNotFound() {
        String result = app.processOrder(99);
        assertEquals("Order not found!", result);
    }

    // ✅ Check Status
    @Test
    public void testOrderStatus() {
        app.placeOrder(5, "Pizza", 1);
        assertEquals("PLACED", app.getOrderStatus(5));
    }
}