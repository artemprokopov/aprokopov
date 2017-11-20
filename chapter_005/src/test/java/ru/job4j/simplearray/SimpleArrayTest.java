package ru.job4j.simplearray;

import java.util.Arrays;

import org.junit.Test;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

/**
 * Класс тестов для {@link SimpleArray}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */

public class SimpleArrayTest {
    /**
     * Массив для тестов методов {@link SimpleArray#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleArray#add(int, Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 6, 3, 4, 5};

    /**
     * Массив результат для тесто метода  {@link SimpleArray#update(int, Object)}.
     */
    private static Integer[] resultArrayForUpdate = {1, 2, 6, 4, 5};

    /**
     * Массив результат для тесто метода delete {@link SimpleArray#delete(Object)}.
     */
    private static Integer[] resultArrayForDelete = {1, 2, 4, 5};

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
        SimpleArray<Integer> integerSimpleArrayForAdd = new SimpleArray<>();
        for (Integer i : testArray) {
            integerSimpleArrayForAdd.add(i);
        }
        assertEquals(integerSimpleArrayForAdd.size(), testArray.length);
        Integer[] resultArray = integerSimpleArrayForAdd.toArray(new Integer[integerSimpleArrayForAdd.size()]);
        assertArrayEquals(resultArray, testArray);
    }

    /**
     * Тестируем метод {@link SimpleArray#add(int, Object)}.
     */
    @Test
    public void add1() {
        SimpleArray<Integer> testSimpleArrayForAdd = new SimpleArray<>();
        for (Integer i : testArray) {
            testSimpleArrayForAdd.add(i);
        }
        assertEquals(testSimpleArrayForAdd.size(), testArray.length);
        testSimpleArrayForAdd.add(2, 6);
        assertArrayEquals(testSimpleArrayForAdd.toArray(new Integer[testSimpleArrayForAdd.size()]),
                resultArray1);
    }
    /**
     * Тестируем метод {@link SimpleArray#add(Object)}.
     * Добавляем больше элементов чем максимальное количество элементов в контейнере,
     * ожидаем исключение OutOfMemoryError.
     */
    @Test
            (expected = OutOfMemoryError.class)
    public void add2() {
        Integer[] initArray = new Integer[Integer.MAX_VALUE - 6];
        Arrays.fill(initArray, 1);
        SimpleArray<Integer> testSimpleArrayForAdd1 = new SimpleArray<>(initArray);
        for (int i = 0; i < 6; i++) {
            testSimpleArrayForAdd1.add(1);
        }

    }

    /**
     * Тест метода {@link SimpleArray#update(int, Object)}.
     */
    @Test
    public void update() {
        SimpleArray<Integer> testSimpleArrayForUpdate = new SimpleArray<>(testArray);
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
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>(testArray);
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
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>(testArray);
        Object result = testSimpleArrayForDelete.delete(new Integer(6));
        assertNull(result);
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                testArray);
    }
    /**
     * Тестируем метод {@link SimpleArray#delete(Object)}
     * Тестируем удаление первого элемента.
     */
    @Test
    public void delete2() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>(testArray);
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
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>(testArray);
        testSimpleArrayForDelete.delete(new Integer(5));
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                resultArrayForDeleteLastElement);
    }

    /**
     * Тестируем метод {@link SimpleArray#get(int)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete4() {
        SimpleArray<Integer> testSimpleArrayForDelete = new SimpleArray<>(testArray);
        testSimpleArrayForDelete.delete(2);
        assertArrayEquals(testSimpleArrayForDelete.toArray(new Integer[testSimpleArrayForDelete.size()]),
                resultArrayForDelete);
    }

    /**
     * Тестируем метод {@link SimpleArray#get(int)}.
     * Запрашиваем второй элемент из {@link SimpleArrayTest#testArray}.
     */
    @Test
    public void get() {
        SimpleArray<Integer> testSimpleArrayForGet = new SimpleArray<>(testArray);
        Integer result = testSimpleArrayForGet.get(2);
        assertEquals(result, new Integer(3));
        assertArrayEquals(testSimpleArrayForGet.toArray(new Integer[testSimpleArrayForGet.size()]),
                testArray);
    }

    /**
     * Тестируем метод {@link SimpleArray#get(int)}.
     * Запрашиваем элемент -1, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get1() {
        SimpleArray<Integer> testSimpleArrayForGet = new SimpleArray<>(testArray);
        testSimpleArrayForGet.get(-1);
    }

    /**
     * Тестируем метод {@link SimpleArray#get(int)}.
     * Запрашиваем элемент больше текщего размера, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get2() {
        SimpleArray<Integer> testSimpleArrayForGet = new SimpleArray<>(testArray);
        testSimpleArrayForGet.get(testSimpleArrayForGet.size() + 1);
    }
    /**
     * Тестируем метод {@link SimpleArray#get(int)}.
     * Запрашиваем элемент при пустом массиве, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get3() {
        SimpleArray<Integer> testSimpleArrayForGet = new SimpleArray<>();
        testSimpleArrayForGet.get(1);
    }
    /**
     * Тестируем метод {@link SimpleArray#isEmpty()}.
     *
     */
    @Test
    public void isEmpty() {
        SimpleArray<Integer> testSimpleArrayForIsEmpty = new SimpleArray<>();
        assertTrue(testSimpleArrayForIsEmpty.isEmpty());
        for (Integer i : testArray) {
            testSimpleArrayForIsEmpty.add(i);
        }
        assertEquals(testSimpleArrayForIsEmpty.size(), testArray.length);
        int k = testSimpleArrayForIsEmpty.size();
        for (int i = 0; i < k; i++) {
            testSimpleArrayForIsEmpty.delete(0);
        }
        assertTrue(testSimpleArrayForIsEmpty.isEmpty());
    }

    /**
     *Тестируем метод {@link SimpleArray#size()}.
     */
    @Test
    public void size() {
        SimpleArray<Integer> testSimpleArrayForSize = new SimpleArray<>(testArray);
        assertEquals(testSimpleArrayForSize.size(), testArray.length);
    }

    /**
     * Тестируем метод {@link SimpleArray#findItem(Object)}.
     */
    @Test
    public void findItem() {
        SimpleArray<Integer> testSimpleArrayForFindItem = new SimpleArray<>(testArray);
        int result = testSimpleArrayForFindItem.findItem(3);
        assertEquals(result, 2);
    }

    /**
     * Тестируем метод {@link SimpleArray#findItem(Object)}.
     * Передаем не существующий объект.
     */
    @Test
    public void findItem1() {
        SimpleArray<Integer> testSimpleArrayForFindItem = new SimpleArray<>(testArray);
        int result = testSimpleArrayForFindItem.findItem(10);
        assertTrue(result < 0);
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArray#equals(Object)}.
     */
    @Test
    public void equals() {
        SimpleArray<Integer> testSimpleArrayForEquals1 = new SimpleArray<>(testArray);
        SimpleArray<Integer> testSimpleArrayForEquals2 = new SimpleArray<>(testArray);
        assertTrue(testSimpleArrayForEquals1.equals(testSimpleArrayForEquals2));
    }
    /**
     * Тестируем переопределенный метод {@link SimpleArray#equals(Object)}.
     */
    @Test
    public void equals1() {
        SimpleArray<Integer> testSimpleArrayForEquals1 = new SimpleArray<>(testArray);
        SimpleArray<Integer> testSimpleArrayForEquals2 = new SimpleArray<>(resultArray1);
        assertEquals(testSimpleArrayForEquals2.size(), resultArray1.length);
        assertFalse(testSimpleArrayForEquals1.equals(testSimpleArrayForEquals2));
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArray#hashCode()}.
     * Тестируем на соответствие спецификации, если hashCode не равны, то и объекты не равны,
     * если объекты равны, то hashCode равны.
     */
    @Test
    public void hashCodeTest() {
        SimpleArray<Integer> testSimpleArrayForEquals1 = new SimpleArray<>(testArray);
        assertEquals(testSimpleArrayForEquals1.size(), testArray.length);

        SimpleArray<Integer> testSimpleArrayForEquals3 = new SimpleArray<>(testArray);
        assertEquals(testSimpleArrayForEquals3.size(), testArray.length);

        SimpleArray<Integer> testSimpleArrayForEquals2 = new SimpleArray<>(resultArray1);
        assertEquals(testSimpleArrayForEquals2.size(), resultArray1.length);
        //Если hashCode не равны
        assertFalse(testSimpleArrayForEquals1.hashCode() == testSimpleArrayForEquals2.hashCode());
        //то объекты не равны
        assertFalse(testSimpleArrayForEquals1.equals(testSimpleArrayForEquals2));
        //Если объекты равны
        assertTrue(testSimpleArrayForEquals1.equals(testSimpleArrayForEquals3));
        //то hashCode равны
        assertTrue(testSimpleArrayForEquals1.hashCode() == testSimpleArrayForEquals3.hashCode());

    }

}