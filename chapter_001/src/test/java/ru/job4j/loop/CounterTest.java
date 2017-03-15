package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Tests for Counter class.
 *@author Prokopov Artem
 *@since 15.03.2017
 *@version 1.0
 */
public class CounterTest {
    /**
     *Test for method "add".
     *Tested the result of the  method "add" for the range of numder 1..10.
     *The exepted result is 30.
     */
    @Test
    public void whenAddOneToTenThenThirty() {
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        int expected = 30;
        assertThat(result, is(expected));
    }
	/**
     *Test for method "add".
     *Tested the result of the  method "add" for the range of numder 15..21.
     *The exepted result is 54.
     */
    @Test
    public void whenAddFifteenToTwentyOneThenFiftyFour() {
        Counter counter = new Counter();
        int result = counter.add(15, 21);
        int expected = 54;
        assertThat(result, is(expected));
    }
}
