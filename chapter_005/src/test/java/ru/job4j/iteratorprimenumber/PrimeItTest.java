package ru.job4j.iteratorprimenumber;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Test class for PrimeIt class.
 * @author Artem Prokopov
 * @version 1.0
 * @since 14/10/2017
 */
public class PrimeItTest {
    /**
     * First test array.
     */
    private final int[] testArray1 = new int[] {3, 4, 5, 6, 7};
    /**
     * Second test array.
     */
    private final int[] testArray2 = new int[] {1, 4, 6, 8};

    /**
     * Test method {@link PrimeIt#hasNext()}.
     * Use to test {@link PrimeItTest#testArray1},the expected result is{@link PrimeIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1ThenExpectedTrue() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        boolean result = iterator.hasNext();
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#hasNext()}.
     * Use to test {@link PrimeItTest#testArray1},use once {@link PrimeIt#next()},
     * the expected result is{@link PrimeIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1UseOnceNextThenExpectedTrue() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        iterator.next();
        boolean result = iterator.hasNext();
        boolean expectedResult = true;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#hasNext()}.
     * Use to test {@link PrimeItTest#testArray1},use three times {@link PrimeIt#next()},
     * the expected result is{@link PrimeIt#hasNext()} will return true.
     */
    @Test
    public void hasNextAddTestArray1UseTwiceNextThenExpectedTrue() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        iterator.next();
        iterator.next();
        iterator.next();
        boolean result = iterator.hasNext();
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#hasNext()}.
     * Use to test {@link PrimeItTest#testArray2},the expected result is{@link PrimeIt#hasNext()} will return false.
     */
    @Test
    public void hasNextAddTestArray2ThenExpectedTrue() {
        Iterator<Integer> iterator = new PrimeIt(testArray2);
        boolean result = iterator.hasNext();
        boolean expectedResult = false;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#next()}.
     * Use to test {@link PrimeItTest#testArray1},the expected result is{@link PrimeIt#next()} will return 3.
     */
    @Test
    public void nextAddTestArray1ThenExpected3() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        int result = iterator.next();
        int expectedResult = 3;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#next()}.
     * Use to test {@link PrimeItTest#testArray1}, use twice {@link PrimeIt#next()},
     * the expected result is{@link PrimeIt#next()} will return 5.
     */
    @Test
    public void nextAddTestArray1UseTwiceNextThenExpected5() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        iterator.next();
        int result = iterator.next();
        int expectedResult = 5;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#next()}.
     * Use to test {@link PrimeItTest#testArray1}, use three times {@link PrimeIt#next()},
     * the expected result is{@link PrimeIt#next()} will return 7.
     */
    @Test
    public void nextAddTestArray1UseThreeTimesNextThenExpected7() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        iterator.next();
        iterator.next();
        int result = iterator.next();
        int expectedResult = 7;
        assertEquals(expectedResult, result);
    }
    /**
     * Test method {@link PrimeIt#next()}.
     * Use to test {@link PrimeItTest#testArray1}, use four times {@link PrimeIt#next()},
     * the expected result is{@link PrimeIt#next()} will generate NoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void nextAddTestArray1UseFourTimesNextThenExpectedNoSuchElementException() {
        Iterator<Integer> iterator = new PrimeIt(testArray1);
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}