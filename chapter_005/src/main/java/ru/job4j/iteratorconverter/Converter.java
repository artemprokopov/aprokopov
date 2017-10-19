package ru.job4j.iteratorconverter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer>  current = it.next();
            @Override
            public boolean hasNext() {
                return it.hasNext() ||  current.hasNext();
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