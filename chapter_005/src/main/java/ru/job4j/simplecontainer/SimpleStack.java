package ru.job4j.simplecontainer;
/**
 * Класс стека FILO.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 25/12/2017
 * @version 1.0
 */
public class SimpleStack<E> extends SimpleListContainer<E> implements Stack<E> {
    /**
     * Конструктор по умолчанию.
     */
    public SimpleStack() {
        super();
    }

    /**
     * Метод возвращает элемент из стека FILO(очереди FIFO) и удаляет его.
     * @return элемент стека.
     */
    @Override
    public E poll() {
        return super.deleteFirst();
    }
    /**
     * Метод помещает элемент в стек FILO.
     * @param value значение помещаеме в стек(очередь)
     */
    @Override
    public void push(E value) {
      super.addFirst(value);
    }
}
