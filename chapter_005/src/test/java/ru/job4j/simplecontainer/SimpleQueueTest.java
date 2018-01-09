package ru.job4j.simplecontainer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Тестовый класс для {@link SimpleQueue}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class SimpleQueueTest {
    /**
     * Массив для тестов методов {@link SimpleQueue}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};

    /**
     *  Тестируем метод {@link SimpleQueue#poll()}.
     */
    @Test
    public void poll() {
        SimpleQueue<Integer> integerSimpleStack = new SimpleQueue<>();
        for (Integer i : testArray) {
            integerSimpleStack.push(i);
        }
        for (int i = 0; i < testArray.length; i++) {
            Integer result = integerSimpleStack.poll();
            assertEquals(result, testArray[i]);
        }
    }

    /**
     *  Тестируем метод {@link SimpleQueue#push(Object)}.
     */
    @Test
    public void push() {
        SimpleQueue<Integer> integerSimpleStack = new SimpleQueue<>();
        for (Integer i : testArray) {
            integerSimpleStack.push(i);
        }
        for (int i = 0; i < testArray.length; i++) {
            Integer result = integerSimpleStack.poll();
            assertEquals(result, testArray[i]);
        }
    }
}