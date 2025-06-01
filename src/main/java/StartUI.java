import ru.job4j.tracker.Item;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item myItem = new Item();
        LocalDateTime created = myItem.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String formattedDate = created.format(formatter);
        System.out.println("Дата создания: " + formattedDate);

    }
}
