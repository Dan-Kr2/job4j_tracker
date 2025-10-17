package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        for (int i = 0; i < left.length() && i < right.length(); i++) {
            char a = left.charAt(i);
            char b = right.charAt(i);

            if (Character.compare(a, b) != 0) {
                return Character.compare(a, b);
            }
        }
        return Integer.compare(left.length(), right.length());
    }
}