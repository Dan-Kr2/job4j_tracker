package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindAllAction;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class FindAllActionTest {
    @Test
    void whenItemsExistThenShowAll() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindAllAction(output).execute(null, tracker);
        String expected = "=== Вывод всех заявок ===" + System.lineSeparator() + item.toString() + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenNoItemsThenShowEmptyMessage() {
        Output output = new StubOutput();
        new FindAllAction(output).execute(null, new Tracker());
        String expected = "=== Вывод всех заявок ===" + System.lineSeparator() + "Хранилище еще не содержит заявок" + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }
}
