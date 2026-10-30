package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        DeliveryService service = new DeliveryService();

        System.out.println(" Создание доставок");
        createDelivery(service, "ORD-001", "ул. Ленина, 5", 2.5, 10.0);
        createDelivery(service, "ORD-002", "пр. Мира, 12", 5.0, 25.0);
        createDelivery(service, "ORD-003", "ул. Гагарина, 3", 1.2, 7.5);

        System.out.println("\nОшибочные данные (вес <= 0) ");
        createDelivery(service, "ORD-004", "ул. Тестовая, 1", -1.0, 5.0);

        System.out.println("\nОшибочные данные расстояние <= 0");
        createDelivery(service, "ORD-005", "ул. Тестовая, 2", 3.0, 0);

        System.out.println("\nОшибочные данные");
        createDelivery(service, "ORD-006", "", 3.0, 5.0);

        System.out.println("\nЗапуск доставки ORD-001");
        try {
            service.startDelivery("ORD-001");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПопытка повторно запустить ORD-001");
        try {
            service.startDelivery("ORD-001");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nЗавершение ORD-001");
        try {
            service.completeDelivery("ORD-001");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПопытка завершить ORD-002 (не начата) ");
        try {
            service.completeDelivery("ORD-002");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nНесуществующий заказ");
        try {
            service.startDelivery("ORD-999");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nПопытка повторно завершить ORD-001");
        try {
            service.completeDelivery("ORD-001");
        } catch (DeliveryNotFoundException | DeliveryException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        service.printAll();
    }

    private static void createDelivery(DeliveryService service, String orderId,
                                       String address, double weight, double distance) {
        try {
            Delivery d = new Delivery(orderId, address, weight, distance);
            service.addDelivery(d);
        } catch (InvalidDeliveryDataException e) {
            System.out.println("Ошибка при создании " + orderId + ": " + e.getMessage());
        }
    }
}
