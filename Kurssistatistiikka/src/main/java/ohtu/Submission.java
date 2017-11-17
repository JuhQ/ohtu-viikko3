package ohtu;

import java.util.ArrayList;

public class Submission {
    private int week;
    private int hours;
    private ArrayList<Integer> exercises;
    // {"week":1,"hours":3,"exercises":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]}
    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    public ArrayList<Integer> getExercises() {
        return exercises;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + exercises.size() + ", aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + exercises;
    }

}