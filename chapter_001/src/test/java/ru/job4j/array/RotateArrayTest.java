package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for RotateArray class.
 *@author Prokopov Artem
 *@since 17.03.2017
 *@version 1.0
 */
public class RotateArrayTest {
    /**
     *Test for method "rotate".
     *The tested of the rotation of array clockwise, {{1, 2},{1, 2}}
     *The exepted result is {{1, 1}, {2, 2}}.
     */
    @Test
    public void whenRotateArray1212ThenArray1122() {
        int[][] array = {{1, 2}, {1, 2}};
		RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {{1, 1}, {2, 2}};
		assertThat(result, is(expected));
    }
	/**
     *Test for method "rotate".
     *The tested of the rotation of array clockwise, {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}
     *The exepted result is {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}.
     */
    @Test
    public void whenRotateArray123123123ThenArray111222333() {
        int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		assertThat(result, is(expected));
    }
	/**
     *Test for method "rotate".
     *The tested of the rotation of array clockwise, {{1, 2, 3, 4},
	 *											      {1, 2, 3, 4},
	 *											      {1, 2, 3, 4},
	 *                                                {1, 2, 3, 4}}
     *The exepted result is {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}}.
     */
    @Test
    public void whenRotateArray1234123412341234ThenArray1111222233334444() {
        int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotate(array);
        int[][] expected = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		assertThat(result, is(expected));
    }
/**
     *Test for method "rotateWithoutAddArray".
     *The tested of the rotation of array clockwise, {{1, 2},{1, 2}}
     *The exepted result is {{1, 1}, {2, 2}}.
     */
    @Test
    public void whenRotateWithoutAddArray1212ThenArray1122() {
        int[][] array = {{1, 2}, {1, 2}};
		RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutAddArray(array);
        int[][] expected = {{1, 1}, {2, 2}};
		assertThat(result, is(expected));
    }
	/**
     *Test for method "rotateWithoutAddArray".
     *The tested of the rotation of array clockwise, {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}
     *The exepted result is {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}.
     */
    @Test
    public void whenRotateWithoutAddArray123123123ThenArray111222333() {
        int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		RotateArray rotateArray = new RotateArray();
		int[][] result = rotateArray.rotateWithoutAddArray(array);
        int[][] expected = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		assertThat(result, is(expected));
    }
	/**
     *Test for method "rotateWithoutAddArray".
     *The tested of the rotation of array clockwise, {{1, 2, 3, 4},
	 *											      {1, 2, 3, 4},
	 *											      {1, 2, 3, 4},
	 *                                                {1, 2, 3, 4}}
     *The exepted result is {{1, 1, 1, 1}, {2, 2, 2, 2}, {3, 3, 3, 3}, {4, 4, 4, 4}}.
     */
    @Test
    public void whenRotateWithoutAddArray1234123412341234ThenArray1111222233334444() {
        int[][] array = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
		RotateArray rotateArray = new RotateArray();
        int[][] result = rotateArray.rotateWithoutAddArray(array);
        int[][] expected = {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
		assertThat(result, is(expected));
    }
}
