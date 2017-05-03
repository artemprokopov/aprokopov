package ru.job4j.accapplications;

import java.util.Arrays;

/**
 * Created by Prokopov on 02.05.2017.
 */
public class AccArray<T> {
    private Object[] array;

    private int INIT_SIZE = 10;
    private int MAX_SIZE = Integer.MAX_VALUE - 10;
    private static final Object[] EMPTY_ARRAY = {};
    private int size = 0;

    public AccArray() {
        this.array = AccArray.EMPTY_ARRAY;
    }

    public AccArray(int initSize) {
        INIT_SIZE = initSize;
    }

    public void add(Object o) {
        chekSize(size + 1);
        ++size;
        array[size - 1] = o;
    }

    public void delete(Object o) {
        chekSize(size - 1);
        --size;
        int index = indexOf(o);
        if (index != -1) {
            System.arraycopy(array, index + 1, array, index, size - index -1 );
        }
        if (index == -1) {
            throw new IllegalArgumentException("No object in array");
        }
    }

    public void delete(int index) {
        chekIndex(index);
        chekSize(index);
        System.arraycopy(array, index + 1, array, index, size - index -1 );
    }

    public int size() {
        return this.size;
    }

    public Object get(int index) {
      if (array != AccArray.EMPTY_ARRAY) {
        chekIndex(index);
        return array[index];
      }
      return null;
    }

    public void set(int index, T o) {
        chekIndex(index);
        array[index] = o;
    }

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

    public Object[] toArray() {
      if (array != AccArray.EMPTY_ARRAY) {
        return Arrays.copyOf(array, size);
      }
        return AccArray.EMPTY_ARRAY;
    }
    
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        System.arraycopy(array, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    private void chekSize(int chek) {
        // Проверяем на достижение конца выделенного массива если да, увеличиваем массив
        if (chek > size && chek == array.length) {
            int maxSize;
            if (array.length * 2 > MAX_SIZE || array.length * 2 < 0) {
                maxSize = MAX_SIZE;
            } else {
                maxSize = array.length * 2;
            }
            Object[] temp = new Object[maxSize];
            temp = Arrays.copyOf(array, chek);
            array = temp;
        }
        //Смотрим на уменьшение элементов в массиве, если меньше половины обрезаем массив
        if (chek < size && chek < array.length / 2 && chek != 0) {
            Object[] temp = new Object[array.length / 2];
            temp = Arrays.copyOf(array, chek);
            array = temp;
        }
        //Первичная иницилизация массива.
        if (chek == 1 && array == AccArray.EMPTY_ARRAY) {
            array = new Object[INIT_SIZE];
        }
        //Без значений обнуляем массив
        if (chek == 0) {
          array = AccArray.EMPTY_ARRAY;
        }
        //Ловим не корректное знчение
        if(chek > array.length) {
            throw new IllegalArgumentException("chekSize chek > " + array.length + " " + chek);
        }
        if (chek < 0) {
            throw new IllegalArgumentException("chekSize chek < 0");
        }
        if (chek > MAX_SIZE) {
            throw new IllegalArgumentException("chekSize chek > " + MAX_SIZE + " " + chek);
        }
    }


    private void chekIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("chekIndex index < 0");
        }
        if (index > MAX_SIZE) {
            throw new IllegalArgumentException("chekIndex index > MAX_SIZE");
        }
        if (index > size) {
            throw new IllegalArgumentException("chekIndex index > 0");
        }
    }

    public boolean isEmpty() {
            return size == 0;
    }
}
