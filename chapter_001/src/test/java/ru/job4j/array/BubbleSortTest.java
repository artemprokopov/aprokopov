package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for BubbleSort class.
 *@author Prokopov Artem
 *@since 17.03.2017
 *@version 1.0
 */
public class BubbleSortTest {
    /**
     *Test for method "sort".
     *Test the rotation of the array in the opposite direction, {5, 3, 2, 4, 1}
     *The exepted result is {1, 2, 3, 4, 5}.
     */
    @Test
    public void whenArray53241ThenArray12345() {
        int[] array = {5, 3, 2, 4, 1};
		BubbleSort t = new BubbleSort();
        int[] result = t.sort(array);
        int[] expected = {1, 2, 3, 4, 5};
	assertThat(result, is(expected));
    }
     /**
     *Test for method "sort".
     *Test the rotation of the array in the opposite direction, {3, 2, 1, 6, 5, 4}
     *The exepted result is {1, 2, 3, 4, 5, 6}.
     */
    @Test
    public void whenArray321654ThenArray123456() {
        int[] array = {3, 2, 1, 6, 5, 4};
		BubbleSort t = new BubbleSort();
        int[] result = t.sort(array);
        int[] expected = {1, 2, 3, 4, 5, 6};
	assertThat(result, is(expected));
    }
}
