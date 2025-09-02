package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddDubl() {
        Citizen firstCitizen = new Citizen("12345", "Ivan Ivanov");
        Citizen duplicateCitizen = new Citizen("12345", "Petr Petrov");
        PassportOffice office = new PassportOffice();
        office.add(firstCitizen);
        boolean result = office.add(duplicateCitizen);
        assertThat(result).isFalse();
    }
}