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
    public void testDelete_int() {
        int index = 0;
        instance.add(new Item());
        //instance.add(new Item());
        instance.delete(index);
    }

    /**
     * Test of size method, of class AccArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class AccArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Object expResult = null;
        Object result = instance.get(index);
    }

    /**
     * Test of set method, of class AccArray.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object o = null;
        instance.set(index, (Item) o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class AccArray.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        System.out.println("toArray");
        Item[] expResult = {new Item()};
        instance.add(new Item());
        Item[] result = (Item[]) instance.toArray();
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
