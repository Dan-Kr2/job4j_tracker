package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.FindByIdAction;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class FindByIdActionTest {
    @Test
    void whenItemFoundThenShowIt() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindByIdAction(output).execute(new MockInput(new String[]{String.valueOf(item.getId())}), tracker);
        String expected = "=== Вывод заявки по id ===" + System.lineSeparator() + item + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenItemNotFoundThenShowMessage() {
        Output output = new StubOutput();
        new FindByIdAction(output).execute(new MockInput(new String[]{"999"}), new Tracker());
        String expected = "=== Вывод заявки по id ===" + System.lineSeparator() + "Заявка с введенным id: 999 не найдена." + System.lineSeparator();
        assertThat(output.toString()).isEqualTo(expected);
    }
}
