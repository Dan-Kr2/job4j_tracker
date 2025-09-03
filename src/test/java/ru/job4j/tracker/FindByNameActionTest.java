package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindByNameAction;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class FindByNameActionTest {
    @Test
    void whenItemFoundThenShowIt() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindByNameAction(output).execute(new MockInput(new String[]{"Test"}), tracker);
        String expected = "=== Вывод заявок по имени ===" + System.lineSeparator() + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemNotFoundThenShowMessage() {
        Output output = new StubOutput();
        new FindByNameAction(output).execute(new MockInput(new String[]{"Unknown"}), new Tracker());
        String expected = "=== Вывод заявок по имени ===" + System.lineSeparator() + "Заявки с именем: Unknown не найдены." + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }
}
