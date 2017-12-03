package ru.job4j.simplecontainer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleListContainer<E> implements SimpleContainer<E> {

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

    public SimpleListContainer() {

    }

    public SimpleListContainer(E[] array) {

    }

    /**
     * Метод добавления элемента в контейнер.
     * Добавляет элемент в хвост списка, указатель на хвост списка {@link SimpleListContainer#last}
     * после операции указывает на добавленный элемент.
     * @param addItem добавляемый элемент.
     * @return true если добавление прошло успешно.
     */
    @Override
    public boolean add(E addItem) {
        if (this.first == null) {
            this.first = new Node<>(null, addItem, null);
            this.last = this.first;
            this.currentItem++;
            return true;
        }
        addLast(addItem);
        this.currentItem++;
        return true;
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
        return this.currentItem < 0;
    }

    @Override
    public int size() {
        return this.currentItem + 1;
    }

    @Override
    public int findItem(E searchItem) {
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] resultArray) {
        resultArray = Arrays.copyOf(resultArray, currentItem + 1);
        Node temp = this.first;
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = (E) temp.item;
            temp = temp.next;
        }
        return resultArray;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    private static class Node<E> {

        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prevNode, E element, Node<E> nextNode) {
            this.item = element;
            this.next = nextNode;
            this.prev = prevNode;
        }
    }

    private void addLast(E addItem) {
        Node<E> temp = this.last;
        this.last = new Node<>(temp, addItem, null);
        temp.next = this.last;
    }

    private void addIndex(int index, E addItem) {

    }

    private void deleteLast() {

    }

    private void deleteIndex(int index) {

    }

    /**
     * Метод формирует сообщение для генерируемых исключений в методе
     * {@link SimpleArrayContainer#checkIndex(int)}.
     *
     * @param index индекс для формирования строки сообщения.
     * @return сформированную строку.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + (currentItem + 1);
    }

    /**
     * Проверка индекса на принадлежность диапазону i больше равен 0
     * или меньше равен {@linkSimpleListContainer#currentItem}.
     * @param checkIndex проверяемый индекс.
     */
    private void checkIndex(int checkIndex) {
        if (checkIndex > currentItem || checkIndex < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(checkIndex));
        }
        if (checkIndex > Integer.MAX_VALUE - 1) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(checkIndex));
        }
    }
}
