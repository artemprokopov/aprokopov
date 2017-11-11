package ru.job4j.simplearray;

import java.util.Objects;

/**
 * Класс простого контейнера основанного на массиве(За аналог взят ArrayList).
 * @param <T> тип контейнера.
 */
public class ArrayContainer<T> implements Container<T>{
    /**
     * Номер последнего элемента в контейнере, при пустом контейнере равен -1.
     */
    private int currentItem = -1;
    /**
     * Хранилище элементов контейнера.
     */
    private final Array<T> array;
    /**
     * Конструктор по умолчанию.
     */
    public ArrayContainer() {
        this.array = new MyArray<>();
    }

    /**
     * Конструктор с параметром инициализации размера массива {@link ArrayContainer#array}.
     * @param initSize параметр инициализации размера массива {@link ArrayContainer#array}.
     */
    public ArrayContainer(int initSize) {
        this.array =  new MyArray<>(initSize);
    }

    /**
     * Метод добавления элемента в контейнер.
     * Добавляет элемент в хвост массива {@link ArrayContainer#array}
     * @param addItem добавляемый в контейнер элемент тип T.
     * @return возвращает true если операция выполняется успешно.
     */
    public boolean add(T addItem) {
        if (++currentItem > this.array.size()) {
            this.array.increaseArraySize(this.array.size() * 2);
        }
        this.array.set(addItem, currentItem);
        return true;
    }

    /**
     * Добавляет элемент в контейнер по индексу, хвост массива сдвигаетс в право.
     * @param indexAddItem индекс элемента вставки.
     * @param addItem элемент вставки.
     */
    @SuppressWarnings("unused")
	public void add(int indexAddItem, T addItem) {
        if (++currentItem > this.array.size() - 1) {
            this.array.increaseArraySize(this.array.size() * 2);
        }
        this.array.shiftElementRight(indexAddItem, currentItem);
        this.array.set(addItem, indexAddItem);
    }

    /**
     * Заменяет элемент в контейнере.
     * @param indexUpdateItem индекс заменяемого элемента.
     * @param itemUpdate обновляемый элемент.
     * @return если операция добавления завершилась успешно возвращает true.
     */
    public boolean update(int indexUpdateItem, T itemUpdate) {
        this.array.set(itemUpdate, indexUpdateItem);
        return true;
    }

    /**
     * Удаляет элемент по индексу.
     * @param indexDeleteItem индекс удаляемого элемента.
     * @return в слуучае успеха возвращает удаленный элемент.
     */
    @SuppressWarnings("unchecked")
    public T delete(int indexDeleteItem) {
        T oldValue = (T) array.get(indexDeleteItem);
        this.array.shiftElementLeft(indexDeleteItem, currentItem);
        this.currentItem--;
        return oldValue;
    }

    /**
     * Удаляет первый найденный с начала контейнера элемент.
     * @param deleteItem Удаляемый элемент.
     * @return в случае успеха возвращает удалённый элемент, в противном случае если такого элемента нет null.
     */
    @SuppressWarnings("unchecked")
    public T delete(T deleteItem) {
        T oldValue = null;
        int indexDeleteItem = this.array.findItem(deleteItem);
        if (indexDeleteItem != -1) {
            oldValue = (T) array.get(indexDeleteItem);
            this.array.shiftElementLeft(indexDeleteItem, currentItem);
            this.currentItem--;
        }
        return oldValue;
    }

    /**
     * Возвращает элемент контейнера по индексу.
     * @param indexItem индекс элемента.
     * @return элемент контейнера.
     */
    @SuppressWarnings("unchecked")
    public T get(int indexItem) {
        return this.array.get(indexItem);
    }


    /**
     * Виртуально число размера массива(общее число элементов размещённых в контейнере).
     * @return число элементов в контейнере.
     */
    public int size() {
        return this.currentItem + 1;
    }


    /**
     * Переопределяем метод equals.
     * @param o объект с которым сравниваетм.
     * @return true если объекты равны, в противном случае false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayContainer<?> that = (ArrayContainer<?>) o;
        return currentItem == that.currentItem &&
                array.size() == that.size() &&
                array.equals(that);
    }

    /**
     * Переопределяем метод hashCode.
     * @return новый сгенерированный hashCode объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(array, currentItem);
    }


}
