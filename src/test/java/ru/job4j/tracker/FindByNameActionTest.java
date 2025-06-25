package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.action.FindByNameAction;
import ru.job4j.input.MockInput;
import ru.job4j.input.output.Output;
import ru.job4j.input.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class FindByNameActionTest {
    @Test
    void whenItemFoundThenShowIt() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindByNameAction(output).execute(new MockInput(new String[]{"Test"}), tracker);
        assertThat(output.toString()).contains("=== Вывод заявок по имени ===", item.toString());
    }

    @Test
    void whenItemNotFoundThenShowMessage() {
        Output output = new StubOutput();
        new FindByNameAction(output).execute(new MockInput(new String[]{"Unknown"}), new Tracker());
        assertThat(output.toString()).contains("Заявки с именем: Unknown не найдены.");
    }
}