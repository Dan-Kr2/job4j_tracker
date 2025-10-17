package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JobAscByNameTest {
    @Test
    public void test() {
        Job job1 = new Job("Beta", 1);
        Job job2 = new Job("Alpha", 2);

        int result = new JobAscByName().compare(job1, job2);

        assertThat(result).isGreaterThan(0);
    }
}