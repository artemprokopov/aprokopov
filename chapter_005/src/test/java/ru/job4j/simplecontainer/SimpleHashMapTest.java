package ru.job4j.simplecontainer;
//CHECKSTYLE:OFF
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class SimpleHashMapTest {

private SimpleHashMap.Node<Integer, String>[] resultArray;
private SimpleHashMap.Node<Integer, String>[] resultArray2;

private SimpleHashMap<Integer, String> testSimpleHashMap6;

private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap1;
private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap2;
private SimpleHashMap<Integer, String> testResultRemoveSimpleHashMap3;

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

    @Before
    public void initResultArray2() {
        resultArray2 = new SimpleHashMap.Node[34];
        for (int i = 0; i < 27; i++) {
            resultArray2[i] = new SimpleHashMap.Node<>(i , Integer.toString(i));
        }
    }

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

    @Test
    public void isEmpty1() {
        SimpleHashMap<Integer, String> stringSimpleHashMap = new SimpleHashMap<>();
        assertEquals(true, stringSimpleHashMap.isEmpty());
    }

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

    @Test
    public void containsKey1() {
        assertEquals(true, testSimpleHashMap6.containsKey(5));
    }

    @Test
    public void containsKey2() {
        assertEquals(false, testSimpleHashMap6.containsKey(30));
    }

    @Test
    public void containsValue1() {
        assertEquals(true, testSimpleHashMap6.containsValue("three"));
    }

    @Test
    public void containsValue2() {
        assertEquals(false, testSimpleHashMap6.containsValue("now"));
    }

    @Test
    public void get1() {
        assertEquals("four", testSimpleHashMap6.get(4));
    }

    @Test
    public void get2() {
        assertEquals("next five", testSimpleHashMap6.get(22));
    }

    @Test
    public void get3() {
        assertEquals("next next five", testSimpleHashMap6.get(39));
    }

    @Test
    public void putAll() {
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
        assertEquals(stringSimpleHashMap, testSimpleHashMap6);
    }

    @Test
    public void clear() {
        testSimpleHashMap6.clear();
       assertEquals(true, testSimpleHashMap6.isEmpty());
    }

    @Test
    public void remove() {
        assertEquals("five", testSimpleHashMap6.remove(5));
        assertEquals(testResultRemoveSimpleHashMap1, testSimpleHashMap6);
        assertEquals("next five", testSimpleHashMap6.remove(22));
        assertEquals(testResultRemoveSimpleHashMap2, testSimpleHashMap6);
        assertEquals("two", testSimpleHashMap6.remove(2));
        assertEquals(testResultRemoveSimpleHashMap3, testSimpleHashMap6);
    }
//CHECKSTYLE:ON
}