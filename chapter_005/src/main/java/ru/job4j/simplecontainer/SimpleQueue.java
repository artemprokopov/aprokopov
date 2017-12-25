package ru.job4j.simplecontainer;
/**
 * Класс очереди FIFO.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 25/12/2017
 * @version 1.0
 */
public class SimpleQueue<E> implements Stack<E> {
    /**
     * Хранилище элементов очереди.
     */
    private final StackUtilContainer<E> queue = new SimpleListContainer<>();
    /**
     * Метод возвращает элемент из очереди FIFO и удаляет его.
     * @return элемент стека(очереди)
     */
    @Override
    public E poll() {
        return queue.deleteLast();
    }
    /**
     * Метод помещает элемент в стек очередь FIFO.
     * @param value значение помещаеме в стек(очередь)
     */
    @Override
    public void push(E value) {
        queue.addFirst(value);

    }
}
