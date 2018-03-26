package ru.job4j.simplecontainer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Тестовый класс для {@link SimpleHashMap}.
 * @author Artem Prokopov
 * @since 20/03/2018
 * @version 1.0
 */

public class SimpleHashMapTest {
    /**
     * Поле массива ожидаемого результата.
     */
    private SimpleHashMap.Node<Integer, String>[] resultArray;
    /**
     * Поле массива ожидаемого результата.
     */
    private SimpleHashMap.Node<Integer, String>[] resultArray2;
    /**
     * Поле массива ожидаемого результата.
     */
    private SimpleHashMap.Node<Integer, String>[] resultArray3;
    /**
     * Тестовая {@link SimpleHashMap}.
     */
    private SimpleHashMap<Integer, String> testSimpleHashMap6;
    /**
     * {@link SimpleHashMap} результата для метода remove.
     */
    private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap1;
    /**
     * {@link SimpleHashMap} результата для метода remove.
     */
    private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap2;
    /**
     * {@link SimpleHashMap} результата для метода remove.
     */
    private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap3;

    /**
     * Заполняем {@link SimpleHashMapTest#resultArray}.
     */
    @Before
    public void initResultArray() {
        resultArray = new SimpleHashMap.Node[17];
        resultArray[0] = new SimpleHashMap.Node<>(0, "zero");
        resultArray[1] = new SimpleHashMap.Node<>(1, "one");
        resultArray[2] = new SimpleHashMap.Node<>(2, "two");
        resultArray[3] = new SimpleHashMap.Node<>(3, "three");
        resultArray[4] = new SimpleHashMap.Node<>(4, "four");
        resultArray[5] = new SimpleHashMap.Node<>(5, "five");
        resultArray[0].next =  new SimpleHashMap.Node<>(17, "next zero");
        resultArray[5].next =  new SimpleHashMap.Node<>(22, "next five");
        resultArray[5].next.next =  new SimpleHashMap.Node<>(39, "next next five");
    }
    /**
     * Заполняем {@link SimpleHashMapTest#resultArray2}.
     */
    @Before
    public void initResultArray2() {
        resultArray2 = new SimpleHashMap.Node[34];
        for (int i = 0; i < 27; i++) {
            resultArray2[i] = new SimpleHashMap.Node<>(i, Integer.toString(i));
        }
    }
    /**
     * Заполняем {@link SimpleHashMapTest#resultArray}.
     */
    @Before
    public void initResultArray3() {
        resultArray3 = new SimpleHashMap.Node[17];
        resultArray3[1] = new SimpleHashMap.Node<>(1, "three");
    }
    /**
     * Заполняем {@link SimpleHashMapTest#testSimpleHashMap6}.
     */
    @Before
    public void setTestSimpleHashMap6() {
        testSimpleHashMap6 = new SimpleHashMap<>();
        testSimpleHashMap6.put(0, "zero");
        testSimpleHashMap6.put(1, "one");
        testSimpleHashMap6.put(2, "two");
        testSimpleHashMap6.put(3, "three");
        testSimpleHashMap6.put(4, "four");
        testSimpleHashMap6.put(5, "five");
        testSimpleHashMap6.put(17, "next zero");
        testSimpleHashMap6.put(22, "next five");
        testSimpleHashMap6.put(39, "next next five");
    }
    /**
     * Заполняем {@link SimpleHashMapTest#testResultRemoveSimpleHashMap1}.
     */
    @Before
    public void setTestResultRemoveSimpleHashMap1() {
        testResultRemoveSimpleHashMap1 = new SimpleHashMap<>();
        testResultRemoveSimpleHashMap1.put(0, "zero");
        testResultRemoveSimpleHashMap1.put(1, "one");
        testResultRemoveSimpleHashMap1.put(2, "two");
        testResultRemoveSimpleHashMap1.put(3, "three");
        testResultRemoveSimpleHashMap1.put(4, "four");
        testResultRemoveSimpleHashMap1.put(17, "next zero");
        testResultRemoveSimpleHashMap1.put(22, "next five");
        testResultRemoveSimpleHashMap1.put(39, "next next five");
    }
    /**
     * Заполняем {@link SimpleHashMapTest#testResultRemoveSimpleHashMap2}.
     */
    @Before
    public void setTestResultRemoveSimpleHashMap2() {
        testResultRemoveSimpleHashMap2 = new SimpleHashMap<>();
        testResultRemoveSimpleHashMap2.put(0, "zero");
        testResultRemoveSimpleHashMap2.put(1, "one");
        testResultRemoveSimpleHashMap2.put(2, "two");
        testResultRemoveSimpleHashMap2.put(3, "three");
        testResultRemoveSimpleHashMap2.put(4, "four");
        testResultRemoveSimpleHashMap2.put(17, "next zero");
        testResultRemoveSimpleHashMap2.put(39, "next next five");
    }
    /**
     * Заполняем {@link SimpleHashMapTest#testResultRemoveSimpleHashMap3}.
     */
    @Before
    public void setTestResultRemoveSimpleHashMap3() {
        testResultRemoveSimpleHashMap3 = new SimpleHashMap<>();
        testResultRemoveSimpleHashMap3.put(0, "zero");
        testResultRemoveSimpleHashMap3.put(1, "one");
        testResultRemoveSimpleHashMap3.put(3, "three");
        testResultRemoveSimpleHashMap3.put(4, "four");
        testResultRemoveSimpleHashMap3.put(17, "next zero");
        testResultRemoveSimpleHashMap3.put(39, "next next five");
    }

    /**
     * Тестируем метод {@link SimpleHashMap#put(Object, Object)}.
     */
    @Test
    public void put() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        stringSimpleHashMap.put(0, "zero");
        stringSimpleHashMap.put(1, "one");
        stringSimpleHashMap.put(2, "two");
        stringSimpleHashMap.put(3, "three");
        stringSimpleHashMap.put(4, "four");
        stringSimpleHashMap.put(5, "five");
        stringSimpleHashMap.put(17, "next zero");
        stringSimpleHashMap.put(22, "next five");
        stringSimpleHashMap.put(39, "next next five");
        for (int i = 0; i < 6; i++) {
            assertEquals(stringSimpleHashMap.store[i], resultArray[i]);
            assertEquals(stringSimpleHashMap.store[i].next, resultArray[i].next);
            if (stringSimpleHashMap.store[i].next != null && resultArray[i].next != null) {
                assertEquals(stringSimpleHashMap.store[i].next.next, resultArray[i].next.next);
            }
        }
    }
    /**
     * Тестируем метод {@link SimpleHashMap#put(Object, Object)}.
     */
    @Test
    public void put2() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        for (int i = 0; i < 27; i++) {
            stringSimpleHashMap.put(i, Integer.toString(i));
        }
        for (int i = 0; i < 34; i++) {
            assertEquals(stringSimpleHashMap.store[i], resultArray2[i]);
        }
    }
    /**
     * Тестируем метод {@link SimpleHashMap#put(Object, Object)}.
     */
    @Test
    public void put3() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        stringSimpleHashMap.put(1, "one");
        stringSimpleHashMap.put(1, "two");
        stringSimpleHashMap.put(1, "three");
        for (int i = 0; i < 17; i++) {
            assertEquals(stringSimpleHashMap.store[i], resultArray3[i]);
        }
    }
    /**
     * Тестируем метод {@link SimpleHashMap#size}.
     */
    @Test
    public void size() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        stringSimpleHashMap.put(0, "zero");
        stringSimpleHashMap.put(1, "one");
        stringSimpleHashMap.put(2, "two");
        stringSimpleHashMap.put(3, "three");
        stringSimpleHashMap.put(4, "four");
        stringSimpleHashMap.put(5, "five");
        stringSimpleHashMap.put(17, "next zero");
        stringSimpleHashMap.put(22, "next five");
        stringSimpleHashMap.put(39, "next next five");
        assertEquals(9, stringSimpleHashMap.size());
    }
    /**
     * Тестируем метод {@link SimpleHashMap#isEmpty()}.
     */
    @Test
    public void isEmpty1() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        assertEquals(true, stringSimpleHashMap.isEmpty());
    }
    /**
     * Тестируем метод {@link SimpleHashMap#isEmpty()}.
     */
    @Test
    public void isEmpty2() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        stringSimpleHashMap.put(0, "zero");
        stringSimpleHashMap.put(1, "one");
        stringSimpleHashMap.put(2, "two");
        stringSimpleHashMap.put(3, "three");
        stringSimpleHashMap.put(4, "four");
        stringSimpleHashMap.put(5, "five");
        stringSimpleHashMap.put(17, "next zero");
        stringSimpleHashMap.put(22, "next five");
        stringSimpleHashMap.put(39, "next next five");
        assertEquals(false, stringSimpleHashMap.isEmpty());
    }
    /**
     * Тестируем метод {@link SimpleHashMap#containsKey(Object)}.
     */
    @Test
    public void containsKey1() {
        assertEquals(true, testSimpleHashMap6.containsKey(5));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#containsKey(Object)}.
     */
    @Test
    public void containsKey2() {
        assertEquals(false, testSimpleHashMap6.containsKey(30));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#containsValue(Object)}.
     */
    @Test
    public void containsValue1() {
        assertEquals(true, testSimpleHashMap6.containsValue("three"));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#containsValue(Object)}.
     */
    @Test
    public void containsValue2() {
        assertEquals(false, testSimpleHashMap6.containsValue("now"));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#get(Object)}.
     */
    @Test
    public void get1() {
        assertEquals("four", testSimpleHashMap6.get(4));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#get(Object)}.
     */
    @Test
    public void get2() {
        assertEquals("next five", testSimpleHashMap6.get(22));
    }
    /**
     * Тестируем метод {@link SimpleHashMap#get(Object)}.
     */
    @Test
    public void get3() {
        assertEquals("next next five", testSimpleHashMap6.get(39));
    }

    /**
     * Тестируем метод {@link SimpleHashMap#clear()}.
     */
    @Test
    public void clear() {
        testSimpleHashMap6.clear();
       assertEquals(true, testSimpleHashMap6.isEmpty());
    }
    /**
     * Тестируем метод {@link SimpleHashMap#remove(Object)}.
     */
    @Test
    public void remove() {
        assertEquals("five", testSimpleHashMap6.remove(5));
        assertEquals(testResultRemoveSimpleHashMap1, testSimpleHashMap6);
        assertEquals("next five", testSimpleHashMap6.remove(22));
        assertEquals(testResultRemoveSimpleHashMap2, testSimpleHashMap6);
        assertEquals("two", testSimpleHashMap6.remove(2));
        assertEquals(testResultRemoveSimpleHashMap3, testSimpleHashMap6);
    }
}