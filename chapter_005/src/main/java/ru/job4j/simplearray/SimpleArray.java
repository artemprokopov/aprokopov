package ru.job4j.simplearray;

import java.util.Arrays;

public class SimpleArray<T> {
    private static final int ARRAY_INDEX_MAX_VALUE_OFFSET = 5;
    private static final int ARRAY_MAX_SIZE = Integer.MAX_VALUE - ARRAY_INDEX_MAX_VALUE_OFFSET;
    private static final int ARRAY_INIT_SIZE = 10;
    private  Object[] array;
    private int currentItem = -1;
    private int size;

    public SimpleArray() {
        this(ARRAY_INIT_SIZE);
    }

    public SimpleArray(int initSize) {
        this.size = initSize;
        this.array = new Object[initSize];
    }

    public boolean add(T addItem) {
        checkAddSizeArray();
        this.array[++currentItem] = addItem;
        return true;
    }

    private boolean add(int indexAddItem, T addItem) {
        chekIndex(indexAddItem);
        checkAddSizeArray();
        copyTailArrayWhenAddItem(indexAddItem);
        this.currentItem++;
        array[indexAddItem] = addItem;
        return true;
    }

    public boolean update(int indexUpdateItem, T ItemUpdate) {
        chekIndex(indexUpdateItem);
        this.array[indexUpdateItem] = ItemUpdate;
        return true;
    }

    public T delete(int indexDeleteItem) {
        chekIndex(indexDeleteItem);
        T oldValue = (T) array[indexDeleteItem];
        copyTailArrayWhenDeletItem(indexDeleteItem);
        this.currentItem--;
        return oldValue;
    }

    public T delete(T deleteItem) {
        T oldValue = null;
        int indexDeleteItem = findItem(deleteItem);
        if (indexDeleteItem != -1) {
            oldValue = (T) array[indexDeleteItem];
            copyTailArrayWhenDeletItem(indexDeleteItem);
            this.currentItem--;
        }
        return oldValue;
    }

    public T get(int indexItem) {
        chekIndex(indexItem);
        return (T) array[indexItem];
    }

    public boolean isEmpty() {
        return this.currentItem == -1;
    }

    public boolean trim() {
        this.array = Arrays.copyOf(array, this.currentItem + 1);
        this.size = this.currentItem + 1;
        return true;
    }

    private boolean chekIndex(int checkIndex) {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(this + ": Array empty!");
        }
        if (checkIndex > currentItem) {
            throw new ArrayIndexOutOfBoundsException(checkIndex + " than the last index in the array " + this);
        }
        if (checkIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(checkIndex + "index less than zero!!!");
        }
        return true;
    }

    private int findItem(T searchItem) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < currentItem; i++) {
            if (searchItem.equals((T) array[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkAddSizeArray() {
        if (currentItem + 1 >= size) {
            size = checkMaxSizeArray();
            array = Arrays.copyOf(array, size);
        }
        return true;
    }

    private int checkMaxSizeArray() {
        if (ARRAY_MAX_SIZE - (currentItem + 1) == 0) {
            throw new OutOfMemoryError("The array index is greater than the maximum possible values");
        }
        return ARRAY_MAX_SIZE - size > size
                ? size =+ size : ARRAY_MAX_SIZE;
    }

    private void copyTailArrayWhenDeletItem(int indexDeleteItem) {
        System.arraycopy(array, indexDeleteItem + 1,
                array, indexDeleteItem, currentItem + 1 - indexDeleteItem + 1);
    }

    private void copyTailArrayWhenAddItem(int indexAddItem) {
        System.arraycopy(array, indexAddItem,
                array, indexAddItem + 1, currentItem + 1 - indexAddItem + 1);
    }
}
