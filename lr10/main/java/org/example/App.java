package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        Installable[] installables = new Installable[5];

        installables[0] = new Game("Ведьмак 3", "1.32", "RPG");
        installables[1] = new Game("CS2", "2.0", "Shooter");
        installables[2] = new Game("Minecraft", "1.21", "Sandbox");

        installables[3] = new Editor("VS Code", "1.90", "TXT");
        installables[4] = new Editor("IntelliJ IDEA", "2024.2", "JAVA");

        System.out.println("Установка ");
        for (Installable item : installables) {
            item.install();
        }

        System.out.println("\nОбновление ");
        for (Installable item : installables) {
            if (item instanceof Updatable up) {
                up.update();
                System.out.println("  версия: " + up.getVersion());
            }
        }

        System.out.println();
        Updatable.printInfo();
    }
}
