package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {


        System.out.println("Hello World!");

        System.out.println("Перегрузка play() ");
        Guitar guitar = new Guitar("Fender", "акустическая", "Дзынь", 6);

        guitar.play();
        guitar.play(70);
        guitar.play("Stairway to Heaven");
        guitar.play(80, "Wonderwall");

        System.out.println("\nПереопределение getSoundType() ");

        Instrument[] orchestra = {
                new Guitar("Fender", "акустическая", "Дзынь", 6),
                new Piano("Yamaha", "цифровое", "Дон", 88),
                new Guitar("Gibson", "электрогитара", "Рык", 6)
        };

        for (Instrument ins : orchestra) {
            ins.displayInfo();
            System.out.println("  Звук: " + ins.getSoundType());
            System.out.println();
        }

        System.out.println("Сравнение");

        Instrument poly = new Piano("Casio", "цифровое", "Бип", 76);

        System.out.println(poly.getSoundType());

        poly.play();
        poly.play(50);
        poly.play("Прелюдия");
    }
}
