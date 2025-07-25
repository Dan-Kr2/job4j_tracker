package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Factorial.calc(-10);
                });
        assertThat(exception.getMessage()).isEqualTo("Number must be non-negative");
    }

    @Test
    public void whenCalculateFactorialFor5Then120() {
        int expected = 120;
        int actual = Factorial.calc(5);
        assertThat(actual).isEqualTo(expected);
    }
}