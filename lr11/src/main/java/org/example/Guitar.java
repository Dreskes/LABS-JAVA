package org.example;

public class Guitar extends Instrument {
    private int strings;

    public Guitar(String name, String type, String sound, int strings) {
        super(name, type, sound);
        this.strings = strings;
    }

    public int getStrings() { return strings; }
    public void setStrings(int strings) { this.strings = strings; }

    @Override
    public String getSoundType() {
        return "Струнный звук";
    }

    public void play(int volume, String melody) {
        System.out.println("Гитара играет мелодию " + melody
                + " громкостью " + volume);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  струн: " + strings
                + " | тип звука: " + getSoundType());
    }
}