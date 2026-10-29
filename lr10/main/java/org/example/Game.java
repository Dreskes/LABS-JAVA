package org.example;

public class Game implements Installable, Updatable {
    private String name;
    private String version;
    private String genre;

    public Game(String name, String version, String genre) {
        this.name = name;
        this.version = version;
        this.genre = genre;
    }

    public String getName() { return name; }
    public String getGenre() { return genre; }

    public void setName(String name) { this.name = name; }
    public void setGenre(String genre) { this.genre = genre; }

    @Override
    public void install() {
        System.out.println("Игра \"" + name + "\" устанавливается (50 ГБ)");
    }

    @Override
    public void uninstall() {
        System.out.println("Игра \"" + name + "\" удалена");
    }

    @Override
    public void update() {
        System.out.println("Игра \"" + name + "\" обновляется до новой версии");
    }

    @Override
    public String getVersion() {
        return version;
    }
}