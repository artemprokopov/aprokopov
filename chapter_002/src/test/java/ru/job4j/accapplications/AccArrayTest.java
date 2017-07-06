/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.job4j.accapplications;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

/**
 * Группа тестов класса AccArray.
 * @author Prokopov Artem
 * @since 09.05.2017
 * @version 1.0
 */
public class AccArrayTest {
    /**
     * Object for test methods.
     */
    private AccArray<Item> instance;

    /**
     * Object for test methods.
     */
    private AccArray<Item> instance10;

    /**
     * Object for test methods.
     */
    private AccArray<Item> instance01;

    /**
     *Test class.
     */
    public AccArrayTest() {
    }

    /**
     * Create object for test methods.
     */
    @Before
    public void setUp() {
      instance10 = new AccArray<>();
      for (int i = 0; i < 10; i++) {
        instance10.add(new Item());
      }
      instance01 = new AccArray<>();
      instance01.add(null);
      instance01.add(new Item());
      instance = new AccArray<>();
    }

    /**
     * Test of add method, of class AccArray.
     */
    @Test
    public void testAddOneFirstElement() {
        Item o = new Item();
        instance.add(o);
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = {o.getCopyItemSafeIdAndCreated()};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of add method, of class AccArray.
     */
    @Test
    public void testAddOneMillionElement() {
        Item o = new Item();
        for (int i = 0; i < 1_000_000; i++) {
            instance.add(o);
        }
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = instance.toArray(new Item[instance.size()]);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of OutOfMemoryError, of class AccArray.
     */
    @Ignore
    @Test(expected = OutOfMemoryError.class)
    public void addMoreMaxElementExpectedOutOfMemoryError() {
        //instance.array = new Item[Integer.MAX_VALUE - 10];
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            instance.add(null);
        }
    }


    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDeleteGenericTypeAddTwoDeleteOne() {
        Item o = null;
        Item o1 = new Item();
        instance.add(o1);
        instance.add(o);
        instance.delete(o);
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = {o1};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDeleteGenericTypeAddOneDeleteOne() {
        Item o1 = new Item();
        instance.add(o1);
        instance.delete(o1);
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = {};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteGenericTypeAddNullDeleteOneExpectedIllegalArgumentException() {
        Item o = null;
        instance.delete(o);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteGenericTypeAddTwoDeleteObjectNotAdd() {
        Item o = null;
        Item o1 = new Item();
        Item o2 = new Item();
        instance.add(o1);
        instance.add(o);
        instance.delete(o2);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDeleteint10element() {
      int index = 5;
      Item[] result = new Item[instance10.size() - 1];
      System.arraycopy(instance10.toArray(result), 0, result, 0, index);
      System.arraycopy(instance10.toArray(result), index + 1, result, index, instance10.size() - index - 1);
      instance10.delete(index);
      Item[] expResult = instance10.toArray(new Item[instance10.size()]);
      assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDeleteintAdd100000ElementDelete50000() {
        Item o = new Item();
        for (int i = 0; i < 100_000; i++) {
            instance.add(o);
        }
        Item[] result = new Item[50_000];
        System.arraycopy(instance.toArray(result), 50_000, result, 0, 50_000);
        for (int i = 0; i < 50_000; i++) {
            instance.delete(i);
        }
        Item[] expResult = instance.toArray(new Item[instance.size()]);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDeleteint2elementDeleteFirst() {
      int index = 0;
      Item[] result = new Item[instance01.size() - 1];
      result = Arrays.copyOfRange(instance01.toArray(result), index + 1, instance01.size());
      instance01.delete(index);
      Item[] expResult = instance01.toArray(new Item[instance01.size()]);
      assertArrayEquals(expResult, result);
    }

    /**
     * Test of size method, of class AccArray.
     */
    @Test
    public void testSize0() {
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class AccArray.
     */
    @Test
    public void testGet() {
        int index = 0;
        Item[] expResult = instance10.toArray(new Item[instance10.size()]);
        Object result = instance10.get(index);
        assertEquals(expResult[index], result);
    }

    /**
     * Test of get method, of class AccArray.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetWhenArrayEmpty() {
        int index = 0;
        instance.get(index);
    }

    /**
     * Test of get method, of class AccArray.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetWhenIndexOutOfRangeIndexArray() {
        int index = 12;
        Item[] expResult = instance10.toArray(new Item[instance10.size()]);
        Object result = instance10.get(index);
    }

    /**
     * Test of set method, of class AccArray.
     */
    @Test
    public void testSet() {
        int index = 0;
        Item o = new Item();
        instance01.set(index, o);
        Item[] expResult = instance01.toArray(new Item[instance01.size()]);
        Object result = instance01.get(index);
         assertEquals(expResult[index], result);
    }

    /**
     * Test of indexOf method, of class AccArray.
     */
    @Test
    public void testIndexOf() {
      int expResult = 5;
      Item o = instance10.get(expResult);
      int result = instance10.indexOf(o);
      assertEquals(expResult, result);
    }

    /**
     * Test of toArray method, of class AccArray.
     */
    @Test
    public void testToArrayEmptyArray() {
        Object[] expResult = {};
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of toArray method, of class AccArray.
     */
    @Test
    public void testToArrayAddOneArray() {
      instance.add(new Item());
      Object[] result =  instance.toArray();
      Item[] expResult = {instance.get(0)};
      assertArrayEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class AccArray.
     */
    @Test
    public void testIsEmpty() {
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}
