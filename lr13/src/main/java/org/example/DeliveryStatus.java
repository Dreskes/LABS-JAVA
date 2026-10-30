package org.example;

public enum DeliveryStatus {
    PENDING("Ожидает"),
    IN_PROGRESS("В пути"),
    COMPLETED("Доставлено"),
    CANCELLED("Отменено");

    private final String description;

    DeliveryStatus(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }
}