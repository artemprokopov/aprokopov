package ru.job4j.simplearray;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс простого контейнера основанного на массиве(За аналог взят ArrayList).
 * @param <T> тип контейнера.
 */
public class SimpleArray<T> {
    /**
     * Смещение максимального размера массива относительно {@link Integer#MAX_VALUE}.
     */
    private static final int ARRAY_INDEX_MAX_VALUE_OFFSET = 5;
    /**
     * Максимальный размер массива принимается  как
     * {@link Integer#MAX_VALUE} - {@link SimpleArray#ARRAY_INDEX_MAX_VALUE_OFFSET}.
     */
    private static final int ARRAY_MAX_SIZE = Integer.MAX_VALUE - ARRAY_INDEX_MAX_VALUE_OFFSET;
    /**
     * Размер которым инициализируется массив {@link SimpleArray#array} по умолчанию.
     */
    private static final int ARRAY_INIT_SIZE = 10;
    /**
     * Хранилище элементов контейнера.
     */
    private  Object[] array;
    /**
     * Номер последнего элемента в контейнере, при пустом контейнере равен -1.
     */
    private int currentItem = 0;
    /**
     * Текущий размер хранилища {@link SimpleArray#array}.
     */
    private int size = 0;

    /**
     * Конструктор по умолчанию, вызывает конструктор с параметром {@link SimpleArray#SimpleArray(int)}
     * с значением {@link SimpleArray#ARRAY_INIT_SIZE}.
     */
    public SimpleArray() {
        this(ARRAY_INIT_SIZE);
    }

    /**
     * Конструктор с параметром инициализации размера массива {@link SimpleArray#array}.
     * @param initSize параметр инициализации размера массива {@link SimpleArray#array}.
     */
    public SimpleArray(int initSize) {
        this.size = initSize;
        this.array =  new Object[initSize];
    }

    /**
     * Метод добавления элемента в контейнер.
     * Добавляет элемент в хвост массива {@link SimpleArray#array}
     * @param addItem добавляемый в контейнер элемент тип T.
     * @return возвращает true если операция выполняется успешно.
     */
    public boolean add(T addItem) {
        checkAddSizeArray();
        this.array[++currentItem] = addItem;
        return true;
    }

    /**
     * Добавляет элемент в контейнер по индексу, хвост массива сдвигаетс в право.
     * @param indexAddItem индекс элемента вставки.
     * @param addItem элемент вставки.
     */
    @SuppressWarnings("unused")
	private void add(int indexAddItem, T addItem) {
        checkIndex(indexAddItem);
        checkAddSizeArray();
        copyTailArrayWhenAddItem(indexAddItem);
        this.currentItem++;
        array[indexAddItem] = addItem;
    }

    /**
     * Заменяет элемент в контейнере.
     * @param indexUpdateItem индекс заменяемого элемента.
     * @param itemUpdate обновляемый элемент.
     * @return если операция добавления завершилась успешно возвращает true.
     */
    public boolean update(int indexUpdateItem, T itemUpdate) {
        checkIndex(indexUpdateItem);
        this.array[indexUpdateItem] = itemUpdate;
        return true;
    }

    /**
     * Удаляет элемент по индексу.
     * @param indexDeleteItem индекс удаляемого элемента.
     * @return в слуучае успеха возвращает удаленный элемент.
     */
    @SuppressWarnings("unchecked")
    public T delete(int indexDeleteItem) {
        checkIndex(indexDeleteItem);
        T oldValue = (T) array[indexDeleteItem];
        copyTailArrayWhenDeleteItem(indexDeleteItem);
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
        int indexDeleteItem = findItem(deleteItem);
        if (indexDeleteItem != -1) {
            oldValue = (T) array[indexDeleteItem];
            copyTailArrayWhenDeleteItem(indexDeleteItem);
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
        checkIndex(indexItem);
        return (T) array[indexItem];
    }
    /**
	 * Проверка есть ли элементы в контейнере.
	 * @return true если контейнер не содержит ни одного элемента.
	 */
	public boolean isEmpty() {
	    return this.size == 0;
	}

	/**
     * Уменьшает размер массива {@link SimpleArray#array}
     * до размера {@link SimpleArray#currentItem} + 1.
     */
    public void trim() {
        this.array = Arrays.copyOf(array, this.currentItem + 1);
        this.size = this.currentItem + 1;
    }

    /**
     * Виртуально число размера массива(общее число элементов размещённых в контейнере).
     * @return число элементов в контейнере.
     */
    public int size() {
        return this.currentItem + 1;
    }

    /**
     * Проверка индекса на принадлежность диапазону 0 <= i <= {@link SimpleArray#currentItem}.
     * @param checkIndex проверяемый индекс.
     */
    private void checkIndex(int checkIndex) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(checkIndex));
        }
        if (checkIndex > currentItem || checkIndex <= 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(checkIndex));
        }
    }

    /**
     * Поиск элемента в контейнере.
     * @param searchItem искомый элемент.
     * @return индекс найденного элемента, в противном случае если элемент не найден -1.
     */
    private int findItem(T searchItem) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i <= currentItem; i++) {
            if (searchItem.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Проверка на то что размер массива {@link SimpleArray#array} позволяет провести добавление элемента
     * если не позволяет, массив расширяется.
     */
    private void checkAddSizeArray() {
        if (currentItem + 1 >= size) {
            size = checkMaxSizeArray();
            array = Arrays.copyOf(array, size);
        }
    }

    /**
     * Проверка на то что размер массива {@link SimpleArray#array} не выходит за максимально возможный размер
     * {@link SimpleArray#ARRAY_MAX_SIZE}, если не выходит возвращает новый возможный размер массива.
     * Если увеличение размера не возможно, то генерирует исключение {@link OutOfMemoryError}
     * @return новый допустимый размер массива.
     */
    private int checkMaxSizeArray() {
        if (ARRAY_MAX_SIZE - (currentItem + 1) == 0) {
            throw new OutOfMemoryError("The array index is greater than the maximum possible values");
        }
        int newSize = size + size;
        return ARRAY_MAX_SIZE - size > size ? newSize : ARRAY_MAX_SIZE;
    }

    /**
     * Копирует хвост массива начиная indexDeleteItem + 1 на один элемент влево.
     * @param indexDeleteItem индекс удаляемого элемента.
     */
    private void copyTailArrayWhenDeleteItem(int indexDeleteItem) {
        System.arraycopy(array, indexDeleteItem + 1,
                array, indexDeleteItem, currentItem + 1 - indexDeleteItem + 1);
    }

    /**
     * Копирует хвост массива начиная indexAddItem на один элемент влево, освобождает элемент для добавления нового.
     * @param indexAddItem индекс добавляемого элемента.
     */
    private void copyTailArrayWhenAddItem(int indexAddItem) {
        System.arraycopy(array, indexAddItem,
                array, indexAddItem + 1, currentItem + 1 - indexAddItem + 1);
    }
    /**
     * Метод формирует сообщение для генерируемых исключений в методе {@link SimpleArray#checkIndex(int)}.
     * @param index индекс для формирования строки сообщения.
     * @return сформированную строку.
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + (currentItem + 1);
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
        SimpleArray<?> that = (SimpleArray<?>) o;
        return currentItem == that.currentItem &&
                size == that.size &&
                Arrays.equals(array, that.array);
    }

    /**
     * Переопределяем метод hashCode.
     * @return новый сгенерированный hashCode объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(array, currentItem, size);
    }


}
