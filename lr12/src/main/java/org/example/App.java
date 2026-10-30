package org.example;

/**
 * Hello world!
 */

import java.util.LinkedHashMap;
import java.util.Map;
public class App {
    public static void main(String[] args) {


        System.out.println("Hello World!");

        Map<String, Dish> dishes = new LinkedHashMap<>();

        dishes.put("Обеденная", new Plate("Обеденная", 1, 500, 24));
        dishes.put("Десертная", new Plate("Десертная", 2, 250, 18));
        dishes.put("Суповая", new Plate("Суповая", 3, 700, 26));

        dishes.put("Чайная", new Cup("Чайная", 4, 250, true));
        dishes.put("Кофейная", new Cup("Кофейная", 5, 200, false));
        dishes.put("Кружка", new Cup("Кружка", 6, 400, true));

        dishes.put("Салатник", new Bowl("Салатник", 7, 600, 10));
        dishes.put("Супница", new Bowl("Супница", 8, 800, 15));

        System.out.println("Все ключи ");
        for (String key : dishes.keySet()) {
            System.out.println(key);
        }

        System.out.println("\nлюч -> Значение");
        for (Map.Entry<String, Dish> entry : dishes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
