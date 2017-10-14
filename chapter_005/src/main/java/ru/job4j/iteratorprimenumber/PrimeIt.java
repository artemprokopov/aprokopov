package ru.job4j.iteratorprimenumber;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Iterator class for Prime numbers.
 *  @author Artem Prokopov
 *  @version 1.0
 *  @since 12/10/2017
 */
public class PrimeIt implements Iterator<Integer> {
    /**
     * Stores numbers array.
     */
    private final int[] numbersArray;
    /**
     * Store index for next Prime number.
     */
    private int nextPrimeElementArray = 0;
    /**
     * Saves the state, if true then the array has the following Prime number, otherwise contains false.
     */
    private boolean existNext = false;

    /**
     * Constructor.
     * @param numbers array of numbers.
     */
    public PrimeIt(final int[] numbers) {
        numbersArray = numbers;
    }

    /**
     * Return true if then array has the following Prime number, after index array {@link PrimeIt#nextPrimeElementArray}.
     * @return true if then array has the following Prime number.
     */
    @Override
    public boolean hasNext() {
        findNextPrime();
        return existNext;
    }

    /**
     * Returns next Prime number, if Prime number not exist then generate exception {@link java.util.NoSuchElementException}.
     * @return next Prime number of array {@link PrimeIt#numbersArray}.
     * */
    @Override
    public Integer next() {
        findNextPrime();
        if (!existNext) {
            throw new NoSuchElementException("No such element.");
        }
        int result = numbersArray[nextPrimeElementArray];
        existNext = false;
        nextPrimeElementArray++;
        return result;
    }

    /**
     * Method finds next Prime number of {@link PrimeIt#numbersArray}.
     * If the number of found then {@link PrimeIt#existNext} set to true.
     */
    private void findNextPrime() {
        for (int i = nextPrimeElementArray; i < numbersArray.length && !existNext; i++) {
            if (!(numbersArray[i] % 2 == 0)
                    && !(numbersArray[i] % 3 == 0)
                    && !(numbersArray[i] % 5 == 0)
                    && !(numbersArray[i]  == 0)
                    && !(numbersArray[i]  == 1)
                    || numbersArray[i] == 2
                    || numbersArray[i] == 3
                    || numbersArray[i] == 5) {
                nextPrimeElementArray = i;
                existNext = true;
            }
        }
    }
}
