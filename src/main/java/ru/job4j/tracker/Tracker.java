package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] clone = new Item[items.length];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items[i].getName())) {
                clone[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(clone, j);
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            item.setId(id);
            items[index] = item;
        }
        return result;
    }

    public void delete(int id) {
        int i2 = indexOf(id);
        boolean result2 = i2 != -1;
        if (result2) {
            System.arraycopy(items, i2 + 1, items, i2, size - i2 - 1);
            items[size] = null;
            size--;
        }
    }
}
