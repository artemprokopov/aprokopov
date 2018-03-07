package ru.job4j.simplecontainer;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.checkcyclicallist.Node;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SimpleHashMapTest {

private SimpleHashMap.Node<Integer, String>[] resultArray;

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

}