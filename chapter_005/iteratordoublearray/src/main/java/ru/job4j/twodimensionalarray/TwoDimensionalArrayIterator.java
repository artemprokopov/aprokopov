package ru.job4j.twodimensionalarray;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class Double Array Iterator.
 * @author Artem Prokopov
 * @version 1.0
 * @since 09/10/2017
 */
public class TwoDimensionalArrayIterator {
    /**
     * Method to get an iterator for a two-dimensional array.
     * @param array two dimensional array for iterate.
     * @param <T> type array.
     * @return Iterator.
     */
    public static <T> Iterator<T> getIterator(T[][] array) {
        return new Iterator<T>() {
            private int countRow = array.length;
            private int indexRow = 0;
            private int countElement = array[indexRow].length;
            private int indexElement = 0;
            @Override
            public boolean hasNext() {
                return indexRow < countRow && indexElement < countElement;
            }

            @Override
            public T next() {
                T result;
                if (indexRow < countRow && indexElement < countElement) {
                    result = array[indexRow][indexElement++];
                } else {
                    throw new NoSuchElementException("No such element.");
                }
                if (indexElement == countElement && indexRow < countRow - 1) {
                    indexElement = 0;
                    countElement = array[++indexRow].length;
                }
                return result;
            }
        };
    }
}
