package ru.job4j.iteratorevennumbers;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  Iterator class for even numbers.
 *  @author Artem Prokopov
 *  @version 1.0
 *  @since 12/10/2017
 */
public class EvenIt implements Iterator {
    /**
     * Stores numbers array.
     */
    private final int[] numbersArray;
    /**
     * Store index for next even number, if {@link EvenIt#existNext} = true method ;
     */
    private int nextEvenElementArray = 0;
    private boolean existNext = false;

    public EvenIt(final int[] numbers) {
        numbersArray = numbers;
    }
    @Override
    public boolean hasNext() {
        findNextEven();
        return existNext;
    }

    private void findNextEven() {
        for (int i = nextEvenElementArray; i < numbersArray.length && !existNext; i++) {
            if (numbersArray[i] % 2 == 0) {
                nextEvenElementArray = i;
                existNext = true;
            }
        }
    }

    @Override
    public Integer next() {
        findNextEven();
        if(!existNext) {
            throw new NoSuchElementException("No such element.");
        }
        int result = numbersArray[nextEvenElementArray];
        existNext = false;
        nextEvenElementArray++;
        return result;
    }
}