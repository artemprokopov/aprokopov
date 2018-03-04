package ru.job4j.simplecontainer;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Тестовый класс для {@link SimpleListContainer}.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */

public class SimpleListSetTest {
    /**
     * Массив для тестов методов {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив для тестов методов {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] testArray1 = {1, 1, 2, 4, 2};
    /**
     * Массив для тестов методов {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] testArray2 = {1, 1, 2, 4, 2, 5, 6, 7, 8, 8, 9, 10, 11, 12, 12, 1, 3, 4, 5, 3};

    /**
     * Массив результат для тесто метода  {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] resultArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 4};
    /**
     * Массив результат для тесто метода  {@link SimpleListSet#add(Object)}.
     */
    private static Integer[] resultArray2 = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3};


    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add1() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet<>(testArray);
        assertArrayEquals(resultArray, simpleListSet.simpleListContainer.toArray(new Integer[0]));
    }

    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add2() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet<>(testArray1);
        assertArrayEquals(resultArray1, simpleListSet.simpleListContainer.toArray(new Integer[0]));
    }
    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add3() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet<>(testArray2);
        assertArrayEquals(resultArray2, simpleListSet.simpleListContainer.toArray(new Integer[0]));
    }
    /**
     * Тестируем метод {@link SimpleListSet#iterator()}.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void iterator() {
        SimpleListSet<Integer> simpleListSet = new SimpleListSet<>(testArray1);
        Iterator<Integer> iterator = simpleListSet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), resultArray1[0]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), resultArray1[1]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), resultArray1[2]);
        assertFalse(iterator.hasNext());
        iterator.next();
    }

}