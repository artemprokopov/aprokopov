package ru.job4j.simplecontainer;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

/**
 * Тестовый класс для {@link SimpleArrayContainer}.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */

public class SimpleArraySetTest {
    /**
     * Массив для тестов методов {@link SimpleArrayContainer#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив для тестов методов {@link SimpleArrayContainer#add(Object)}.
     */
    private static Integer[] testArray1 = {1, 1, 2, 4, 2};
    /**
     * Массив для тестов методов {@link SimpleArrayContainer#add(Object)}.
     */
    private static Integer[] testArray2 = {1, 1, 2, 4, 2, 5, 6, 7, 8, 8, 9, 10, 11, 12, 12, 1, 3, 4, 5, 3};

    /**
     * Массив результат для тесто метода  {@link SimpleArraySet#add(Object)}.
     */
    private static Integer[] resultArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleArraySet#add(Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 4};
    /**
     * Массив результат для тесто метода  {@link SimpleArraySet#add(Object)}.
     */
    private static Integer[] resultArray2 = {1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 3};


    /**
     * Тестируем метод {@link SimpleArrayContainer#add(Object)}.
     */
    @Test
    public void add1() {
        SimpleArraySet<Integer> simpleArraySet = new SimpleArraySet<>(testArray);
        assertArrayEquals(resultArray, simpleArraySet.simpleArrayContainer.toArray(new Integer[0]));
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#add(Object)}.
     */
    @Test
    public void add2() {
        SimpleArraySet<Integer> simpleArraySet = new SimpleArraySet<>(testArray1);
        assertArrayEquals(resultArray1, simpleArraySet.simpleArrayContainer.toArray(new Integer[0]));
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#add(Object)}.
     */
    @Test
    public void add3() {
        SimpleArraySet<Integer> simpleArraySet = new SimpleArraySet<>(testArray2);
        assertArrayEquals(resultArray2, simpleArraySet.simpleArrayContainer.toArray(new Integer[0]));
    }
    /**
     * Тестируем метод {@link SimpleArraySet#iterator()}.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void iterator() {
        SimpleArraySet<Integer> simpleArraySet = new SimpleArraySet<>(testArray);
        Iterator<Integer> iterator = simpleArraySet.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[0]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[1]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[2]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[3]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[4]);
        assertFalse(iterator.hasNext());
        iterator.next();
    }

}