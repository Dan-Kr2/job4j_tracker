package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FindAllActionTest {
    @Test
    void whenItemsExistThenShowAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindAllAction(output).execute(null, tracker);
        assertThat(output.toString()).contains("=== Вывод всех заявок ===", item.toString());
    }

    @Test
    void whenNoItemsThenShowEmptyMessage() {
        Output output = new StubOutput();
        new FindAllAction(output).execute(null, new Tracker());
        assertThat(output.toString()).contains("Хранилище еще не содержит заявок");
    }
}