package ru.job4j.simplearray;

public class SimpleArray<T> {
    private final Object[] array;
    private int size = 0;

    public SimpleArray() {
        this(10);
    }

    public SimpleArray(int initSizeArray) {
        this.array = new Object[initSizeArray];
    }

    public void add(T element) {

    }
}
