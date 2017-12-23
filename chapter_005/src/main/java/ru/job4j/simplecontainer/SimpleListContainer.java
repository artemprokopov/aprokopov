package ru.job4j.simplecontainer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * Класс контейнера основанного на двусвязном списке, реализует интерфейс {@link SimpleContainer} и {@link Iterable}.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 21/12/2017
 * @version 1.0
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
     *  Конструктор по умолчанию.
     */
    public SimpleListContainer() {

    }

    /**
     * Конструктор заполняющий двунаправленный список на основе передаваемого массива.
     * @param array массив элементами которого заполняется создаваемй двусвязный список.
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

    /**
     * Добавляет элемент на место определяемый индексом.
     * @param indexAddItem индекс элемента вставки.
     * @param addItem элемент вставки.
     */
    @Override
    public void add(int indexAddItem, E addItem) {
        checkOutOfMemory(this.currentItem + 1);
        checkIndex(indexAddItem);
        addIndex(indexAddItem, addItem);
        this.currentItem++;
    }

    /**
     * Заменяет элемнт  по индексу на переданный.
     * @param indexUpdateItem индекс заменяемого элемента.
     * @param itemUpdate обновляемый элемент.
     * @return true если операция завершена успешно, в противном случае возвращает false.
     * @throws IndexOutOfBoundsException {@inheritDoc}.
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

    /**
     * Удалет элемент по индексу.
     * @param indexDeleteItem индекс удаляемого элемента.
     * @return  удаленный элемент.
     * @throws IndexOutOfBoundsException {@inheritDoc}.
     */
    @Override
    public E delete(int indexDeleteItem) {
        checkIndex(indexDeleteItem);
        Node<E> deleteNode = this.findItemIndex(indexDeleteItem);
        return  deleteNodeList(deleteNode);
    }

    /**
     * Удаляет элемент  по первому вхождению в список.
     * @param deleteItem Удаляемый элемент.
     * @return удаленный элемент, если элемент не удален, то null.
     */
    @Override
    public E delete(E deleteItem) {
        Node<E> deleteNode = findItemNode(deleteItem);
        return deleteNodeList(deleteNode);
    }

    /**
     * Возвращает элемент по передаваемому индексу.
     * @param indexItem индекс элемента.
     * @return  полученный элемент по индексу.
     * @throws IndexOutOfBoundsException {@inheritDoc}.
     */
    @Override
    public E get(int indexItem) {
        checkIndex(indexItem);
        return  findItemIndex(indexItem).item;
    }

    /**
     * Проверка есть ли элементы в контейнере.
     * @return true если контейнер не содержит ни одного элемента.
     */
    @Override
    public boolean isEmpty() {
        return this.currentItem < 0;
    }

    /**
     * Виртуально число размера массива(общее число элементов размещённых в контейнере).
     * @return число элементов в контейнере.
     */
    @Override
    public int size() {
        return this.currentItem + 1;
    }

    /**
     * Поиск элемента в контейнере.
     * @param searchItem искомый элемент.
     * @return индекс найденного элемента, в противном случае если элемент не найден < 0.
     */
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


    /**
     * Метод возвращает все элементы контейнера как массив типа E.
     * @param resultArray массив определяющий тип возвращаемого массива.
     * @param <E> Тип возвращаемого массива.
     * @return массив содержащий все элементы контейнера.
     */
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

    /*
     * Имплементируем методы интерфейса {@link Iterable}.
     */
    /**
     * Реализуем метод интерфейса {@link Iterable#iterator()}.
     * @return итератор типа <E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> temp = first;
            private E result;

            @Override
            public boolean hasNext() {
                return Objects.nonNull(temp);
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No next element! End of SimpleListContainer!");
                }
                result = temp.item;
                temp = temp.next;
                return result;
            }
        };
    }

    /**
     * Переопределяем метод {@link Iterable#forEach(Consumer)}.
     * @param action действие реализующее функциональным интерфейсом {@link Consumer}.
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        for (E e : this) {
            action.accept(e);
        }
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

    /**
     * Переопределяем метод equals.
     * @param o объект с которым сравниваетм.
     * @return true если объекты равны, в противном случае false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimpleListContainer<?> that = (SimpleListContainer<?>) o;

        if (currentItem != that.currentItem) {
            return false;
        }
        Iterator<?> iteratorThat = that.iterator();
        for (E e : this) {
            if (e != iteratorThat.next()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Переопределяем метод hashCode.
     * @return новый сгенерированный hashCode объекта.
     */
    @Override
    public int hashCode() {
        int result = 0;
        for (E e : this) {
            result = 31 * result + (e == null ? 0 : e.hashCode());
        }
        result = 31 * result + currentItem;
        return result;
    }

    /**
     * Добавляет элемент в хвост списка.
     * @param addItem добавляемый элемент.
     */
    private void addLast(E addItem) {
        Node<E> temp = this.last;
        this.last = new Node<>(temp, addItem, null);
        temp.next = this.last;
    }


    /**
     * Добавляет элемент в список по индексу.
     * @param index индекс мест добавляемого элемента.
     * @param addItem добавляемый элемент.
     */
    private void addIndex(int index, E addItem) {
        Node<E> location = findItemIndex(index);
        Node<E> addNode = new Node<E>(location.prev, addItem, location);
        location.prev.next = addNode;
    }
    /**
     * Метод удаляет передаваемый узел из списка.
     * @param deleteNode удаляемый узел списка.
     * @return значение удаленного элемента.
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
     * {@link SimpleListContainer#checkIndex(int)}.
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
     * @throws IndexOutOfBoundsException {@inheritDoc}.
     */
    private void checkIndex(int checkIndex) {
        if (checkIndex > currentItem || checkIndex < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(checkIndex));
        }
    }

    /**
     * Ищет узел списка по индексу.
     * @param index индекс искомого узла.
     * @return найденный узел.
     */
    private Node<E> findItemIndex(int index) {
        Node<E> result = first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
    /**
     * Ищет узел списка по его значению.
     * @param findNodeItem искомое значение.
     * @return найденный узел, если узел не найден возвращает null.
     */
    private Node<E> findItemNode(E findNodeItem) {
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
     * Метод проверяет возможность использования индекса для создания элемента,
     * тоесть меньше ли индекс  Integer.MAX_VALUE.
     * @param checkIndex проверяемый индекс.
     * @throws OutOfMemoryError {@inheritDoc}
     */
    private void checkOutOfMemory(int checkIndex) {
        if (Integer.MAX_VALUE - checkIndex == 0) {
            throw new OutOfMemoryError("The array index is greater than the maximum possible values");
        }
    }
}
