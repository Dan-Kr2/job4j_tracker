package ru.job4j.tracker;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ItemAscByNameTest {
    @Test
    public void whenSortDescending() {

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

        Collections.sort(items, new ItemAscByName());

        assertThat(items.get(0).getName()).isEqualTo("Alpha");
        assertThat(items.get(1).getName()).isEqualTo("Beta");
        assertThat(items.get(2).getName()).isEqualTo("Lambda");
    }
}