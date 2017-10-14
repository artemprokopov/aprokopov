package ru.job4j.iteratorevennumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for EvenIt class.
 * @author Artem Prokopov
 * @version 1.0
 * @since 14/10/2017
 */
public class EvenItTest {
    /**
     * First test array.
     */
    private final int[] testArray1 = new int[] {2, 3, 5, 6, 9};
    /**
     * Second test array.
     */
    private final int[] testArray2 = new int[] {1, 3, 5, 7};

    /**
     * Test method {@link EvenIt#hasNext()}.
     * Use to test {@link EvenItTest#testArray1},the expected result is{@link EvenIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1ThenExpectedTrue() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        boolean result = iterator.hasNext();
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#hasNext()}.
     * Use to test {@link EvenItTest#testArray1},use once {@link EvenIt#next()},
     * the expected result is{@link EvenIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1UseOnceNextThenExpectedTrue() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        iterator.next();
        boolean result = iterator.hasNext();
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#hasNext()}.
     * Use to test {@link EvenItTest#testArray1},use twice {@link EvenIt#next()},
     * the expected result is{@link EvenIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1UseTwiceNextThenExpectedTrue() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        iterator.next();
        iterator.next();
        boolean result = iterator.hasNext();
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#hasNext()}.
     * Use to test {@link EvenItTest#testArray2},the expected result is{@link EvenIt#hasNext()} will return false.
     */
    @Test
    public void hasNextAddTestArray2ThenExpectedTrue() {
        Iterator<Integer> iterator = new EvenIt(testArray2);
        boolean result = iterator.hasNext();
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#next()}.
     * Use to test {@link EvenItTest#testArray1},the expected result is{@link EvenIt#next()} will return 2.
     */
    @Test
    public void nextAddTestArray1ThenExpected2() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        int result = iterator.next();
        int expectedResult = 2;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#next()}.
     * Use to test {@link EvenItTest#testArray1}, use twice {@link EvenIt#next()},
     * the expected result is{@link EvenIt#next()} will return 6.
     */
    @Test
    public void nextAddTestArray1UseTwiceNextThenExpected2() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        iterator.next();
        int result = iterator.next();
        int expectedResult = 6;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link EvenIt#next()}.
     * Use to test {@link EvenItTest#testArray1}, use three times {@link EvenIt#next()},
     * the expected result is{@link EvenIt#next()} will generate NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void nextAddTestArray1UseThreeTimesNextThenExpectedNoSuchElementException() {
        Iterator<Integer> iterator = new EvenIt(testArray1);
        iterator.next();
        iterator.next();
        int result = iterator.next();
    }
}