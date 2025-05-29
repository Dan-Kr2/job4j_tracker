package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;
        int first = index;
        int second = index + 1;
        while (second < products.length) {
            products[first] = products[second];
            first++;
            second++;
            }
        products[products.length - 1] = null;
        return products;
    }
}