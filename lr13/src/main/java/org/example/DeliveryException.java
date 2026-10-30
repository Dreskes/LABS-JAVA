package org.example;

public class DeliveryException extends Exception {
    private String orderId;

    public DeliveryException(String message, String orderId) {
        super(message);
        this.orderId = orderId;
    }

    public String getOrderId() { return orderId; }
}