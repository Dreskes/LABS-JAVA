package org.example;

public class Forward extends Sportsman {
    private int goals;

    public Forward(String name, String team, int number, int goals) {
        super(name, team, number);
        this.goals = goals;
    }

    public int getGoals() { return goals; }
    public void setGoals(int goals) { this.goals = goals; }

    @Override
    public String getPosition() {
        return "Нападающий";
    }

    @Override
    public String getStatistics() {
        return goals + " голов, 5 передач";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("  позиция: " + getPosition()
                + " | статистика: " + getStatistics());
    }
}