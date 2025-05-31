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
        Item[] clone = new Item[items.length];
        int j = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                clone[j] = items[i];
                j++;
            }
        }
        return Arrays.copyOf(clone, j);
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
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        item.setId(id);
        items[i] = item;
        return true;
    }

    public void delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return;
        }
        int start = index + 1;
        int fin = size - index - 1;

        if (fin > 0) {
            System.arraycopy(items, start, items, index, fin);
        }
        items[size - 1] = null;
        size--;
    }
}
