package ru.job4j.simplecontainer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @param <E>
 */
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

    /**
     *
     */
    public SimpleListContainer() {

    }

    /**
     *
     * @param array 1
     */
    public SimpleListContainer(E[] array) {
        for (E e : array) {
            this.add(e);
        }
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
        checkOutOfMemory(this.currentItem + 1);
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
        checkOutOfMemory(this.currentItem + 1);
        checkIndex(indexAddItem);
        addIndex(indexAddItem, addItem);
        this.currentItem++;
    }

    /**
     * 1.
     * @param indexUpdateItem индекс заменяемого элемента.
     * @param itemUpdate обновляемый элемент.
     * @return    1
     */
    @Override
    public boolean update(int indexUpdateItem, E itemUpdate) {
        checkIndex(indexUpdateItem);
        Node<E> findUpdate = findItemIndex(indexUpdateItem);
        if (Objects.isNull(findUpdate)) {
            return false;
        }
        findUpdate.item = itemUpdate;
        return true;
    }
    //решить проблему с удалением перовго элемента
    @Override
    public E delete(int indexDeleteItem) {
        checkIndex(indexDeleteItem);
        Node<E> deleteNode = this.findItemIndex(indexDeleteItem);
        return  deleteNodeList(deleteNode);
    }

    //решить проблему с удалением перовго элемента

    @Override
    public E delete(E deleteItem) {
        Node<E> deleteNode = findeItemNode(deleteItem);
        return deleteNodeList(deleteNode);
    }
    @Override
    public E get(int indexItem) {
        checkIndex(indexItem);
        return (E) findItemIndex(indexItem).item;
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
        int result = -1;
        Node<E> temp = first;
        for (int i = 0; i <= this.currentItem; i++) {
            if (temp.item.equals(searchItem)) {
                result = i;
                break;
            }
            temp = temp.next;
        }
        return result;
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

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    /**
     *
     * @param action
     */
    @Override
    public void forEach(Consumer<? super E> action) {

    }

    /**
     *
     * @param <E>
     */
    private static class Node<E> {

        //CHECKSTYLE:OFF
        /**
         *
         */
        E item;

        /**
         *
         */
        Node<E> next;
        /**
         *
         */
        Node<E> prev;
        //CHECKSTYLE:ON
        /**
         *
         * @param prevNode 1
         * @param element 1
         * @param nextNode 1
         */
        Node(Node<E> prevNode, E element, Node<E> nextNode) {
            this.item = element;
            this.next = nextNode;
            this.prev = prevNode;
        }
    }

    /**
     *
     * @param addItem 1
     */
    private void addLast(E addItem) {
        Node<E> temp = this.last;
        this.last = new Node<>(temp, addItem, null);
        temp.next = this.last;
    }


    /**
     *
     * @param index 1
     * @param addItem 1
     */
    private void addIndex(int index, E addItem) {
        Node<E> location = findItemIndex(index);
        Node<E> addNode = new Node<E>(location.prev, addItem, location);
        location.prev.next = addNode;
    }

    /**
     *
     * @param deleteNode 1
     * @return        1
     */
    private E deleteNodeList(Node<E> deleteNode) {
        if (Objects.isNull(deleteNode)) {
            return null;
        }
        if (deleteNode == this.first) {
            this.first = deleteNode.next;
        }
        if (deleteNode == this.last) {
            this.last = deleteNode.prev;
        }
        if (Objects.nonNull(deleteNode.prev)) {
            deleteNode.prev.next = deleteNode.next;
        }
        if (Objects.nonNull(deleteNode.next)) {
            deleteNode.next.prev = deleteNode.prev;
        }
        deleteNode.next = null;
        deleteNode.prev = null;
        this.currentItem--;
        return deleteNode.item;
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
    }
    /**
     *
     * @param index       1
     * @return       1
     */
    private Node<E> findItemIndex(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     *
     * @param findNodeItem 1
     * @return 1
     */
    private Node<E> findeItemNode(E findNodeItem) {
        Node<E> result = first;
        for (int i = 0; i <= this.currentItem; i++) {
            if (findNodeItem.equals(result.item)) {
                break;
            }
            result = result.next;
        }
        return result;
    }
    /**
     *
     * @param checkIndex 1
     */
    private void checkOutOfMemory(int checkIndex) {
        if (Integer.MAX_VALUE - checkIndex == 0) {
            throw new OutOfMemoryError("The array index is greater than the maximum possible values");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimpleListContainer<?> that = (SimpleListContainer<?>) o;

        if (currentItem != that.currentItem) return false;
        if (!first.equals(that.first)) return false;
        return last.equals(that.last);
    }

    @Override
    public int hashCode() {
        int result = first.hashCode();
        result = 31 * result + last.hashCode();
        result = 31 * result + currentItem;
        return result;
    }
}
