package ru.job4j.simplecontainer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Тестовый класс для {@link SimpleStack}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class SimpleStackTest {
    /**
     * Массив для тестов методов {@link SimpleStack}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};

    /**
     *  Тестируем метод {@link SimpleStack#poll()}.
     */
    @Test
    public void poll() {
        SimpleStack<Integer> integerSimpleStack = new SimpleStack<>();
        for (Integer i : testArray) {
            integerSimpleStack.push(i);
        }
        for (int i = testArray.length - 1; i >= 0; i--) {
            Integer result = integerSimpleStack.poll();
            assertEquals(result, testArray[i]);
        }
    }
    /**
     *  Тестируем метод {@link SimpleStack#push(Object)}.
     */
    @Test
    public void push() {
        SimpleStack<Integer> integerSimpleStack = new SimpleStack<>();
        for (Integer i : testArray) {
            integerSimpleStack.push(i);
        }
        for (int i = testArray.length - 1; i >= 0; i--) {
            Integer result = integerSimpleStack.poll();
            assertEquals(result, testArray[i]);
        }
    }
}