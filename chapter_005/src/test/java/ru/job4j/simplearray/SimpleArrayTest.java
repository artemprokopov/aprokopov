package ru.job4j.simplearray;

import org.junit.Before;
import org.junit.Test;
/**
 * Тесты для класса SimpleArray.
 * @author Arterm Prokopov
 * @since 04/11/2017
 * @version 1.0
 */

public class SimpleArrayTest {
    private  SimpleArray<Integer> simpleArrayTestAdd;

    @Before
    public void init() {

    }
	/**
	 * Тестируем метод {@link SimpleArray#}.
	 */
    @Test(expected = IndexOutOfBoundsException.class)
    public void toArray()  {
        SimpleArray<Integer> simpleArray = new SimpleArray<>();
        simpleArray.add(1);
        simpleArray.add(2);
        System.out.println(simpleArray.get(3));
    }

}