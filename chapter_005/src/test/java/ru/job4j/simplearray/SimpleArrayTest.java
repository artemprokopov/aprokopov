package ru.job4j.simplearray;

import org.junit.Test;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.Theory;

import java.util.Objects;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class SimpleArrayTest {
    /**
     * Массив для тестов методов {@link SimpleArray#add(Object)}.
     */
    private static Integer[] testArrayForAdd = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleArray#add(int, Object)}.
     */
    private static Integer[] resultArrayForAdd1 = {1, 2, 6, 3, 4, 5};

    /**
     * Массив результат для тесто метода  {@link SimpleArray#update(int, Object)}.
     */
    private static Integer[] resultArrayForUpdate = {1, 2, 6, 4, 5};

    /**
     * Массив результат для тесто метода delete {@link SimpleArray#delete(Object)}.
     */
    private static Integer[] resultArrayForDelete = {2, 3, 4, 5};

    /**
     * Массив результат для тесто метода delete2  {@link SimpleArray#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteFirstElement = {2, 3, 4, 5};

    /**
     * Массив результат для тесто метода delete3  {@link SimpleArray#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteLastElement = {1, 2, 3, 4};

    /**
     * Тестируем метод {@link SimpleArray#add(Object)}.
     */
    @Test
    public void add() {
        SimpleArray<Integer> integerSimpleArray = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            integerSimpleArray.add(i);
        }
        assertEquals(integerSimpleArray.size(), testArrayForAdd.length);
        Integer[] resultArray = integerSimpleArray.toArray(new Integer[integerSimpleArray.size()]);
        assertArrayEquals(resultArray, testArrayForAdd);
    }

    /**
     * Тестируем метод {@link SimpleArray#add(int, Object)}.
     */
    @Test
    public void add1() {
        SimpleArray<Integer> testSimpleArrayForAdd1 = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForAdd1.add(i);
        }
        assertEquals(testSimpleArrayForAdd1.size(), testArrayForAdd.length);
        testSimpleArrayForAdd1.add(2, 6);
        assertArrayEquals(testSimpleArrayForAdd1.toArray(new Integer[testSimpleArrayForAdd1.size()]),
                resultArrayForAdd1);
    }

    /**
     * Тест метода {@link SimpleArray#update(int, Object)}
     */
    @Test
    public void update() {
        SimpleArray<Integer> testSimpleArrayForUpdate = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForUpdate.add(i);
        }
        assertEquals(testSimpleArrayForUpdate.size(), testArrayForAdd.length);
        testSimpleArrayForUpdate.update(2, 6);
        assertArrayEquals(testSimpleArrayForUpdate.toArray(new Integer[testSimpleArrayForUpdate.size()]),
                resultArrayForUpdate);
    }

    /**
     * Тестируем метод {@link SimpleArray#delete(Object)}
     * Удаляем элемент 3.
     */
    @Test
    public void delete() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForDelete.add(i);
        }
        assertEquals(testSimpleArrayForDelete.size(), testArrayForAdd.length);
        testSimpleArrayForDelete.delete(new Integer(3));
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                resultArrayForDelete);
    }
    /**
     * Тестируем метод {@link SimpleArray#delete(Object)}
     * Передаем несуществующий в массиве объект.
     */
    @Test
    public void delete1() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForDelete.add(i);
        }
        assertEquals(testSimpleArrayForDelete.size(), testArrayForAdd.length);
        Object result = testSimpleArrayForDelete.delete(new Integer(6));
        assertNull(result);
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                testArrayForAdd);
    }
    /**
     * Тестируем метод {@link SimpleArray#delete(Object)}
     * Тестируем удаление первого элемента.
     */
    @Test
    public void delete2() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForDelete.add(i);
        }
        assertEquals(testSimpleArrayForDelete.size(), testArrayForAdd.length);
        testSimpleArrayForDelete.delete(new Integer(1));
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                resultArrayForDeleteFirstElement);
    }
    /**
     * Тестируем метод {@link SimpleArray#delete(Object)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete3() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>();
        for (Integer i : testArrayForAdd) {
            testSimpleArrayForDelete.add(i);
        }
        assertEquals(testSimpleArrayForDelete.size(), testArrayForAdd.length);
        testSimpleArrayForDelete.delete(new Integer(5));
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                resultArrayForDeleteLastElement);
    }

    @Test
    public void get() {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void trim() {
    }

    @Test
    public void size() {
    }

    @Test
    public void findItem() {
    }

    @Test
    public void equals() {
    }

    @Test
    public void hashCodeTest() {

    }

}