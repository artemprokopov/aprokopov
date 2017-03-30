package ru.job4j.test;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for BubbleSort class.
 *@author Prokopov Artem
 *@since 30.03.2017
 *@version 1.0
 */
public class ContainsStringTest {
    /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "t str".
     *The exepted result is true.
     */
    @Test
    public void whenStringTestStringAndTStrThenTrue() {
        String originString = "Test string";
	String subString = "t str";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = true;
	assertThat(result, is(expected));
    }
     /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "ings".
     *The exepted result is false.
     */
    @Test
    public void whenStringTestStringAndIngsThenFalse() {
        String originString = "Test string";
	String subString = "ings";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = false;
	assertThat(result, is(expected));
    }
    /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "Test strings".
     *The exepted result is false.
     */
    @Test
    public void whenStringTestStringAndTestStringsThenFalse() {
        String originString = "Test string";
	String subString = "Test strings";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = false;
	assertThat(result, is(expected));
    }
    /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "Test".
     *The exepted result is true.
     */
    @Test
    public void whenStringTestStringAndTestThenTrue() {
        String originString = "Test string";
	String subString = "Test";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = true;
	assertThat(result, is(expected));
    }
     /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "ing".
     *The exepted result is true.
     */
    @Test
    public void whenStringTestStringAndIngThenTrue() {
        String originString = "Test string";
	String subString = "ing";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = true;
	assertThat(result, is(expected));
    }
     /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "Test string".
     *The exepted result is true.
     */
    @Test
    public void whenStringTestStringAndTestStringThenTrue() {
        String originString = "Test string";
	String subString = "Test string";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = true;
	assertThat(result, is(expected));
    }
     /**
     *Test for method "contains".
     *Test the checks whether a string is a substring of the given string, "Test string" and "1Test strings".
     *The exepted result is false.
     */
    @Test
    public void whenStringTestStringAnd1TestStringsThenFalse() {
        String originString = "Test string";
	String subString = "1Test strings";
	ContainsString contain = new ContainsString();
        boolean result = contain.contains(originString, subString);
        boolean expected = false;
	assertThat(result, is(expected));
    }
}
