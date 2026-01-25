package ru.job4j.collection;

import java.util.Comparator;

import static java.lang.Math.min;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] a = left.split("/");
        String[] b = right.split("/");
        int result = b[0].compareTo(a[0]);
        return result != 0 ? result : left.compareTo(right);
    }
}