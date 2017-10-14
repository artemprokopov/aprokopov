package ru.job4j.iteratorevennumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Iterator class for even numbers.
 *  @author Artem Prokopov
 *  @version 1.0
 *  @since 12/10/2017
 */
public class EvenIt implements Iterator<Integer> {
    /**
     * Stores numbers array.
     */
    private final int[] numbersArray;
    /**
     * Store index for next even number.
     */
    private int nextEvenElementArray = 0;
    /**
     * Saves the state, if true then the array has the following even number, otherwise contains false.
     */
    private boolean existNext = false;

    /**
     * Constructor.
     * @param numbers array of numbers.
     */
    public EvenIt(final int[] numbers) {
        numbersArray = numbers;
    }

    /**
     * Return true if then array has the following even number, after index array {@link EvenIt#nextEvenElementArray}.
     * @return true if then array has the following even number.
     */
    @Override
    public boolean hasNext() {
        findNextEven();
        return existNext;
    }

    /**
     * Returns next even number, if even number not exist then generate exception {@link java.util.NoSuchElementException}.
     * @return next even number of array {@link EvenIt#numbersArray}.
     * */
    @Override
    public Integer next() {
        findNextEven();
        if (!existNext) {
            throw new NoSuchElementException("No such element.");
        }
        int result = numbersArray[nextEvenElementArray];
        existNext = false;
        nextEvenElementArray++;
        return result;
    }

    /**
     * Method finds next even number of {@link EvenIt#numbersArray}.
     * If the number of found then {@link EvenIt#existNext} set to true.
     */
    private void findNextEven() {
        for (int i = nextEvenElementArray; i < numbersArray.length && !existNext; i++) {
            if (numbersArray[i] % 2 == 0) {
                nextEvenElementArray = i;
                existNext = true;
            }
        }
    }
}