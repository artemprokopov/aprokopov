package ru.job4j.simplecontainer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестовый класс для {@link SimpleHashSet}.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */

public class SimpleHashSetTest {
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
     * Массив результат для тесто метода  {@link SimpleHashSet#add(Object)}.
     */
    private static SimpleHashMap<Integer, Integer> resultHashMap;

    /**
     * Массив результат для тесто метода  {@link SimpleHashSet#add(Object)}.
     */
    private static SimpleHashMap<Integer, Integer> resultHashMap1;
    /**
     * Массив результат для тесто метода  {@link SimpleListSet#add(Object)}.
     */
    private static SimpleHashMap<Integer, Integer> resultHashMap2;
    /**
     * Массив результат для тесто метода  {@link SimpleListSet#add(Object)}.
     */
    private static SimpleHashMap<Integer, Integer> resultHashMap3;

    /**
     * Заполняем {@link SimpleHashSetTest#resultHashMap}.
     */
    @Before
    public void initResultHashMap() {
        resultHashMap = new SimpleHashMap<>();
        resultHashMap.put(1, 0);
        resultHashMap.put(2, 0);
        resultHashMap.put(3, 0);
        resultHashMap.put(4, 0);
        resultHashMap.put(5, 0);
    }
    /**
     * Заполняем {@link SimpleHashSetTest#resultHashMap1}.
     */
    @Before
    public void initResultHashMap1() {
        resultHashMap1 = new SimpleHashMap<>();
        resultHashMap1.put(1, 0);
        resultHashMap1.put(2, 0);
        resultHashMap1.put(4, 0);
    }
    /**
     * Заполняем {@link SimpleHashSetTest#resultHashMap2}.
     */
    @Before
    public void initResultHashMap2() {
        resultHashMap2 = new SimpleHashMap<>();
        resultHashMap2.put(1, 0);
        resultHashMap2.put(2, 0);
        resultHashMap2.put(4, 0);
        resultHashMap2.put(5, 0);
        resultHashMap2.put(6, 0);
        resultHashMap2.put(7, 0);
        resultHashMap2.put(8, 0);
        resultHashMap2.put(9, 0);
        resultHashMap2.put(10, 0);
        resultHashMap2.put(11, 0);
        resultHashMap2.put(12, 0);
        resultHashMap2.put(3, 0);
    }
    /**
     * Заполняем {@link SimpleHashSetTest#resultHashMap3}.
     */
    @Before
    public void initResultHashMap3() {
        resultHashMap3 = new SimpleHashMap<>();
        resultHashMap3.put(1, 0);
        resultHashMap3.put(2, 0);
        resultHashMap3.put(4, 0);
        resultHashMap3.put(6, 0);
        resultHashMap3.put(7, 0);
        resultHashMap3.put(8, 0);
        resultHashMap3.put(10, 0);
        resultHashMap3.put(11, 0);
        resultHashMap3.put(12, 0);
        resultHashMap3.put(3, 0);
    }


    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add1() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(testArray);
        assertEquals(resultHashMap, simpleHashSet.simpleHashContainer);
    }

    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add2() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(testArray1);
        assertEquals(resultHashMap1, simpleHashSet.simpleHashContainer);
    }
    /**
     * Тестируем метод {@link SimpleListSet#add(Object)}.
     */
    @Test
    public void add3() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(testArray2);
        assertEquals(resultHashMap2, simpleHashSet.simpleHashContainer);
    }
    /**
     * Тестируем метод {@link SimpleListSet#contains(Object)}.
     */
    @Test
    public void contains() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(testArray2);
        assertEquals(true, simpleHashSet.contains(6));
        assertEquals(false, simpleHashSet.contains(20));
    }
    /**
     * Тестируем метод {@link SimpleListSet#remove(Object)}.
     */
    @Test
    public void remove() {
        SimpleHashSet<Integer> simpleHashSet = new SimpleHashSet<>(testArray2);
        assertEquals(true, simpleHashSet.remove(5));
        assertEquals(true, simpleHashSet.remove(9));
        assertEquals(false, simpleHashSet.remove(100));
        assertEquals(resultHashMap3, simpleHashSet.simpleHashContainer);
    }
}