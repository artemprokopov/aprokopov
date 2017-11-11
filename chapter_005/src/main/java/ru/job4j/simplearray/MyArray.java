package ru.job4j.simplearray;

import java.util.Arrays;
import java.util.Objects;

/**
 * Класс массива.
 * @author Artem Prokopov
 * @since 11/11/2017
 * @version 1.0
 */
public class MyArray<T> implements Array<T> {
    /**
     *  Объект предоставляет всмпомогательные методы работы над массивом {@link ArrayContainer#array}.
     *  Так же хранилище констант.
     */
    private static final ArrayUtil arrayUtil = new MyArrayUtil();
    /**
     * Хранилище элементов контейнера.
     */
    private  Object[] array;

    /**
     * Конструктор по умолчанию.
     * Создает массив {@link MyArray#array} размером {@link ArrayUtil#ARRAY_INIT_SIZE}
     */
    public MyArray(){
        this(arrayUtil.getArrayInitSize());
    }
    /**
     * Конструктор.
     * Создает массив {@link MyArray#array} размером {@link ArrayUtil#ARRAY_INIT_SIZE}
     * @param initSize начальны размер массива.
     */
    public MyArray(int initSize) {
        this.array = new Object[initSize];
    }


    /**
     * Проверка есть ли элементы в контейнере.
     * @return true если контейнер не содержит ни одного элемента.
     */
    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Уменьшает размер массива {@link MyArray#array}
     * до размера trimSize.
     * @param trimSize размер обрезки массива {@link MyArray#array}
     */
    @Override
    public boolean trim(int trimSize) {
        if (arrayUtil.checkIndex(this, trimSize - 1)) {
            this.array = Arrays.copyOf(array, trimSize);
            return true;
        }
        return false;
    }

    /**
     * Размер массива.
     * @return размер массива..
     */
    @Override
    public int size() {
        return this.array.length;
    }

    /**
     *
     * @param i
     * @return
     */
    @Override
    public T get(int i) throws IllegalArgumentException  {
        if(!arrayUtil.checkIndex(this, i)) {
            throw new IllegalArgumentException(arrayUtil.outOfBoundsMsg(i, this.size() - 1));
        }
        return (T) array[i];
    }

    /**
     *
     * @param setElement
     * @param i
     */
    @Override
    public <T> void set(T setElement, int i) throws IllegalArgumentException {
        if(!arrayUtil.checkIndex(this, i)) {
            throw new IllegalArgumentException(arrayUtil.outOfBoundsMsg(i, this.size() - 1));
        }
        this.array[i] = setElement;
    }

    /**
     *
     * @param newSize
     * @return
     */
    @Override
    public boolean increaseArraySize(int newSize) {
        if(newSize <= this.size()) {
            return false;
        }
        if (newSize > arrayUtil.getArrayMaxSize()) {
            this.array = Arrays.copyOf(this.array, arrayUtil.getArrayMaxSize());
            return true;
        }
        this.array = Arrays.copyOf(this.array, newSize);
        return true;
    }

    /**
     *
     * @param startIndex
     * @param endIndex
     * @return
     */
    @Override
    public boolean shiftElementLeft(int startIndex, int endIndex) {
        if (arrayUtil.checkIndex(this, startIndex)
                && arrayUtil.checkIndex(this, endIndex)) {
            System.arraycopy(this.array, startIndex, this.array, startIndex -1, endIndex - startIndex);
            array[endIndex] = null;
            return true;
        }
        return false;
    }

    /**
     *
     * @param startIndex
     * @return
     */
    @Override
    public boolean shiftElementRight(int startIndex, int endIndex) {
        if(!arrayUtil.checkIndexByMaxArraySize(endIndex + 1)) {
            throw new IllegalArgumentException(arrayUtil.outOfBoundsMsg(endIndex + 1,
                    arrayUtil.getArrayMaxSize()));
        }
        if (arrayUtil.checkTrueTripleElement(this, startIndex, endIndex)) {
            System.arraycopy(this.array, startIndex, this.array, startIndex + 1, endIndex - startIndex + 1);
            array[startIndex] = null;
            return true;
        }
        return false;
    }

    /**
     *
     * @param findElemetn
     * @return
     */
    @Override
    public int findItem(T findElemetn) {
        return arrayUtil.findItem(this, findElemetn);
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArray<?> myArray = (MyArray<?>) o;
        return this.size() == myArray.size() &&
                Arrays.equals(array, myArray.array);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(array);
    }

}
