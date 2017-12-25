package ru.job4j.simplecontainer;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

import static java.util.Spliterator.ORDERED;

/**
 * Класс контейнера основанного на массиве, реализует интерфейс {@link SimpleContainer} и {@link Iterable}.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class SimpleArrayLinkContainer<E> implements SimpleContainer<E> {
    /**
     * Смещение максимального размера массива относительно {@link Integer#MAX_VALUE}.
     */
    private static final int ARRAY_INDEX_MAX_VALUE_OFFSET = 5;
    /**
     * Максимальный размер массива принимается как {@link Integer#MAX_VALUE} - {@link SimpleArrayContainer#ARRAY_INDEX_MAX_VALUE_OFFSET}.
     */
    private static final int ARRAY_MAX_SIZE = Integer.MAX_VALUE - ARRAY_INDEX_MAX_VALUE_OFFSET;
    /**
     * Размер которым инициализируется массив {@link SimpleArrayContainer#array} по умолчанию.
     */
    private static final int ARRAY_INIT_SIZE = 10;
    /**
     * Хранилище элементов контейнера.
     */
    private Node<E>[] array;
    /**
     * Первый элемент двусвязного списка. Если список пуст равен null.
     */
    private Node<E> first;
    /**
     * Последний элемент двусвязного списка.
     */
    private Node<E> last;
    /**
     * Номер последнего элемента в контейнере, при пустом контейнере равен -1.
     */
    private int currentItem = -1;

    /**
     * Конструктор по умолчанию.
     */
    public SimpleArrayLinkContainer() {
    }

    /**
     * Конструктор создания контейнера на основании переданного массива.
     * @param array массив элемнты которого используются для создания контейнера.
     */
    public SimpleArrayLinkContainer(E[] array) {
    }

    @Override
    public boolean add(E addItem) {
        return false;
    }

    @Override
    public void add(int indexAddItem, E addItem) {

    }

    @Override
    public boolean update(int indexUpdateItem, E itemUpdate) {
        return false;
    }

    @Override
    public E delete(int indexDeleteItem) {
        return null;
    }

    @Override
    public E delete(E deleteItem) {
        return null;
    }

    @Override
    public E get(int indexItem) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int findItem(E searchItem) {
        return 0;
    }

    @Override
    public <E1> E1[] toArray(E1[] resultArray) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     * Переопределяем метод {@link Iterable#forEach(Consumer)}.
     * @param action действие реализующее функциональным интерфейсом {@link Consumer}.
     */
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (Object t :array) {
            action.accept((E) t);
        }
    }

    /**
     * Переопределяем {@link Iterable#spliterator()}.
     * @return Spliterator<E>.
     */
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(array, 0, currentItem + 1, ORDERED);
    }

    /**
     * Внутренний класс узла двусвязного списка.
     * @param <E> парамет узла.
     */
    private static class Node<E> {

        //CHECKSTYLE:OFF
        /**
         *  Значение узла.
         */
        E item;

        /**
         * Ссылка на следующий узел списка.
         */
        Node<E> next;
        /**
         *  Ссылка на предыдущий узел списка.
         */
        Node<E> prev;
        //CHECKSTYLE:ON
        /**
         * Конструктор узла списка.
         * @param prevNode ссылка на преведущий узел списка.
         * @param element значение уза списка.
         * @param nextNode ссылка на следующий элемент списка.
         */
        Node(Node<E> prevNode, E element, Node<E> nextNode) {
            this.item = element;
            this.next = nextNode;
            this.prev = prevNode;
        }
    }
}
