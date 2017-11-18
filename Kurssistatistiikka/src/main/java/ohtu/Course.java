package ohtu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Course {
    private String name;
    private String term;
    private int week;
    private ArrayList<Integer> exercises;
    // {"_id":"59f883227655fe0034b4dfe5","name":"Ohjelmistotuotanto","term":"syksy 2017","url":"https://github.com/mluukkai/ohjelmistotuotanto2017/wiki/Ohjelmistotuotanto-syksy-2017","week":3,"enabled":true,"__v":3,"exercises":[17,13,13,13,10]}

    public ArrayList<Integer> getExercises() {
      return exercises;
    }

    @Override
    public String toString() {
      return this.getExercises().toString();
    }
}