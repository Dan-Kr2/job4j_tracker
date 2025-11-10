package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StudentLevelTest {
    @Test
    public void whenSortedScore20() {
        List<Student2> input = new ArrayList<>();
        input.add(new Student2(28, "Masha"));
        input.add(new Student2(128, "Petya"));
        input.add(new Student2(97, "Andrey"));
        List<Student2> expected = List.of(
                new Student2(128, "Petya"),
                new Student2(97, "Andrey"),
                new Student2(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expected);
    }

    @Test
    public void whenSortedScore20HasNull() {
        List<Student2> input = new ArrayList<>();
        input.add(null);
        input.add(new Student2(28, "Masha"));
        input.add(null);
        input.add(new Student2(128, "Petya"));
        input.add(null);
        input.add(new Student2(97, "Andrey"));
        input.add(null);
        List<Student2> expected = List.of(
                new Student2(128, "Petya"),
                new Student2(97, "Andrey"),
                new Student2(28, "Masha")
        );
        assertThat(StudentLevel.levelOf(input, 20)).containsSequence(expected);
    }

    @Test
    public void whenSortedScore65() {
        List<Student2> input = new ArrayList<>();
        input.add(new Student2(46, "Masha"));
        input.add(new Student2(101, "Petya"));
        input.add(new Student2(32, "Andrey"));
        input.add(new Student2(84, "Boris"));
        input.add(new Student2(78, "Yana"));
        input.add(new Student2(65, "Nikolai"));
        List<Student2> expected = List.of(
                new Student2(101, "Petya"),
                new Student2(84, "Boris"),
                new Student2(78, "Yana"),
                new Student2(65, "Nikolai")
        );
        assertThat(StudentLevel.levelOf(input, 65)).containsSequence(expected);
    }

    @Test
    public void whenOnlyNull() {
        List<Student2> input = new ArrayList<>();
        input.add(null);
        input.add(null);
        input.add(null);
        List<Student2> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 20)).containsAll(expected);
    }
}