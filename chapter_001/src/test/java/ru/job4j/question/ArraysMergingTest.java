package ru.job4j.question;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for ArraysMerging class.
 *@author Prokopov Artem
 *@since 28.03.2017
 *@version 1.0
 */
public class ArraysMergingTest {
     /**
     *Test for method "merge".
     *Test the merge of the ordered arrays in one ordered array,
     *{4, 7, 8, 10, 115} and {1, 4, 5, 56, 90}.
     *The exepted result is {1, 4, 4, 5, 7, 8, 10, 56, 90, 115}.
     */
    @Test
    public void whenArrayOneFiveNumbersAndArrayTwoFiveNumbersThenMergeArray() {
        int[] arrayOne = {4, 7, 8, 10, 115};
	int[] arrayTwo = {1, 4, 5, 56, 90};
	ArraysMerging arrayMerge = new ArraysMerging();
        int[] result = arrayMerge.merge(arrayOne, arrayTwo);
	int[] expected = {1, 4, 4, 5, 7, 8, 10, 56, 90, 115};
	assertThat(result, is(expected));
    }
    /**
     *Test for method "merge".
     *Test the merge of the ordered arrays in one ordered array,
     *{1, 4, 7, 8, 10, 115, 120} and {1, 4, 5, 56, 90}.
     *The exepted result is {1, 1, 4, 4, 5, 7, 8, 10, 56, 90, 115, 120}.
     */
    @Test
    public void whenArrayOneSevenNumbersAndArrayTwoFiveNumbersThenMergeArray() {
        int[] arrayOne = {1, 4, 7, 8, 10, 115, 120};
	int[] arrayTwo = {1, 4, 5, 56, 90};
	ArraysMerging arrayMerge = new ArraysMerging();
        int[] result = arrayMerge.merge(arrayOne, arrayTwo);
	int[] expected = {1, 1, 4, 4, 5, 7, 8, 10, 56, 90, 115, 120};
	assertThat(result, is(expected));
    }
     /**
     *Test for method "merge".
     *Test the merge of the ordered arrays in one ordered array,
     *{1, 4} and {1, 4, 5, 56, 90}.
     *The exepted result is {1, 1, 4, 4, 5, 56, 90}.
     */
    @Test
    public void whenArrayOneTwoNumbersAndArrayTwoFiveNumbersThenMergeArray() {
        int[] arrayOne = {1, 4};
	int[] arrayTwo = {1, 4, 5, 56, 90};
	ArraysMerging arrayMerge = new ArraysMerging();
        int[] result = arrayMerge.merge(arrayOne, arrayTwo);
	int[] expected = {1, 1, 4, 4, 5, 56, 90};
	assertThat(result, is(expected));
    }
     /**
     *Test for method "merge".
     *Test the merge of the ordered arrays in one ordered array,
     *{1, 4, 5, 56, 90} and {15}.
     *The exepted result is {1, 4, 5, 15, 56, 90}.
     */
    @Test
    public void whenArrayOneFiveNumbersAndArrayTwoOneNumbersThenMergeArray() {
        int[] arrayOne = {1, 4, 5, 56, 90};
	int[] arrayTwo = {15};
	ArraysMerging arrayMerge = new ArraysMerging();
        int[] result = arrayMerge.merge(arrayOne, arrayTwo);
	int[] expected = {1, 4, 5, 15, 56, 90};
	assertThat(result, is(expected));
    }
}
