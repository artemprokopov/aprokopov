package ru.job4j.referencesort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for class Reference.
 * @author Artem Prokopov
 * @since 14/09/2017
 * @version 1.0
 */

public class ReferenceTest {
    private String[] testArray;
    private String[] exceptedArray;

    @Before
    public void init() {
        testArray = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",  "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        exceptedArray = new String[]{"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",  "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
    }

    @Test
    public void testGetReferenceArrayAscending() {
        Reference reference = new Reference(testArray);
        String[] resultArray = reference.getReferenceArrayAscending();
        assertArrayEquals(exceptedArray, resultArray);
    }
}