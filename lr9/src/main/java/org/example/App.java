package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Sportsman[] team = new Sportsman[5];

        team[0] = new Forward("Иванов", "Динамо", 9, 10);
        team[1] = new Forward("Петров", "Динамо", 11, 7);

        team[2] = new Defender("Сидоров", "Динамо", 3, 20);
        team[3] = new Defender("Кузнецов", "Динамо", 4, 15);
        team[4] = new Defender("Смирнов", "Динамо", 5, 18);

        System.out.println("Состав команды");
        for (Sportsman s : team) {
            s.displayInfo();
            System.out.println();
        }

        System.out.println("Позиции и статистика ");
        for (Sportsman s : team) {
            System.out.println(s.getName() + " — " + s.getPosition()
                    + " | " + s.getStatistics());
        }

    }
}
