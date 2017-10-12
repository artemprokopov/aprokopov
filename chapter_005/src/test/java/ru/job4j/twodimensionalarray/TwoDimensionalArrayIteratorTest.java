package ru.job4j.twodimensionalarray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Test class for TwoDimensionArrayIterator class.
 * @author Artem Prokopov
 * @version 1.0
 * @since 10/10/2017
 */
public class TwoDimensionalArrayIteratorTest {
    /**
     * Test array.
     */
    private Integer[][] testArray = new Integer[][]{{1, 2}, {3, 4, 5}, {6, 7, 8, 9}};
    /**
     * Expected array.
     */
    private Integer[] expectedArray = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * Tests iterator for two dimension array.
     * Create an iterator for testArray, expected iterator of the while loop
     * returns all the elements testArray, these items Add in ArrayList.
     */
    @Test
    public void getIteratorTest() {
        ArrayList<Integer> result = new ArrayList<>();
        Iterator<Integer> iterator = TwoDimensionalArrayIterator.getIterator(testArray);
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        assertArrayEquals(expectedArray, result.toArray(new Integer[result.size()]));
    }

    /**
     * Test generate Exception.
     */
    @Test(expected = NoSuchElementException.class)
    public void getIteratorTestExceptedExceptionNoSuchElementException() {
        Iterator<Integer> iterator = TwoDimensionalArrayIterator.getIterator(testArray);
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.next();
    }

    /**
     * Test hasNext.
     * hasNext return false when in array no element for iteration.
     */
    @Test
    public void getIteratorTestExceptedHasNextFalse() {
        Iterator<Integer> iterator = TwoDimensionalArrayIterator.getIterator(testArray);
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertEquals(false, iterator.hasNext());
    }
}