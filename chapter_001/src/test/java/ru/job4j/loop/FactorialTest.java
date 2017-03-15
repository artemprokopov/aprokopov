package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Tests for Factorial class.
 *@author Prokopov Artem
 *@since 15.03.2017
 *@version 1.0
 */
public class FactorialTest {
    /**
     *Test for method "calc".
     *Tested the result of the  method "calc" for the  number 5.
     *The exepted result is 120.
     */
    @Test
    public void whenCalcFiveThenOneHundredTwenty() {
        Factorial f = new Factorial();
        int result = f.calc(5);
        int expected = 120;
        assertThat(result, is(expected));
    }
	/**
     *Test for method "calc".
     *Tested the result of the  method "calc" for the  number 0.
     *The exepted result is 1.
     */
    @Test
    public void whenCalcZeroThenOne() {
        Factorial f = new Factorial();
        int result = f.calc(0);
        int expected = 1;
        assertThat(result, is(expected));
    }
	/**
     *Test for method "calc".
     *Tested the result of the  method "calc" for the  number -1.
     *The exepted result is 0.
     */
    @Test
    public void whenCalcMinusOneThenZero() {
        Factorial f = new Factorial();
        int result = f.calc(-1);
        int expected = 0;
        assertThat(result, is(expected));
    }
}
