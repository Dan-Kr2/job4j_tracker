package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> myNames = new ArrayList<>();
        myNames.add("Petr");
        myNames.add("Ivan");
        myNames.add("Stepan");

        for (Object value : myNames) {
            System.out.println(value);
        }
    }
}
