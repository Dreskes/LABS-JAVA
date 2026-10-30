package org.example;

public class DeliveryNotFoundException extends Exception {
    private String orderId;

    public DeliveryNotFoundException(String message, String orderId) {
        super(message);
        this.orderId = orderId;
    }

    public String getOrderId() { return orderId; }
}