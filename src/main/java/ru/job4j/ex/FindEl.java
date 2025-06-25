package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int index = 0;
        for (String str : value) {
            if (key.equals(str)) {
                return index;
            }
            index++;
        }
        throw new ElementNotFoundException("Элемент '" + key + "' не найден в массиве");
    }

    public static void main(String[] args) {
        String[] data = {"alfa", "beta", "gamma", "delta"};
        String key = "omega";

        try {
            int index = indexOf(data, key);
            System.out.println("Индекс элемента '" + key + "': " + index);
        } catch (ElementNotFoundException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}