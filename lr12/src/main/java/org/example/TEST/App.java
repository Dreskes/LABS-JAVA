package org.example.TEST;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class App {
    public static void main(String[] args) {
        List<Coach> coaches = new ArrayList<>();

        coaches.add(new Coach(1, "Иванов",   "футбол",   2,
                List.of(5, 4, 5, 3, 4)));
        coaches.add(new Coach(2, "Петров",   "баскетбол", 3,
                List.of(3, 3, 2, 2, 3)));
        coaches.add(new Coach(3, "Сидоров",  "плавание",  1,
                List.of(5, 5, 4, 5, 5)));
        coaches.add(new Coach(4, "Кузнецов", "бокс",      2,
                List.of(1, 2, 1, 2, 1)));
        coaches.add(new Coach(5, "Смирнов",  "теннис",    4,
                List.of(4, 4, 5, 4, 4)));
        coaches.add(new Coach(6, "Андреев",  "футбол",    3,
                List.of(2, 2, 3, 2, 1)));

        System.out.println("=== Тренеры со средним рейтингом > 3 ===");
        for (Coach c : coaches) {
            if (c.getAverageRating() > 3) {
                System.out.println(c);
            }
        }

        for (Coach c : coaches) {
            if (c.getAverageRating() >= 4) {
                c.setLevel(c.getLevel() + 1);
            }
        }
        System.out.println("\n=== После повышения уровней ===");
        for (Coach c : coaches) {
            System.out.println(c);
        }

        System.out.println("\n=== Тренеры на уровне 3 ===");

        System.out.println("\n=== Отсортированные тренеры ===");
        coaches.sort(
                Comparator.comparingDouble(Coach::getAverageRating)
                        .reversed()
                        .thenComparing(Coach::getName)
        );


    }
}