package ru.job4j.referencesort;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;



/**
 * Tests for class Reference.
 * @author Artem Prokopov
 * @since 14/09/2017
 * @version 1.0
 */

public class ReferenceTest {
    /**
     * Test array of strings.
     */
    private String[] testArray;
    /**
     * Expected result the array is sorted in ascending order.
     */
    private String[] exceptedAscendingArray;
    /**
     * Expected result the array is sorted in descending order.
     */
    private String[] exceptedDescendingArray;

    /**
     * Initialize the arrays before tests.
     */
    @Before
    public void init() {
        testArray = new String[]{"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1",
                                    "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1",
                                    "K2\\SK1\\SSK2", "K1\\SK2\\SSK1"};
        exceptedAscendingArray = new String[]{"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2",
                                                "K1\\SK2", "K1\\SK2\\SSK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1",
                                                "K2\\SK1\\SSK2"};
        exceptedDescendingArray = new String[]{"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                                                "K1", "K1\\SK2", "K1\\SK2\\SSK1", "K1\\SK1", "K1\\SK1\\SSK2",
                                                "K1\\SK1\\SSK1"};
    }

    /**
     * Test method {@link Reference#getReferenceArrayAscending()}.
     */
    @Test
    public void testGetReferenceArrayAscending() {
        Reference reference = new Reference(testArray);
        String[] resultArray = reference.getReferenceArrayAscending();
        assertThat(resultArray, is(exceptedAscendingArray));
    }

    /**
     * Test method {@link Reference#getReferenceArrayDescending()}.
     */
    @Test
    public void testGetReferenceArrayDescending() {
        Reference reference = new Reference(testArray);
        String[] resultArray = reference.getReferenceArrayDescending();
        assertThat(resultArray, is(exceptedDescendingArray));
    }

}