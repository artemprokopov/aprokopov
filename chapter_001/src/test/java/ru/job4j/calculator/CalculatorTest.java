package ru.job4j.calculator;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Tests for Calculator class is implements simple calculator.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */
public class CalculatorTest {
    /**
     *Test for method add.
     *Tested the result of the operation 1 + 1.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     *Test for method Substruct.
     *Tested the result of the operation 2 - 1.
     */
    @Test
    public void whenSubstructTwoMinusOneThenOne() {
	Calculator calc = new Calculator();
	calc.substruct(2D, 1D);
	double result = calc.getResult();
	double exepected = 1D;
	assertThat(result, is(exepected));
    }
    /**
     *Test for method Div.
     *Tested the result of the operation 4 / 2.
     */
    @Test
    public void whenDivFourDivideTwoThenTwo() {
	Calculator calc = new Calculator();
	calc.div(4D, 2D);
	double result = calc.getResult();
	double exepected = 2D;
	assertThat(result, is(exepected));
    }
    /**
     *Test for method multiple.
     *Tested the result of the operation 2 * 2.
     */
    @Test
    public void whenMultipleTwoMultiplyTwoThenFour() {
	Calculator calc = new Calculator();
	calc.multiple(2D, 2D);
	double result = calc.getResult();
	double exepected = 4D;
	assertThat(result, is(exepected));
    }
}
