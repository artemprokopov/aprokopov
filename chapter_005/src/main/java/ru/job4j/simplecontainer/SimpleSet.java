package ru.job4j.simplecontainer;
/**
 * Интерфейс простого контейнера Set<E>.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */
public interface SimpleSet<E> extends SimpleContainer<E> {
    /**
     * Метод добавления элемента в контейнер.
     * @param addItem добавляемый в контейнер элемент тип E.
     * @return добавляемый в контейнер элемент тип T.
     */
    boolean add(E addItem);
}
