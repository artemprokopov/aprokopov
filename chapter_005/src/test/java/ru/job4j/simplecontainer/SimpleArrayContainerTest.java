package ru.job4j.simplecontainer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;



/**
 * Тестовый класс для {@link SimpleArrayContainer}.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */

public class SimpleArrayContainerTest {
    /**
     * Массив для тестов методов {@link SimpleArrayContainer#add(Object)}.
     */
    private static Integer[] testArray = {1, 2, 3, 4, 5};
    /**
     * Массив результат для тесто метода  {@link SimpleArrayContainer#add(int, Object)}.
     */
    private static Integer[] resultArray1 = {1, 2, 6, 3, 4, 5};

    /**
     * Массив результат для тесто метода  {@link SimpleArrayContainer#update(int, Object)}.
     */
    private static Integer[] resultArrayForUpdate = {1, 2, 6, 4, 5};

    /**
     * Массив результат для тесто метода delete {@link SimpleArrayContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDelete = {1, 2, 4, 5};

    /**
     * Массив результат для тесто метода delete2  {@link SimpleArrayContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteFirstElement = {2, 3, 4, 5};

    /**
     * Массив результат для тесто метода delete3  {@link SimpleArrayContainer#delete(Object)}.
     */
    private static Integer[] resultArrayForDeleteLastElement = {1, 2, 3, 4};

    /**
     * Тестируем метод {@link SimpleArrayContainer#add(Object)}.
     */
    @Test
    public void add() {
        SimpleArrayContainer<Integer> integerSimpleArrayContainerForAdd = new SimpleArrayContainer<>();
        for (Integer i : testArray) {
            integerSimpleArrayContainerForAdd.add(i);
        }
        assertEquals(integerSimpleArrayContainerForAdd.size(), testArray.length);
        Integer[] resultArray = integerSimpleArrayContainerForAdd.toArray(new Integer[integerSimpleArrayContainerForAdd.size()]);
        assertArrayEquals(resultArray, testArray);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#add(int, Object)}.
     */
    @Test
    public void add1() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForAdd = new SimpleArrayContainer<>();
        for (Integer i : testArray) {
            testSimpleArrayContainerForAdd.add(i);
        }
        assertEquals(testSimpleArrayContainerForAdd.size(), testArray.length);
        testSimpleArrayContainerForAdd.add(2, 6);
        assertArrayEquals(testSimpleArrayContainerForAdd.toArray(new Integer[testSimpleArrayContainerForAdd.size()]),
                resultArray1);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#add(Object)}.
     * Добавляем больше элементов чем максимальное количество элементов в контейнере,
     * ожидаем исключение OutOfMemoryError.
     */
    @Test
            (expected = OutOfMemoryError.class)
    public void add2() {
        Integer[] initArray = new Integer[Integer.MAX_VALUE - 6];
        Arrays.fill(initArray, 1);
        SimpleArrayContainer<Integer> testSimpleArrayContainerForAdd1 = new SimpleArrayContainer<>(initArray);
        for (int i = 0; i < 6; i++) {
            testSimpleArrayContainerForAdd1.add(1);
        }

    }

    /**
     * Тест метода {@link SimpleArrayContainer#update(int, Object)}.
     */
    @Test
    public void update() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForUpdate = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForUpdate.update(2, 6);
        assertArrayEquals(testSimpleArrayContainerForUpdate.toArray(new Integer[testSimpleArrayContainerForUpdate.size()]),
                resultArrayForUpdate);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#delete(Object)}
     * Удаляем элемент 3.
     */
    @Test
    public void delete() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForDelete = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForDelete.delete(new Integer(3));
        assertArrayEquals(testSimpleArrayContainerForDelete.toArray(new Integer[testSimpleArrayContainerForDelete.size()]),
                resultArrayForDelete);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#delete(Object)}
     * Передаем несуществующий в массиве объект.
     */
    @Test
    public void delete1() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForDelete = new SimpleArrayContainer<>(testArray);
        Object result = testSimpleArrayContainerForDelete.delete(new Integer(6));
        assertNull(result);
        assertArrayEquals(testSimpleArrayContainerForDelete.toArray(new Integer[testSimpleArrayContainerForDelete.size()]),
                testArray);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#delete(Object)}
     * Тестируем удаление первого элемента.
     */
    @Test
    public void delete2() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForDelete = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForDelete.delete(new Integer(1));
        assertArrayEquals(testSimpleArrayContainerForDelete.toArray(new Integer[testSimpleArrayContainerForDelete.size()]),
                resultArrayForDeleteFirstElement);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#delete(Object)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete3() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForDelete = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForDelete.delete(new Integer(5));
        assertArrayEquals(testSimpleArrayContainerForDelete.toArray(new Integer[testSimpleArrayContainerForDelete.size()]),
                resultArrayForDeleteLastElement);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#get(int)}
     * Тестируем удаление последнего элемента.
     */
    @Test
    public void delete4() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForDelete = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForDelete.delete(2);
        assertArrayEquals(testSimpleArrayContainerForDelete.toArray(new Integer[testSimpleArrayContainerForDelete.size()]),
                resultArrayForDelete);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#get(int)}.
     * Запрашиваем второй элемент из {@link SimpleArrayContainerTest#testArray}.
     */
    @Test
    public void get() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForGet = new SimpleArrayContainer<>(testArray);
        Integer result = testSimpleArrayContainerForGet.get(2);
        assertEquals(result, new Integer(3));
        assertArrayEquals(testSimpleArrayContainerForGet.toArray(new Integer[testSimpleArrayContainerForGet.size()]),
                testArray);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#get(int)}.
     * Запрашиваем элемент -1, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get1() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForGet = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForGet.get(-1);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#get(int)}.
     * Запрашиваем элемент больше текщего размера, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get2() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForGet = new SimpleArrayContainer<>(testArray);
        testSimpleArrayContainerForGet.get(testSimpleArrayContainerForGet.size() + 1);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#get(int)}.
     * Запрашиваем элемент при пустом массиве, ожидаем исключение IndexOutOfBoundsException.
     */
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void get3() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForGet = new SimpleArrayContainer<>();
        testSimpleArrayContainerForGet.get(1);
    }
    /**
     * Тестируем метод {@link SimpleArrayContainer#isEmpty()}.
     *
     */
    @Test
    public void isEmpty() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForIsEmpty = new SimpleArrayContainer<>();
        assertTrue(testSimpleArrayContainerForIsEmpty.isEmpty());
        for (Integer i : testArray) {
            testSimpleArrayContainerForIsEmpty.add(i);
        }
        assertEquals(testSimpleArrayContainerForIsEmpty.size(), testArray.length);
        int k = testSimpleArrayContainerForIsEmpty.size();
        for (int i = 0; i < k; i++) {
            testSimpleArrayContainerForIsEmpty.delete(0);
        }
        assertTrue(testSimpleArrayContainerForIsEmpty.isEmpty());
    }

    /**
     *Тестируем метод {@link SimpleArrayContainer#size()}.
     */
    @Test
    public void size() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForSize = new SimpleArrayContainer<>(testArray);
        assertEquals(testSimpleArrayContainerForSize.size(), testArray.length);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#findItem(Object)}.
     */
    @Test
    public void findItem() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForFindItem = new SimpleArrayContainer<>(testArray);
        int result = testSimpleArrayContainerForFindItem.findItem(3);
        assertEquals(result, 2);
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#findItem(Object)}.
     * Передаем не существующий объект.
     */
    @Test
    public void findItem1() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForFindItem = new SimpleArrayContainer<>(testArray);
        int result = testSimpleArrayContainerForFindItem.findItem(10);
        assertTrue(result < 0);
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArrayContainer#equals(Object)}.
     */
    @Test
    public void equals() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals1 = new SimpleArrayContainer<>(testArray);
        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals2 = new SimpleArrayContainer<>(testArray);
        assertTrue(testSimpleArrayContainerForEquals1.equals(testSimpleArrayContainerForEquals2));
    }
    /**
     * Тестируем переопределенный метод {@link SimpleArrayContainer#equals(Object)}.
     */
    @Test
    public void equals1() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals1 = new SimpleArrayContainer<>(testArray);
        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals2 = new SimpleArrayContainer<>(resultArray1);
        assertEquals(testSimpleArrayContainerForEquals2.size(), resultArray1.length);
        assertFalse(testSimpleArrayContainerForEquals1.equals(testSimpleArrayContainerForEquals2));
    }

    /**
     * Тестируем переопределенный метод {@link SimpleArrayContainer#hashCode()}.
     * Тестируем на соответствие спецификации, если hashCode не равны, то и объекты не равны,
     * если объекты равны, то hashCode равны.
     */
    @Test
    public void hashCodeTest() {
        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals1 = new SimpleArrayContainer<>(testArray);
        assertEquals(testSimpleArrayContainerForEquals1.size(), testArray.length);

        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals3 = new SimpleArrayContainer<>(testArray);
        assertEquals(testSimpleArrayContainerForEquals3.size(), testArray.length);

        SimpleArrayContainer<Integer> testSimpleArrayContainerForEquals2 = new SimpleArrayContainer<>(resultArray1);
        assertEquals(testSimpleArrayContainerForEquals2.size(), resultArray1.length);
        //Если hashCode не равны
        assertFalse(testSimpleArrayContainerForEquals1.hashCode() == testSimpleArrayContainerForEquals2.hashCode());
        //то объекты не равны
        assertFalse(testSimpleArrayContainerForEquals1.equals(testSimpleArrayContainerForEquals2));
        //Если объекты равны
        assertTrue(testSimpleArrayContainerForEquals1.equals(testSimpleArrayContainerForEquals3));
        //то hashCode равны
        assertTrue(testSimpleArrayContainerForEquals1.hashCode() == testSimpleArrayContainerForEquals3.hashCode());

    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#iterator()}.
     */
    @Test
            (expected = NoSuchElementException.class)
    public void iterator() {
        SimpleArrayContainer<Integer> simpleArrayContainer = new SimpleArrayContainer<>(testArray);
        Iterator<Integer> iterator = simpleArrayContainer.iterator();
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
     * Тестируем метод {@link SimpleArrayContainer#forEach(Consumer)}.
     */
    @Test
    public void forEach() {
        SimpleArrayContainer<Integer> simpleArrayContainer = new SimpleArrayContainer<>(testArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        simpleArrayContainer.forEach(System.out::println);
        printStream.close();
        System.setOut(null);
        String result = String.format("1%1$s2%1$s3%1$s4%1$s5%1$s", System.lineSeparator());
        assertEquals(result, byteArrayOutputStream.toString());
    }

    /**
     * Тестируем метод {@link SimpleArrayContainer#spliterator()}.
     */
    @Test
    public void spliterator() {
        SimpleArrayContainer<Integer> simpleArrayContainer = new SimpleArrayContainer<>(testArray);
        Spliterator<Integer> spliterator = simpleArrayContainer.spliterator();
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