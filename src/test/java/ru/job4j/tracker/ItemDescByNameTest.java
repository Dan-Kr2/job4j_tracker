package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenSortAscending() {

        List<Item> items = Arrays.asList(
                new Item("Lambda"),
                new Item("Alpha"),
                new Item("Beta")
        );

        List<Item> expected = Arrays.asList(
                new Item("Alpha"),
                new Item("Beta"),
                new Item("Lambda")
        );

        Collections.sort(items, new ItemDescByName());

        assertThat(items.get(0).getName()).isEqualTo("Lambda");
        assertThat(items.get(1).getName()).isEqualTo("Beta");
        assertThat(items.get(2).getName()).isEqualTo("Alpha");
    }
}