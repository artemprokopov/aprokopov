package ru.job4j.convertlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Тест для класса ConvertList.
 * @author Artem Prokopov
 * @since 05.09.2017
 * @version 1.0
 */
public class ConvertListTest {
    /**
     * Создаем тестируемый объект.
     */
    private final ConvertList convertList = new ConvertList();
    /**
     * Тестируем метод toList, передаем массив {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
     * ожидаем List {1, 2, 3, 4, 5, 6, 7, 8, 9}.
     */
    @Test
    public void toListAddArrayReturnList() {
        int[][] testArray = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = convertList.toList(testArray);
        assertEquals(result, expected);
    }

    /**
     * Тестируем метод toArray передаем List {1, 2, 3, 4, 5, 6, 7, 8, 9} и rows = 3,
     * ожидаем {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void toArrayAddListOneToNineAndRows3ReturnArray3Rows() {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = convertList.toArray(testList, 3);
        assertArrayEquals(result, expected);
    }

    /**
     * Тестируем метод toArray передаем List {1, 2, 3, 4, 5, 6, 7, 8, 9} и rows = 4,
     * ожидаем {{1, 2}, {3, 4}, {5, 6}, {7, 8}}.
     */
    @Test
    public void toArrayAddLisOneToNineAndRows4ReturnArray4Rows() {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {0, 0, 0}};
        int[][] result = convertList.toArray(testList, 4);
        assertArrayEquals(result, expected);
    }
    /**
     * Тестируем метод toArray передаем List {1, 2, 3, 4, 5, 6, 7, 8, 9, 10} и rows = 4,
     * ожидаем {{1, 2}, {3, 4}, {5, 6}, {7, 8}}.
     */
    @Test
    public void toArrayAddListOneToTenAndRows4ReturnArray4Rows() {
        List<Integer> testList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int[][] expected = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 0, 0}};
        int[][] result = convertList.toArray(testList, 4);
        assertArrayEquals(result, expected);
    }

}