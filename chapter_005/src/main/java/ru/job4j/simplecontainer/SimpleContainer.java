package ru.job4j.simplecontainer;

import javax.naming.OperationNotSupportedException;

/**
 * Интерфейс простого контейнера.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */

public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Метод добавления элемента в контейнер.
     * Добавляет элемент в хвост массива.
     * @param addItem добавляемый в контейнер элемент тип T.
     * @return возвращает true если операция выполняется успешно.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default boolean add(E addItem) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Добавляет элемент в контейнер по индексу, хвост массива сдвигаетс в право.
     * @param indexAddItem индекс элемента вставки.
     * @param addItem элемент вставки.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default void add(int indexAddItem, E addItem) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Заменяет элемент в контейнере.
     * @param indexUpdateItem индекс заменяемого элемента.
     * @param itemUpdate обновляемый элемент.
     * @return если операция добавления завершилась успешно возвращает true.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default boolean update(int indexUpdateItem, E itemUpdate) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
    /**
     * Удаляет элемент по индексу.
     * @param indexDeleteItem индекс удаляемого элемента.
     * @return в слуучае успеха возвращает удаленный элемент.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default E delete(int indexDeleteItem) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Удаляет первый найденный с начала контейнера элемент.
     * @param deleteItem Удаляемый элемент.
     * @return в случае успеха возвращает удалённый элемент, в противном случае если такого элемента нет null.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */

    default E delete(E deleteItem) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Возвращает элемент контейнера по индексу.
     * @param indexItem индекс элемента.
     * @return элемент контейнера.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
     default E get(int indexItem) throws OperationNotSupportedException {
         throw new OperationNotSupportedException();
     }

    /**
     * Проверка есть ли элементы в контейнере.
     * @return true если контейнер не содержит ни одного элемента.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default boolean isEmpty() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Виртуально число размера контейнера(общее число элементов размещённых в контейнере).
     * @return число элементов в контейнере.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default int size() throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Поиск элемента в контейнере.
     * @param searchItem искомый элемент.
     * @return индекс найденного элемента, в противном случае если элемент не найден < 0.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default int findItem(E searchItem) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }

    /**
     * Метод возвращает все элементы контейнера как массив типа T.
     * @param resultArray массив определяющий тип возвращаемого массива.
     * @param <E> Тип возвращаемого массива.
     * @return массив содержащий все элементы контейнера.
     * @throws OperationNotSupportedException бросается в случае отсутствия раелизации у класса реализующего интерфейс.
     */
    default <E> E[] toArray(E[] resultArray) throws OperationNotSupportedException {
        throw new OperationNotSupportedException();
    }
}
