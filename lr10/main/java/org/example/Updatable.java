package org.example;

public interface Updatable {
    void update();
    String getVersion();

    static void printInfo() {
        System.out.println("Интерфейс Updatable: обновление ПО");
    }
}