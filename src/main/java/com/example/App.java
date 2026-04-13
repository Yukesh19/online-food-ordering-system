package com.example;

import java.util.HashMap;
import java.util.Map;

public class App {

    // Store orders: orderId → status
    private Map<Integer, String> orders = new HashMap<>();

    // Store available menu items
    private Map<String, Double> menu = new HashMap<>();

    public App() {
        // Sample menu
        menu.put("Pizza", 200.0);
        menu.put("Burger", 100.0);
        menu.put("Pasta", 150.0);
    }

    // Place Order
    public String placeOrder(int orderId, String item, int quantity) {

        // Validation
        if (orders.containsKey(orderId)) {
            return "Order already exists!";
        }

        if (!menu.containsKey(item)) {
            return "Item not available!";
        }

        if (quantity <= 0) {
            return "Invalid quantity!";
        }

        // Process order
        orders.put(orderId, "PLACED");

        return "Order placed successfully!";
    }

    // Process Order (simulate delivery)
    public String processOrder(int orderId) {

        if (!orders.containsKey(orderId)) {
            return "Order not found!";
        }

        orders.put(orderId, "DELIVERED");

        return "Order delivered successfully!";
    }

    // Check Order Status
    public String getOrderStatus(int orderId) {
        return orders.getOrDefault(orderId, "Order not found!");
    }
}