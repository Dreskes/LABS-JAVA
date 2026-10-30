package org.example;

public class Bowl extends Dish {
    private double depth;

    public Bowl(String name, int id, double volume, double depth) {
        super(name, id, volume);
        this.depth = depth;
    }

    public double getDepth() { return depth; }
    public void setDepth(double depth) { this.depth = depth; }

    @Override
    public String toString() {
        return "Bowl{name='" + getName() + "', id=" + getId()
                + ", volume=" + getVolume()
                + ", depth=" + depth + "}";
    }
}