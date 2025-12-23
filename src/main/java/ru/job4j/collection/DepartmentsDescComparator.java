package ru.job4j.collection;

import java.util.Comparator;

import static java.lang.Math.min;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String[] a = left.split("/");
        String[] b = right.split("/");
        int r = min(a.length, b.length);
        int h = 0;
        for (int i = 0; i < r; i++) {
            int s = a[i].compareTo(b[i]);
            if (h == 0 && s != 0) {
                return (i == 0) ? -s : s;
            }
        }
        if (a.length != b.length) {
            return a.length - b.length;
        }
        return 0;
    }
}