package ru.job4j.input.output;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object object) {
        System.out.println(object);
    }
}