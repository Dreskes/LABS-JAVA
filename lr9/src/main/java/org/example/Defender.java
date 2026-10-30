package org.example;

public class Defender extends Sportsman {
    private int tackles;

    public Defender(String name, String team, int number, int tackles) {
        super(name, team, number);
        this.tackles = tackles;
    }

    public int getTackles() { return tackles; }
    public void setTackles(int tackles) { this.tackles = tackles; }

    @Override
    public String getPosition() {
        return "Защитник";
    }

    @Override
    public String getStatistics() {
        return tackles + " отборов, 10 перехватов";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  позиция: " + getPosition()
                + " | статистика: " + getStatistics());
    }
}