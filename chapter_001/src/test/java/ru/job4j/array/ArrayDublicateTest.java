package ru.job4j.array;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 *Tests for ArrayDublicate class.
 *@author Prokopov Artem
 *@since 20.03.2017
 *@version 1.0
 */
public class ArrayDublicateTest {
     /**
     *Test for method "remove".
     *Test  the deletes duplicate elements from an array, {"111", "222", "222}.
     *The exepted result is {"111", "222", "555", "333"}.
     */
    @Test
    public void whenRemoveArrayThreeElementsThenWithoutDublicateArray() {
        String[] array =   {"111", "222", "222"};
	ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] result = arrayDublicate.remove(array);
        String[] expected = {"111", "222"};
	assertThat(result, is(expected));
    }
    /**
     *Test for method "remove".
     *Test  the deletes duplicate elements from an array, {"111", "222", "333", "222"}.
     *The exepted result is {"111", "222", "333"}.
     */
    @Test
    public void whenRemoveArrayFourElementsThenWithoutDublicateArray() {
        String[] array = {"111", "222", "333", "222"};
	ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] result = arrayDublicate.remove(array);
        String[] expected = {"111", "222", "333"};
	assertThat(result, is(expected));
    }
     /**
     *Test for method "remove".
     *Test  the deletes duplicate elements from an array, {"111", "222", "333", "222", "555"}
     *The exepted result is {"111", "222", "333", "555"}.
     */
    @Test
    public void whenRemoveArrayFiveElementsThenWithoutDublicateArray() {
        String[] array = {"111", "222", "333", "222", "555"};
	ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] result = arrayDublicate.remove(array);
        String[] expected = {"111", "222", "333", "555"};
	assertThat(result, is(expected));
    }
    /**
     *Test for method "remove".
     *Test  the deletes duplicate elements from an array, {"111", "222", "222", "222", "555", "555", "555"}.
     *The exepted result is {"111", "222", "555"}.
     */
    @Test
    public void whenRemoveArraySevenElementsThenWithoutDublicateArray() {
        String[] array = {"111", "222", "222", "222", "555", "555", "555"};
	ArrayDublicate arrayDublicate = new ArrayDublicate();
        String[] result = arrayDublicate.remove(array);
        String[] expected = {"111", "222", "555"};
	assertThat(result, is(expected));
    }
}