package ru.job4j.accapplications;

import java.util.Arrays;

/**
 * Created by Prokopov on 02.05.2017.
 * @param <T>
 */
public class AccArray<T> {
    /**
     *
     */
    Object[] array;

    /**
     *
     */
    private static final int INIT_SIZE = 10;

    /**
     *
     */
    private static final int MAX_SIZE = Integer.MAX_VALUE - 10;

    /**
     *
     */
    private static final Object[] EMPTY_ARRAY = {};

    /**
     *
     */
    private int size = 0;

    /**
     *
     */
    public AccArray() {
        this.array = AccArray.EMPTY_ARRAY;
    }

    /**
     *
     */
    public void add(Object o) {
        checkSizeAdd(size + 1);
        ++size;
        array[size - 1] = o;
    }

    /**
     *
     * @param o
     */
    public void delete(Object o) {
        if (array == AccArray.EMPTY_ARRAY) {
            throw new IllegalArgumentException("Array EMPTY");
        }
        int index = indexOf(o);
        if (index == -1) {
            throw new IllegalArgumentException("No object in array");
        }
        checkSizeDelete(size - 1);
        if (size != 1) {
            System.arraycopy(array, index + 1, array, index, size - index);
            --size;
        } else if (size == 1) {
          array = AccArray.EMPTY_ARRAY;
          --size;
        }
    }

    /**
     *
     * @param index
     */
    public void delete(int index) {
        chekIndex(index);
        checkSizeDelete(size - 1);
        System.arraycopy(array, index + 1, array, index, size - index -1 );
        array[size - 1] = null;
        --size;
    }


    /**
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     *
     * @param index
     * @return T
     */
    public T get(int index) {
      if (array == AccArray.EMPTY_ARRAY ) {
          throw new IllegalArgumentException("Array empty");
      }
      chekIndex(index);
      return (T)array[index];
    }

    public void set(int index, T o) {
        chekIndex(index);
        array[index] = o;
    }

    /**
     *
     * @param o
     * @return
     */
    public int indexOf(Object o) {
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

    /**
     *
     * @return
     */
    public Object[] toArray() {
        return  toArray(new Object[size]);
    }
    
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, size, a.getClass());
    }

    /**
     *
     * @param check
     */
    private void checkSizeAdd(int check) {
        if (check > AccArray.MAX_SIZE) {
            throw new OutOfMemoryError("chek > MAX_SIZE: "
                    + check + " > "
                    + AccArray.MAX_SIZE);
        }
        if (check == array.length) {
            long newSizeTest = array.length * 2;
            int newSize;
            if (newSizeTest > AccArray.MAX_SIZE) {
                newSizeTest = AccArray.MAX_SIZE;
            }
            newSize = (int) newSizeTest;
            Object[] temp = new Object[newSize];
            System.arraycopy(array, 0, temp, 0, size);
            array = temp;
        }
        if (array == AccArray.EMPTY_ARRAY) {
            array = new Object[AccArray.INIT_SIZE];
        }
    }

    /**
     *
     * @param check
     */
    private void checkSizeDelete(int check) {
        int newSize = array.length / 2;
        if (check < newSize && check != 0) {
            Object[] temp = new Object[array.length / 2];
            System.arraycopy(array,0, temp, 0, newSize);
            array = temp;
        }
    }

    /**
     *
     * @param index
     */
    private void chekIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("chekIndex index < 0");
        }
        if (index > MAX_SIZE) {
            throw new IllegalArgumentException("chekIndex index > MAX_SIZE");
        }
        if (index > size) {
            throw new IllegalArgumentException("chekIndex index > size array");
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
            return size == 0;
    }
}
