package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] numbers1 = left.split("\\.");
        String[] numbers2 = right.split("\\.");

        int number1 = Integer.parseInt(numbers1[0]);
        int number2 = Integer.parseInt(numbers2[0]);

        return Integer.compare(number1, number2);
    }
}