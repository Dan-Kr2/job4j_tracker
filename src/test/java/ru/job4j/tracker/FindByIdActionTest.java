package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class FindByIdActionTest {
    @Test
    void whenItemFoundThenShowIt() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Test"));
        new FindByIdAction(output).execute(new MockInput(new String[]{String.valueOf(item.getId())}), tracker);
        assertThat(output.toString()).contains("=== Вывод заявки по id ===", item.toString());
    }

    @Test
    void whenItemNotFoundThenShowMessage() {
        Output output = new StubOutput();
        new FindByIdAction(output).execute(new MockInput(new String[]{"999"}), new Tracker());
        assertThat(output.toString()).contains("Заявка с введенным id: 999 не найдена.");
    }
}