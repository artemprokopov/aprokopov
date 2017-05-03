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
public class accArrayTest {

    public accArrayTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class accArray.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object o = null;
        accArray instance = new accArray();
        instance.add(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class accArray.
     */
    @Test
    public void testDelete_GenericType() {
        System.out.println("delete");
        Object o = null;
        accArray instance = new accArray();
        instance.delete(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class accArray.
     */
    @Test
    public void testDelete_int() {
        System.out.println("delete");
        int index = 0;
        accArray instance = new accArray();
        instance.delete(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class accArray.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        accArray instance = new accArray();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class accArray.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        accArray instance = new accArray();
        Object expResult = null;
        Object result = instance.get(index);
    }

    /**
     * Test of set method, of class accArray.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        Object o = null;
        accArray instance = new accArray();
        instance.set(index, o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of indexOf method, of class accArray.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        Object o = null;
        accArray instance = new accArray();
        int expResult = 0;
        int result = instance.indexOf(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toArray method, of class accArray.
     */
    @Test
    public void testToArray() {
        System.out.println("toArray");
        accArray instance = new accArray();
        Object[] expResult = null;
        Object[] result = instance.toArray();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class accArray.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        accArray<Item> instance = new accArray<>();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
    }

}
