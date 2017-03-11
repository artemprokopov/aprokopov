package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Tests for Max class is implements a method that returns the maximum of the two number.
 *@author Prokopov Artem
 *@since 11.03.2017
 *@version 1.0
 */
public class MaxTest {
    /**
     *Test for method max.
     *Tested method max with two parametrs 2 and 1;
     */
    @Test
    public void whenMaxTwoAndOneThenTwo() {
        Max max = new Max();
	int result = max.max(2, 1);
	int expected = 2;
        assertThat(result, is(expected));
    }
    /**
     *Test for method max.
     *Tested method max with two parametrs 1 and 4;
     */
    @Test
    public void whenMaxOneAndFourThenFour() {
	Max max = new Max();
	int result = max.max(1, 4);
	int expected = 4;
        assertThat(result, is(expected));
    }
    /**
     *Test for method max.
     *Tested method max with two parametrs 4 and 4;
     */
    @Test
    public void whenMaxFourAndFourThenFour() {
	Max max = new Max();
	int result = max.max(4, 4);
	int expected = 4;
        assertThat(result, is(expected));
    }
}
