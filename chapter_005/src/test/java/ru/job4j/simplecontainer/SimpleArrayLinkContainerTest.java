package ru.job4j.simplecontainer;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;


/**
 * Тестовый класс для {@link SimpleArrayLinkContainer}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */

public class SimpleArrayLinkContainerTest {
    /**
     * Массив для тестов методов {@link SimpleArrayLinkContainer#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleArrayLinkContainer#add(int, Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 6, 3, 4, 5};

    /**
     * Массив результат для тесто метода  {@link SimpleArrayLinkContainer#update(int, Object)}.
     */
    private static Integer[] resultArrayForUpdate = {1, 2, 6, 4, 5};

    /**
     * Массив результат для тесто метода delete {@link SimpleArrayLinkContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDelete = {1, 2, 4, 5};

    /**
     * Массив результат для тесто метода delete2  {@link SimpleArrayLinkContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteFirstElement = {2, 3, 4, 5};

    /**
     * Массив результат для тесто метода delete3  {@link SimpleArrayLinkContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteLastElement = {1, 2, 3, 4};

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#add(Object)}.
     */
    @Test
    public void add() {
        SimpleArrayLinkContainer<Integer> integerSimpleArrayLinkContainerForAdd = new SimpleArrayLinkContainer<>();
        for (Integer i : testArray) {
            integerSimpleArrayLinkContainerForAdd.add(i);
        }
        assertEquals(integerSimpleArrayLinkContainerForAdd.size(), testArray.length);
        Integer[] resultArray = integerSimpleArrayLinkContainerForAdd.toArray(new Integer[integerSimpleArrayLinkContainerForAdd.size()]);
        assertArrayEquals(resultArray, testArray);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#add(int, Object)}.
     */
    @Test
    public void add1() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForAdd = new SimpleArrayLinkContainer<>();
        for (Integer i : testArray) {
            testSimpleArrayLinkContainerForAdd.add(i);
        }
        assertEquals(testSimpleArrayLinkContainerForAdd.size(), testArray.length);
        testSimpleArrayLinkContainerForAdd.add(2, 6);
        assertArrayEquals(testSimpleArrayLinkContainerForAdd.toArray(new Integer[testSimpleArrayLinkContainerForAdd.size()]),
                resultArray1);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#add(Object)}.
     * Добавляем больше элементов чем максимальное количество элементов в контейнере,
     * ожидаем исключение OutOfMemoryError.
     */
    @Ignore
    @Test(expected = OutOfMemoryError.class)
    public void add2() {
        Integer[] initArray = new Integer[Integer.MAX_VALUE - 6];
        Arrays.fill(initArray, 1);
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForAdd1 = new SimpleArrayLinkContainer<>(initArray);
        for (int i = 0; i < 6; i++) {
            testSimpleArrayLinkContainerForAdd1.add(1);
        }
    }

    /**
     * Тест метода {@link SimpleArrayLinkContainer#update(int, Object)}.
     */
    @Test
    public void update() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForUpdate = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForUpdate.update(2, 6);
        assertArrayEquals(testSimpleArrayLinkContainerForUpdate.toArray(new Integer[testSimpleArrayLinkContainerForUpdate.size()]),
                resultArrayForUpdate);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#delete(Object)}
     * Удаляем элемент 3.
     */
    @Test
    public void delete() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForDelete = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForDelete.delete(new Integer(3));
        assertArrayEquals(testSimpleArrayLinkContainerForDelete.toArray(new Integer[testSimpleArrayLinkContainerForDelete.size()]),
                resultArrayForDelete);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#delete(Object)}
     * Передаем несуществующий в массиве объект.
     */
    @Test
    public void delete1() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForDelete = new SimpleArrayLinkContainer<>(testArray);
        Object result = testSimpleArrayLinkContainerForDelete.delete(new Integer(6));
        assertNull(result);
        assertArrayEquals(testSimpleArrayLinkContainerForDelete.toArray(new Integer[testSimpleArrayLinkContainerForDelete.size()]),
                testArray);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#delete(Object)}
     * Тестируем удаление первого элемента.
     */
    @Test
    public void delete2() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForDelete = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForDelete.delete(new Integer(1));
        assertArrayEquals(testSimpleArrayLinkContainerForDelete.toArray(new Integer[testSimpleArrayLinkContainerForDelete.size()]),
                resultArrayForDeleteFirstElement);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#delete(Object)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete3() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForDelete = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForDelete.delete(new Integer(5));
        assertArrayEquals(testSimpleArrayLinkContainerForDelete.toArray(new Integer[testSimpleArrayLinkContainerForDelete.size()]),
                resultArrayForDeleteLastElement);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#get(int)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete4() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForDelete = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForDelete.delete(2);
        assertArrayEquals(testSimpleArrayLinkContainerForDelete.toArray(new Integer[testSimpleArrayLinkContainerForDelete.size()]),
                resultArrayForDelete);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#get(int)}.
     * Запрашиваем второй элемент из {@link SimpleArrayLinkContainerTest#testArray}.
     */
    @Test
    public void get() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForGet = new SimpleArrayLinkContainer<>(testArray);
        Integer result = testSimpleArrayLinkContainerForGet.get(2);
        assertEquals(result, new Integer(3));
        assertArrayEquals(testSimpleArrayLinkContainerForGet.toArray(new Integer[testSimpleArrayLinkContainerForGet.size()]),
                testArray);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#get(int)}.
     * Запрашиваем элемент -1, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get1() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForGet = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForGet.get(-1);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#get(int)}.
     * Запрашиваем элемент больше текщего размера, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get2() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForGet = new SimpleArrayLinkContainer<>(testArray);
        testSimpleArrayLinkContainerForGet.get(testSimpleArrayLinkContainerForGet.size() + 1);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#get(int)}.
     * Запрашиваем элемент при пустом массиве, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get3() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForGet = new SimpleArrayLinkContainer<>();
        testSimpleArrayLinkContainerForGet.get(1);
    }
    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#isEmpty()}.
     *
     */
    @Test
    public void isEmpty() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForIsEmpty = new SimpleArrayLinkContainer<>();
        assertTrue(testSimpleArrayLinkContainerForIsEmpty.isEmpty());
        for (Integer i : testArray) {
            testSimpleArrayLinkContainerForIsEmpty.add(i);
        }
        assertEquals(testSimpleArrayLinkContainerForIsEmpty.size(), testArray.length);
        int k = testSimpleArrayLinkContainerForIsEmpty.size();
        for (int i = 0; i < k; i++) {
            testSimpleArrayLinkContainerForIsEmpty.delete(0);
        }
        assertTrue(testSimpleArrayLinkContainerForIsEmpty.isEmpty());
    }

    /**
     *Тестируем метод {@link SimpleArrayLinkContainer#size()}.
     */
    @Test
    public void size() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForSize = new SimpleArrayLinkContainer<>(testArray);
        assertEquals(testSimpleArrayLinkContainerForSize.size(), testArray.length);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#findItem(Object)}.
     */
    @Test
    public void findItem() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForFindItem = new SimpleArrayLinkContainer<>(testArray);
        int result = testSimpleArrayLinkContainerForFindItem.findItem(3);
        assertEquals(result, 2);
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#findItem(Object)}.
     * Передаем не существующий объект.
     */
    @Test
    public void findItem1() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForFindItem = new SimpleArrayLinkContainer<>(testArray);
        int result = testSimpleArrayLinkContainerForFindItem.findItem(10);
        assertTrue(result < 0);
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArrayLinkContainer#equals(Object)}.
     */
    @Test
    public void equals() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals1 = new SimpleArrayLinkContainer<>(testArray);
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals2 = new SimpleArrayLinkContainer<>(testArray);
        assertTrue(testSimpleArrayLinkContainerForEquals1.equals(testSimpleArrayLinkContainerForEquals2));
    }
    /**
     * Тестируем переопределенный метод {@link SimpleArrayLinkContainer#equals(Object)}.
     */
    @Test
    public void equals1() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals1 = new SimpleArrayLinkContainer<>(testArray);
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals2 = new SimpleArrayLinkContainer<>(resultArray1);
        assertEquals(testSimpleArrayLinkContainerForEquals2.size(), resultArray1.length);
        assertFalse(testSimpleArrayLinkContainerForEquals1.equals(testSimpleArrayLinkContainerForEquals2));
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArrayLinkContainer#hashCode()}.
     * Тестируем на соответствие спецификации, если hashCode не равны, то и объекты не равны,
     * если объекты равны, то hashCode равны.
     */
    @Test
    public void hashCodeTest() {
        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals1 = new SimpleArrayLinkContainer<>(testArray);
        assertEquals(testSimpleArrayLinkContainerForEquals1.size(), testArray.length);

        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals3 = new SimpleArrayLinkContainer<>(testArray);
        assertEquals(testSimpleArrayLinkContainerForEquals3.size(), testArray.length);

        SimpleArrayLinkContainer<Integer> testSimpleArrayLinkContainerForEquals2 = new SimpleArrayLinkContainer<>(resultArray1);
        assertEquals(testSimpleArrayLinkContainerForEquals2.size(), resultArray1.length);
        //Если hashCode не равны
        assertFalse(testSimpleArrayLinkContainerForEquals1.hashCode() == testSimpleArrayLinkContainerForEquals2.hashCode());
        //то объекты не равны
        assertFalse(testSimpleArrayLinkContainerForEquals1.equals(testSimpleArrayLinkContainerForEquals2));
        //Если объекты равны
        assertTrue(testSimpleArrayLinkContainerForEquals1.equals(testSimpleArrayLinkContainerForEquals3));
        //то hashCode равны
        assertTrue(testSimpleArrayLinkContainerForEquals1.hashCode() == testSimpleArrayLinkContainerForEquals3.hashCode());

    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#iterator()}.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void iterator() {
        SimpleArrayLinkContainer<Integer> simpleArrayLinkContainer = new SimpleArrayLinkContainer<>(testArray);
        Iterator<Integer> iterator = simpleArrayLinkContainer.iterator();
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
     * Тестируем метод {@link SimpleArrayLinkContainer#forEach}.
     */
    @Test
    public void forEach() {
        SimpleArrayLinkContainer<Integer> simpleArrayLinkContainer = new SimpleArrayLinkContainer<>(testArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        simpleArrayLinkContainer.forEach(System.out::println);
        printStream.close();
        System.setOut(null);
        String result = String.format("1%1$s2%1$s3%1$s4%1$s5%1$s", System.lineSeparator());
        assertEquals(result, byteArrayOutputStream.toString());
    }

    /**
     * Тестируем метод {@link SimpleArrayLinkContainer#spliterator()}.
     */
    @Test
    public void spliterator() {
        SimpleArrayLinkContainer<Integer> simpleArrayLinkContainer = new SimpleArrayLinkContainer<>(testArray);
        Spliterator<Integer> spliterator = simpleArrayLinkContainer.spliterator();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        spliterator.forEachRemaining(System.out::print);
        printStream.close();
        System.setOut(null);
        String result = "12345";
        assertEquals(result, byteArrayOutputStream.toString());
    }

}