package ru.job4j.pojo;

import com.sun.source.tree.BreakTree;

public class Shop {
    public static int indexOfNull(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product == null) {
                return i;
            }
        } return -1;
    }
}