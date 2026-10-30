package org.example;

public class Instrument {
    private String name;
    private String type;
    private String sound;

    public Instrument(String name, String type, String sound) {
        this.name = name;
        this.type = type;
        this.sound = sound;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getSound() { return sound; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setSound(String sound) { this.sound = sound; }

    public void play() {
        System.out.println("Играю");
    }

    public void play(int volume) {
        System.out.println("Играю громкостью " + volume);
    }

    public void play(String melody) {
        System.out.println("Играю мелодию " + melody);
    }

    public String getSoundType() {
        return "Стандартный звук";
    }

    public void displayInfo() {
        System.out.println("Инструмент: " + name
                + " | тип: " + type
                + " | звук: " + sound);
    }
}