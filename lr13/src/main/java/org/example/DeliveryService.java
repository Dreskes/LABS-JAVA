package org.example;

import java.util.HashMap;
import java.util.Map;

public class DeliveryService {
    private Map<String, Delivery> deliveries = new HashMap<>();

    public void addDelivery(Delivery delivery) {
        deliveries.put(delivery.getOrderId(), delivery);
        System.out.println("Добавлена доставка: " + delivery.getOrderId());
    }

    public Delivery findDelivery(String orderId) throws DeliveryNotFoundException {
        Delivery d = deliveries.get(orderId);
        if (d == null) {
            throw new DeliveryNotFoundException(
                    "Доставка с номером " + orderId + " не найдена", orderId);
        }
        return d;
    }

    public void startDelivery(String orderId)
            throws DeliveryNotFoundException, DeliveryException {
        Delivery d = findDelivery(orderId);
        d.startDelivery();
    }

    public void completeDelivery(String orderId)
            throws DeliveryNotFoundException, DeliveryException {
        Delivery d = findDelivery(orderId);
        d.completeDelivery();
    }

    public void printAll() {
        System.out.println("\nВсе доставки =");
        for (Delivery d : deliveries.values()) {
            System.out.println(d);
        }
    }
}