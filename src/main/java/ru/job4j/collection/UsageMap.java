package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> newMap = new HashMap<>();
        newMap.put("po4ta@gmail.com", "fio");
        newMap.put("po4ta@yandex.ru", "fio2");
        newMap.put("tozepo4ta@gmail.ru", "fio3");
        newMap.put("po4ta@gmail.com", "New fio");

        for (String key : newMap.keySet()) {
            String value = newMap.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
