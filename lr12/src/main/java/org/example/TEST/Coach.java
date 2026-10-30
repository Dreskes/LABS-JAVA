package org.example.TEST;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private int id;
    private String name;
    private String sport;
    private int level;
    private List<Integer> athleteRatings;

    public Coach(int id, String name, String sport, int level,
                 List<Integer> athleteRatings) {
        this.id = id;
        this.name = name;
        this.sport = sport;
        this.level = level;
        this.athleteRatings = new ArrayList<>(athleteRatings);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getSport() { return sport; }
    public int getLevel() { return level; }
    public List<Integer> getAthleteRatings() {
        return athleteRatings;
    }

    public void setLevel(int level) { this.level = level; }

    public double getAverageRating() {
        if (athleteRatings.isEmpty()) return 0;
        double sum = 0;
        for (int r : athleteRatings) sum += r;
        return sum / athleteRatings.size();
    }

    @Override
    public String toString() {
        return String.format("Coach{id=%d, name='%s', sport='%s', level=%d, avg=%.2f}",
                id, name, sport, level, getAverageRating());
    }
}