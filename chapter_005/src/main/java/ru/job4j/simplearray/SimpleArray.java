package ru.job4j.simplearray;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SimpleArray<T> {
    private final Object[] array;
    private int currentElement = -1;
    private int size;

    public SimpleArray() {
        this(10);
    }

    public SimpleArray(int initSize) {
        this.size = initSize;
        this.array = new Object[initSize];
    }

    public boolean add(T addElement) {

        return true;
    }

    public boolean add(int addIndexElement, T addElement) {
        chekIndex(addIndexElement);

        array[addIndexElement] = addElement;
        return true;
    }

    public boolean update(int indexUpdateElement, T elementUpdate) {
        chekIndex(indexUpdateElement);
        array[indexUpdateElement] = elementUpdate;
        return true;
    }

    public T delete(int indexDeleteElement) {
        chekIndex(indexDeleteElement);
        T oldValue = (T) array[indexDeleteElement];
        return oldValue;
    }

    public T delete(T deleteElement) {
        T oldValue = null;
        int indexDeleteElement = findElement(deleteElement);
        if (indexDeleteElement != -1) {
            oldValue =(T) array[indexDeleteElement];
            System.arraycopy(array, indexDeleteElement + 1,
                    array, indexDeleteElement, currentElement + 1 - indexDeleteElement + 1);
        }
        return oldValue;
    }

    public T get(int indexElement) {
        chekIndex(indexElement);
        return (T) array[indexElement];
    }

    public boolean isEmpty() {
        return currentElement == -1;
    }

    public boolean trimArraySize() {
        return true;
    }

    private boolean chekIndex(int checkIndex) {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException(this + ": Array empty!");
        }
        if(checkIndex > currentElement) {
            throw new ArrayIndexOutOfBoundsException(checkIndex + " than the last index in the array " + this);
        }
        if(checkIndex < 0) {
            throw new ArrayIndexOutOfBoundsException(checkIndex + "index less than zero!!!");
        }
        return true;
    }

    private int findElement(T searchElement) {
        if (isEmpty()) {
            return -1;
        }
        for (int i = 0; i < currentElement; i++) {
            if (searchElement.equals((T) array[i])) {
                return i;
            }
        }
        return -1;
    }

    private boolean ceckAddSizeArray() {

        return true;
    }
}
