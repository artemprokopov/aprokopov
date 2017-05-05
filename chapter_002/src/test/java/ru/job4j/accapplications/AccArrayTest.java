/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.job4j.accapplications;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author smetchik
 */
public class AccArrayTest {
  
    AccArray<Item> instance;
    AccArray<Item> instance10;
    AccArray<Item> instance0;
    AccArray<Item> instance01;

    public AccArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

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

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class AccArray.
     */
    @Test
    public void testAdd() {
        Item o = new Item();
        instance.add(o);
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = {o.getCopyItemSafeIdAndCreated()};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDelete_GenericType() {
        Item o = null;
        Item o1 = new Item();
        //instance.add(o1);
        instance.add(o);
        instance.delete(o);
        Item[] result = instance.toArray(new Item[instance.size()]);
        Item[] expResult = {};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDelete_int10element() {
      int index = 5;
      Item[] result = instance10.toArray(new Item[instance10.size()]);
      System.arraycopy(result, index + 1, result, index, instance10.size() - index - 1);
      instance10.delete(index);
      Item[] expResult = instance10.toArray(new Item[instance10.size()]);
      assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of delete method, of class AccArray.
     */
    @Test
    public void testDelete_int2element() {
      int index = 0;
      Item[] result = instance01.toArray(new Item[instance01.size()]);
      System.arraycopy(result, index + 1, result, index, instance01.size() - index - 1);
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
     * Test of set method, of class AccArray.
     */
    @Test
    public void testSet() {
        System.out.println("set");
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
        System.out.println("toArray");
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
      Item[] result = (Item[]) instance.toArray();
      Item[] expResult = {instance.get(0)};
      assertArrayEquals(expResult, result);
    }

    /**
     * Test of isEmpty method, of class AccArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }
}
