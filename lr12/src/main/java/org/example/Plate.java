package org.example;

public class Plate extends Dish {
    private double diameter;

    public Plate(String name, int id, double volume, double diameter) {
        super(name, id, volume);
        this.diameter = diameter;
    }

    public double getDiameter() { return diameter; }
    public void setDiameter(double diameter) { this.diameter = diameter; }

    @Override
    public String toString() {
        return "Plate{name='" + getName() + "', id=" + getId()
                + ", volume=" + getVolume()
                + ", diameter=" + diameter + "}";
    }
}