package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for Turn class.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */
public class TurnTest {
    /**
     *Test for method "back".
     *Test the rotation of the array in the opposite direction, {5, 4, 3, 2, 1}
     *The exepted result is {1, 2, 3, 4, 5}.
     */
    @Test
    public void whenArray54321ThenArray12345() {
        int[] array = {5, 4, 3, 2, 1};
	Turn t = new Turn();
        int[] result = t.back(array);
        int[] expected = {1, 2, 3, 4, 5};
	assertThat(result, is(expected));
    }
     /**
     *Test for method "back".
     *Test the rotation of the array in the opposite direction, {3, 2, 1, 6, 5, 4}
     *The exepted result is {4, 5, 6, 1, 2, 3}.
     */
    @Test
    public void whenArray654321ThenArray123456() {
        int[] array = {3, 2, 1, 6, 5, 4};
	Turn t = new Turn();
        int[] result = t.back(array);
        int[] expected = {4, 5, 6, 1, 2, 3};
	assertThat(result, is(expected));
    }
}