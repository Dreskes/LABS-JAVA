package org.example;

public class Piano extends Instrument {
    private int keys;

    public Piano(String name, String type, String sound, int keys) {
        super(name, type, sound);
        this.keys = keys;
    }

    public int getKeys() { return keys; }
    public void setKeys(int keys) { this.keys = keys; }

    @Override
    public String getSoundType() {
        return "Клавишный звук";
    }

    public void play(String melody, int tempo) {
        System.out.println("Пианино играет мелодию " + melody
                + " в темпе " + tempo);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  клавиш: " + keys
                + " | тип звука: " + getSoundType());
    }
}