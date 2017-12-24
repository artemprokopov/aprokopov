package ru.job4j.simplecontainer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;



/**
 * Тестовый класс для {@link SimpleListContainer}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */

public class SimpleListContainerTest {
    /**
     * Массив для тестов методов {@link SimpleListContainer#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleListContainer#add(int, Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 6, 3, 4, 5};

    /**
     * Массив результат для тесто метода  {@link SimpleListContainer#update(int, Object)}.
     */
    private static Integer[] resultArrayForUpdate = {1, 2, 6, 4, 5};

    /**
     * Массив результат для тесто метода delete {@link SimpleListContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDelete = {1, 2, 4, 5};

    /**
     * Массив результат для тесто метода delete2  {@link SimpleListContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteFirstElement = {2, 3, 4, 5};

    /**
     * Массив результат для тесто метода delete3  {@link SimpleListContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteLastElement = {1, 2, 3, 4};

    /**
     * Тестируем метод {@link SimpleListContainer#add(Object)}.
     */
    @Test
    public void add() {
        SimpleListContainer<Integer> integerSimpleListContainerForAdd = new SimpleListContainer<>();
        for (Integer i : testArray) {
            integerSimpleListContainerForAdd.add(i);
        }
        assertEquals(integerSimpleListContainerForAdd.size(), testArray.length);
        Integer[] resultArray = integerSimpleListContainerForAdd.toArray(new Integer[integerSimpleListContainerForAdd.size()]);
        assertArrayEquals(resultArray, testArray);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#add(int, Object)}.
     */
    @Test
    public void add1() {
        SimpleListContainer<Integer> testSimpleListContainerForAdd = new SimpleListContainer<>();
        for (Integer i : testArray) {
            testSimpleListContainerForAdd.add(i);
        }
        assertEquals(testSimpleListContainerForAdd.size(), testArray.length);
        testSimpleListContainerForAdd.add(2, 6);
        assertArrayEquals(testSimpleListContainerForAdd.toArray(new Integer[testSimpleListContainerForAdd.size()]),
                resultArray1);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#add(Object)}.
     * Добавляем больше элементов чем максимальное количество элементов в контейнере,
     * ожидаем исключение OutOfMemoryError.
     */
    @Ignore
    @Test(expected = OutOfMemoryError.class)
    public void add2() {
        Integer[] initArray = new Integer[Integer.MAX_VALUE - 20];
        Arrays.fill(initArray, 1);
        SimpleListContainer<Integer> testSimpleListContainerForAdd1 = new SimpleListContainer<>(initArray);
        for (int i = 0; i < 6; i++) {
            testSimpleListContainerForAdd1.add(1);
        }

    }

    /**
     * Тест метода {@link SimpleListContainer#update(int, Object)}.
     */
    @Test
    public void update() {
        SimpleListContainer<Integer> testSimpleListContainerForUpdate = new SimpleListContainer<>(testArray);
        testSimpleListContainerForUpdate.update(2, 6);
        assertArrayEquals(testSimpleListContainerForUpdate.toArray(new Integer[testSimpleListContainerForUpdate.size()]),
                resultArrayForUpdate);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#delete(Object)}
     * Удаляем элемент 3.
     */
    @Test
    public void delete() {
        SimpleListContainer<Integer> testSimpleListContainerForDelete = new SimpleListContainer<>(testArray);
        testSimpleListContainerForDelete.delete(new Integer(3));
        assertArrayEquals(testSimpleListContainerForDelete.toArray(new Integer[testSimpleListContainerForDelete.size()]),
                resultArrayForDelete);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#delete(Object)}
     * Передаем несуществующий в массиве объект.
     */
    @Test
    public void delete1() {
        SimpleListContainer<Integer> testSimpleListContainerForDelete = new SimpleListContainer<>(testArray);
        Object result = testSimpleListContainerForDelete.delete(new Integer(6));
        assertNull(result);
        assertArrayEquals(testSimpleListContainerForDelete.toArray(new Integer[testSimpleListContainerForDelete.size()]),
                testArray);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#delete(Object)}
     * Тестируем удаление первого элемента.
     */
    @Test
    public void delete2() {
        SimpleListContainer<Integer> testSimpleListContainerForDelete = new SimpleListContainer<>(testArray);
        testSimpleListContainerForDelete.delete(new Integer(1));
        assertArrayEquals(testSimpleListContainerForDelete.toArray(new Integer[testSimpleListContainerForDelete.size()]),
                resultArrayForDeleteFirstElement);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#delete(Object)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete3() {
        SimpleListContainer<Integer> testSimpleListContainerForDelete = new SimpleListContainer<>(testArray);
        testSimpleListContainerForDelete.delete(new Integer(5));
        assertArrayEquals(testSimpleListContainerForDelete.toArray(new Integer[testSimpleListContainerForDelete.size()]),
                resultArrayForDeleteLastElement);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#get(int)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete4() {
        SimpleListContainer<Integer> testSimpleListContainerForDelete = new SimpleListContainer<>(testArray);
        testSimpleListContainerForDelete.delete(2);
        assertArrayEquals(testSimpleListContainerForDelete.toArray(new Integer[testSimpleListContainerForDelete.size()]),
                resultArrayForDelete);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#get(int)}.
     * Запрашиваем второй элемент из {@link SimpleListContainerTest#testArray}.
     */
    @Test
    public void get() {
        SimpleListContainer<Integer> testSimpleListContainerForGet = new SimpleListContainer<>(testArray);
        Integer result = testSimpleListContainerForGet.get(2);
        assertEquals(result, new Integer(3));
        assertArrayEquals(testSimpleListContainerForGet.toArray(new Integer[testSimpleListContainerForGet.size()]),
                testArray);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#get(int)}.
     * Запрашиваем элемент -1, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void get1() {
        SimpleListContainer<Integer> testSimpleListContainerForGet = new SimpleListContainer<>(testArray);
        testSimpleListContainerForGet.get(-1);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#get(int)}.
     * Запрашиваем элемент больше текщего размера, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void get2() {
        SimpleListContainer<Integer> testSimpleListContainerForGet = new SimpleListContainer<>(testArray);
        testSimpleListContainerForGet.get(testSimpleListContainerForGet.size() + 1);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#get(int)}.
     * Запрашиваем элемент при пустом массиве, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void get3() {
        SimpleListContainer<Integer> testSimpleListContainerForGet = new SimpleListContainer<>();
        testSimpleListContainerForGet.get(1);
    }
    /**
     * Тестируем метод {@link SimpleListContainer#isEmpty()}.
     *
     */
    @Test
    public void isEmpty() {
        SimpleListContainer<Integer> testSimpleListContainerForIsEmpty = new SimpleListContainer<>();
        assertTrue(testSimpleListContainerForIsEmpty.isEmpty());
        for (Integer i : testArray) {
            testSimpleListContainerForIsEmpty.add(i);
        }
        assertEquals(testSimpleListContainerForIsEmpty.size(), testArray.length);
        int k = testSimpleListContainerForIsEmpty.size();
        for (int i = 0; i < k; i++) {
            testSimpleListContainerForIsEmpty.delete(0);
        }
        assertTrue(testSimpleListContainerForIsEmpty.isEmpty());
    }

    /**
     *Тестируем метод {@link SimpleListContainer#size()}.
     */
    @Test
    public void size() {
        SimpleListContainer<Integer> testSimpleListContainerForSize = new SimpleListContainer<>(testArray);
        assertEquals(testSimpleListContainerForSize.size(), testArray.length);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#findItem(Object)}.
     */
    @Test
    public void findItem() {
        SimpleListContainer<Integer> testSimpleListContainerForFindItem = new SimpleListContainer<>(testArray);
        int result = testSimpleListContainerForFindItem.findItem(3);
        assertEquals(result, 2);
    }

    /**
     * Тестируем метод {@link SimpleListContainer#findItem(Object)}.
     * Передаем не существующий объект.
     */
    @Test
    public void findItem1() {
        SimpleListContainer<Integer> testSimpleListContainerForFindItem = new SimpleListContainer<>(testArray);
        int result = testSimpleListContainerForFindItem.findItem(10);
        assertTrue(result < 0);
    }

    /**
     * Тестируем переопределенный метод {@link SimpleListContainer#equals(Object)}.
     */
    @Test
    public void equals() {
        SimpleListContainer<Integer> testSimpleListContainerForEquals1 = new SimpleListContainer<>(testArray);
        SimpleListContainer<Integer> testSimpleListContainerForEquals2 = new SimpleListContainer<>(testArray);
        assertTrue(testSimpleListContainerForEquals1.equals(testSimpleListContainerForEquals2));
    }
    /**
     * Тестируем переопределенный метод {@link SimpleListContainer#equals(Object)}.
     */
    @Test
    public void equals1() {
        SimpleListContainer<Integer> testSimpleListContainerForEquals1 = new SimpleListContainer<>(testArray);
        SimpleListContainer<Integer> testSimpleListContainerForEquals2 = new SimpleListContainer<>(resultArray1);
        assertEquals(testSimpleListContainerForEquals2.size(), resultArray1.length);
        assertFalse(testSimpleListContainerForEquals1.equals(testSimpleListContainerForEquals2));
    }

    /**
     * Тестируем переопределенный метод {@link SimpleListContainer#hashCode()}.
     * Тестируем на соответствие спецификации, если hashCode не равны, то и объекты не равны,
     * если объекты равны, то hashCode равны.
     */
    @Test
    public void hashCodeTest() {
        SimpleListContainer<Integer> testSimpleListContainerForEquals1 = new SimpleListContainer<>(testArray);
        assertEquals(testSimpleListContainerForEquals1.size(), testArray.length);

        SimpleListContainer<Integer> testSimpleListContainerForEquals3 = new SimpleListContainer<>(testArray);
        assertEquals(testSimpleListContainerForEquals3.size(), testArray.length);

        SimpleListContainer<Integer> testSimpleListContainerForEquals2 = new SimpleListContainer<>(resultArray1);
        assertEquals(testSimpleListContainerForEquals2.size(), resultArray1.length);
        //Если hashCode не равны
        assertFalse(testSimpleListContainerForEquals1.hashCode() == testSimpleListContainerForEquals2.hashCode());
        //то объекты не равны
        assertFalse(testSimpleListContainerForEquals1.equals(testSimpleListContainerForEquals2));
        //Если объекты равны
        assertTrue(testSimpleListContainerForEquals1.equals(testSimpleListContainerForEquals3));
        //то hashCode равны
        assertTrue(testSimpleListContainerForEquals1.hashCode() == testSimpleListContainerForEquals3.hashCode());

    }

    /**
     * Тестируем метод {@link SimpleListContainer#iterator()}.
     */
    @Test(expected = NoSuchElementException.class)
    public void iterator() {
        SimpleListContainer<Integer> simpleListContainer = new SimpleListContainer<>(testArray);
        Iterator<Integer> iterator = simpleListContainer.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[0]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[1]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[2]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[3]);
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), testArray[4]);
        assertFalse(iterator.hasNext());
        iterator.next();
    }

    /**
     * Тестируем метод {@link SimpleListContainer#forEach}.
     */
    @Test
    public void forEach() {
        SimpleListContainer<Integer> simpleListContainer = new SimpleListContainer<>(testArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        simpleListContainer.forEach(System.out::println);
        printStream.close();
        System.setOut(null);
        String result = String.format("1%1$s2%1$s3%1$s4%1$s5%1$s", System.lineSeparator());
        assertEquals(result, byteArrayOutputStream.toString());
    }
}