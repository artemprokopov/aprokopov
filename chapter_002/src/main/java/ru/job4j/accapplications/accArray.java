package ru.job4j.accapplications;

import java.util.Arrays;

/**
 * Created by Prokopov on 02.05.2017.
 */
public class accArray<T> {
    private T[] array;

    private static final int INIT_SIZE = 10;
    private static final int MAX_SIZE = Integer.MAX_VALUE - 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int numberOfSegment = 1;
    private int size = 0;

    public accArray() {
        this.array = (T[])accArray.EMPTY_ARRAY;
    }

    public void add(T o) {
        if (this.array != accArray.EMPTY_ARRAY
                && this.size < accArray.INIT_SIZE * this.numberOfSegment
                && this.size < accArray.MAX_SIZE) {
            ++this.size;
            this.array[size - 1] = o;
        } else if (this.array != accArray.EMPTY_ARRAY
                && this.size == accArray.INIT_SIZE * this.numberOfSegment
                && this.size < accArray.MAX_SIZE) {
            ++this.size;
            ++this.numberOfSegment;
            T[] temp = (T[]) new Object[this.INIT_SIZE * this.numberOfSegment];
            temp = Arrays.copyOf(this.array, this.size );
            temp[this.size - 1] = o;
            this.array = temp;
        } else if (array == accArray.EMPTY_ARRAY && this.size == 0) {
            ++this.size;
            this.array = (T[]) new Object[accArray.INIT_SIZE];
            this.array[0] = o;
        }
    }

    public int size() {
        return this.size;
    }

    public int indexOf(T o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public T[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }
}
