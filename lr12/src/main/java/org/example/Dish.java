package org.example;

public class Dish {
    private String name;
    private int id;
    private double volume;

    public Dish(String name, int id, double volume) {
        this.name = name;
        this.id = id;
        this.volume = volume;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public double getVolume() { return volume; }

    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setVolume(double volume) { this.volume = volume; }

    @Override
    public String toString() {
        return String.format("Dish{name='%s', id=%d, volume=%.1f}",
                name, id, volume);
    }
}