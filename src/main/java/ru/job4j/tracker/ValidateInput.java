package ru.job4j.tracker;

import ru.job4j.tracker.output.Output;

public class ValidateInput implements Input {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                String result = input.askStr(question);
                value = Integer.parseInt(result);
                invalid = false;
            } catch (NumberFormatException a) {
                output.println("Пожалуйста, введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}