package org.advent.day1;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class TestElfShould {
    @Test
    void have_zero_total_calories_when_created() {
        Elf elf = new Elf();
        assertThat(elf.getTotalCalories(), equalTo(0));
    }

    @Test
    void have_1000_total_calories_after_adding_1000() {
        final Elf elf = new Elf();
        elf.addCalories(1000);
        assertThat(elf.getTotalCalories(), equalTo(1000));       
    }

    @Test
    void compare_return_positive_value_for_elf_with_more_total_calories() {
        final Elf elf1 = givenAnElfWithCalories(1000);
        final Elf elf2 = givenAnElfWithCalories(999);

        assertThat(elf1.compareTo(elf2), greaterThan(0));
    }

    @Test
    void compare_zero_for_equal_elf() {
        final Elf elf1 = givenAnElfWithCalories(1000);
        final Elf elf2 = givenAnElfWithCalories(1000);

        assertThat(elf1.compareTo(elf2), equalTo(0));
    }

    @Test
    void compare_return_negative_value_for_elf_with_less_total_calories() {
        final Elf elf1 = givenAnElfWithCalories(999);
        final Elf elf2 = givenAnElfWithCalories(1000);

        assertThat(elf1.compareTo(elf2), lessThan(0));
    }

    private static Elf givenAnElfWithCalories(final int calories) {
        final Elf elf = new Elf();
        elf.addCalories(calories);
        return elf;
    }
}
