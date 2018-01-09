package ru.job4j.simplecontainer;
/**
 * Интерфейс стека FILO(очереди FIFO).
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 25/12/2017
 * @version 1.0
 */
public interface Stack<E> {
    /**
     * Метод возвращает элемент из стека FILO(очереди FIFO) и удаляет его.
     * @return элемент стека(очереди)
     */
    E poll();

    /**
     * Метод помещает элемент в стек FILO(очередь FIFO).
     * @param value значение помещаеме в стек(очередь)
     */
    void push(E value);
}
