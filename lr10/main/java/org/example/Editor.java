package org.example;

public class Editor implements Installable, Updatable {
    private String name;
    private String version;
    private String format;

    public Editor(String name, String version, String format) {
        this.name = name;
        this.version = version;
        this.format = format;
    }

    public String getName() { return name; }
    public String getFormat() { return format; }

    public void setName(String name) { this.name = name; }
    public void setFormat(String format) { this.format = format; }

    @Override
    public void install() {
        System.out.println("Редактор \"" + name + "\" устанавливается (5 ГБ)");
    }

    @Override
    public void uninstall() {
        System.out.println("Редактор \"" + name + "\" удалён");
    }

    @Override
    public void update() {
        System.out.println("Редактор \"" + name + "\" обновляется до новой версии");
    }

    @Override
    public String getVersion() {
        return version;
    }
}