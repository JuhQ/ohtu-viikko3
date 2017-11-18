package ohtu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Submission {
    private int week;
    private int hours;
    private int maksimi;
    private ArrayList<Integer> exercises;
    // {"week":1,"hours":3,"exercises":[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]}
    public void setWeek(int week) {
        this.week = week;
    }

    public void setMaksimi(int maksimi) {
        this.maksimi = maksimi;
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
        // viikko 2:
        // tehtyjä tehtäviä yhteensä: 6 (maksimi 8), aikaa kului 4 tuntia, tehdyt tehtävät: 1 2 3 6 7 8

        String done = exercises.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(","));

        return "viikko " + week + ":\n" +
        "tehtyjä tehtäviä yhteensä: " + exercises.size() + " (maksimi " + maksimi + "), aikaa kului " + hours + " tuntia, tehdyt tehtävät: " + done;
    }

}