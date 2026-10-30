package org.example;

public class Delivery {
    private String orderId;
    private String address;
    private double weight;
    private double distance;
    private DeliveryStatus status;

    public Delivery(String orderId, String address,
                    double weight, double distance)
            throws InvalidDeliveryDataException {
        setOrderId(orderId);
        setAddress(address);
        setWeight(weight);
        setDistance(distance);
        this.status = DeliveryStatus.PENDING;
    }

    public String getOrderId() { return orderId; }
    public String getAddress() { return address; }
    public double getWeight() { return weight; }
    public double getDistance() { return distance; }
    public DeliveryStatus getStatus() { return status; }

    public void setOrderId(String orderId) throws InvalidDeliveryDataException {
        if (orderId == null || orderId.isBlank()) {
            throw new InvalidDeliveryDataException(
                    "Номер заказа не может быть пустым");
        }
        this.orderId = orderId;
    }

    public void setAddress(String address) throws InvalidDeliveryDataException {
        if (address == null || address.isBlank()) {
            throw new InvalidDeliveryDataException(
                    "Адрес не может быть пустым");
        }
        this.address = address;
    }

    public void setWeight(double weight) throws InvalidDeliveryDataException {
        if (weight <= 0) {
            throw new InvalidDeliveryDataException(
                    "Вес должен быть положительным: " + weight);
        }
        this.weight = weight;
    }

    public void setDistance(double distance) throws InvalidDeliveryDataException {
        if (distance <= 0) {
            throw new InvalidDeliveryDataException(
                    "Расстояние должно быть положительным: " + distance);
        }
        this.distance = distance;
    }


    public void startDelivery() throws DeliveryException {
        if (status == DeliveryStatus.COMPLETED) {
            throw new DeliveryException(
                    "Нельзя начать доставку: заказ уже доставлен", orderId);
        }
        if (status == DeliveryStatus.IN_PROGRESS) {
            throw new DeliveryException(
                    "Доставка уже в пути", orderId);
        }
        if (status == DeliveryStatus.CANCELLED) {
            throw new DeliveryException(
                    "Нельзя начать доставку: заказ отменён", orderId);
        }
        status = DeliveryStatus.IN_PROGRESS;
        System.out.println("Доставка заказа " + orderId + " начата. Адрес: " + address);
    }

    public void completeDelivery() throws DeliveryException {
        if (status == DeliveryStatus.PENDING) {
            throw new DeliveryException(
                    "Нельзя завершить доставку, которая не начата", orderId);
        }
        if (status == DeliveryStatus.COMPLETED) {
            throw new DeliveryException(
                    "Доставка уже завершена", orderId);
        }
        if (status == DeliveryStatus.CANCELLED) {
            throw new DeliveryException(
                    "Нельзя завершить отменённую доставку", orderId);
        }
        status = DeliveryStatus.COMPLETED;
        System.out.println("Доставка заказа " + orderId + " завершена");
    }

    public void cancelDelivery() throws DeliveryException {
        if (status == DeliveryStatus.COMPLETED) {
            throw new DeliveryException(
                    "Нельзя отменить завершённую доставку", orderId);
        }
        status = DeliveryStatus.CANCELLED;
        System.err.println("Доставка заказа " + orderId + " отменена");
    }

    @Override
    public String toString() {
        return String.format(
                "Delivery{orderId='%s', address='%s', weight=%.1f kg, distance=%.1f km, status=%s}",
                orderId, address, weight, distance, status.getDescription());
    }
}