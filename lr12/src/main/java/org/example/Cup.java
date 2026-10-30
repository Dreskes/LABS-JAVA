package org.example;

public class Cup extends Dish {
    private boolean handle;

    public Cup(String name, int id, double volume, boolean handle) {
        super(name, id, volume);
        this.handle = handle;
    }

    public boolean isHandle() { return handle; }
    public void setHandle(boolean handle) { this.handle = handle; }

    @Override
    public String toString() {
        return "Cup{name='" + getName() + "', id=" + getId()
                + ", volume=" + getVolume()
                + ", handle=" + handle + "}";
    }
}