package ru.job4j.iteratorconverter;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class converts Iterator<Iterator<Integer>> to Iterator<Integer>.
 * @author Artem Prokopov
 * @since 19/10/2017
 * @version 1.0
 */
public class Converter {
    /**
     * Method converts Iterator<Iterator<Integer>> to Iterator<Integer>.
     * @param it parameter method type Iterator<Iterator<Integer>>.
     * @return iterator Iterator<Integer>.
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer>  current = it.next();
            @Override
            public boolean hasNext() {
                return it.hasNext() || current.hasNext();
            }

            @Override
            public Integer next() {
                if (!current.hasNext() && !it.hasNext()) {
                    throw new NoSuchElementException("No such element.");
                }
                if (!current.hasNext() && it.hasNext()) {
                    current = it.next();
                }
                return current.next();
            }
        };
    }
}