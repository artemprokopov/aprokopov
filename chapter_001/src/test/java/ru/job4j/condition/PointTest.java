package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Tests for Point class is implements point on the coordinate plane.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */
public class PointTest {
    /**
     *Test for method "is".
     *Tested the result of the  method "is" for the function y(x) = 2 * x + 1(a = 2, b = 1).
     *The point coordinate x = 1, y = 3.
     *The exepted result is true.
     */
    @Test
    public void whenIsTwoAndOneThenTrue() {
        Point point = new Point(1, 3);
        boolean result = point.is(2, 1);
        boolean expected = true;
        assertThat(result, is(expected));
    }
    /**
     *Test for method "is".
     *Tested the result of the  method "is" for the function y(x) = 2 * x + 1(a = 2, b = 1).
     *The point coordinate x = 2, y = 3.
     *The exepted result is false.
     */
    @Test
    public void whenIsTwoAndOneThenFalse() {
        Point point = new Point(2, 3);
        boolean result = point.is(2, 1);
        boolean expected = false;
        assertThat(result, is(expected));
    }
    /**
     *Test for method "is".
     *Tested the resultof the method "is" for the function y(x) = 4 * x - 5(a = 4, b = -5).
     *The point coordinate x = 2, y = 6.
     *The exepted result is false.
     */
    @Test
    public void whenIsFourAndMinusFiveThenFalse() {
	Point point = new Point(2, 6);
        boolean result = point.is(4, -5);
        boolean expected = false;
        assertThat(result, is(expected));
    }
     /**
     *Test for method "is".
     *Tested the resultof the method "is" for the function y(x) = 4 * x - 5(a = 4, b = -5).
     *The point coordinate x = 2, y = 3.
     *The exepted result is true.
     */
    @Test
    public void whenIsFourAndMinusFiveThenTrue() {
	Point point = new Point(2, 3);
        boolean result = point.is(4, -5);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}
