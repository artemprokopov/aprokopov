package ru.job4j.accapplications;

import java.util.Arrays;

/**
 * Created by Prokopov on 02.05.2017.
 * @param <T>
 */
public class AccArray<T> {
    /**
     * Базовый массив.
     */
    private Object[] array;

    /**
     * Размер массива для первой инициализации.
     */
    private static final int INIT_SIZE = 10;

    /**
     * Максимально количество элементов массиве.
     */
    private static final int MAX_SIZE = Integer.MAX_VALUE - 10;

    /**
     * Пустой массив, для ситуаций удаления всех элементов, и состояния массива
     * до добавления первого эллемента.
     */
    public static final Object[] EMPTY_ARRAY = {};

    /**
     * Количество элементов находящихся в массиве в данный момент времени.
     */
    private int size = 0;

    /**
     *
     */
    public AccArray() {
        this.array = AccArray.EMPTY_ARRAY;
    }

    /**
     * Метод добавляет объект в массив.
     *@param o добавляемый объект.
     */
    public void add(Object o) {
        checkSizeAdd(size + 1);
        ++size;
        array[size - 1] = o;
    }

    /**
     *Метод удаляет объект из массива.
     * @param o удаляемый объект.
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
            System.arraycopy(array, index + 1, array, index, size - 1 - index);
            --size;
        } else {
          array = AccArray.EMPTY_ARRAY;
          --size;
        }
    }

    /**
     * Удаляет объект по индексу в массиве.
     * @param index индекс удаляемого объекта.
     */
    public void delete(int index) {
        chekIndex(index);
        checkSizeDelete(size - 1);
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        --size;
    }


    /**
     * Метод возвращает текущий размер массива.
     * @return size текущи размер массива
     */
    public int size() {
        return this.size;
    }

    /**
     * Возвращает элемент массива по индексу.
     * @param index индекс элемента массива.
     * @return T возвращаемый объект массива.
     */
    public T get(int index) {
      if (array == AccArray.EMPTY_ARRAY) {
          throw new IllegalArgumentException("Array empty");
      }
      chekIndex(index);
      return (T) array[index];
    }

    /**
     * Добавлет элемент в массив по заданному индексу.
     * @param index индекс массива.
     * @param o добавляемый объект.
     */
    public void set(int index, T o) {
        chekIndex(index);
        array[index] = o;
    }

    /**
     * Обределяет индекс первого вхождения элемента в массиве.
     * @param o объект индекс которого требуется определить.
     * @return int возвращаемый индекс объекта,
     * либо в случае отсутстви объекта возвращается -1.
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
     * Возвразает находящиеся в массиве объекты.
     * @return Object[] возвращается массив объектов.
     */
    public Object[] toArray() {
        return  toArray(new Object[size]);
    }

    /**
     * Возвращает находящиеся в массиве объекты приведенные к заданному типу.
     * @param a Массив требуемый тип.
     * @param <T> Контрольный тип.
     * @return T[] массив  объектов заданного типа.
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.copyOf(array, size, a.getClass());
    }

    /**
     * Служебный метод, контролирует размер базового массива, при добовлении элемента.
     * @param check проверяемое значение размера базового массива.
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
     * Служебный метод, контролирует размер базового массива, при удалении элемента.
     * @param check проверяемое значение размера базового массива.
     */
    private void checkSizeDelete(int check) {
        int newSize = array.length / 2;
        if (check < newSize && check != 0) {
            Object[] temp = new Object[array.length / 2];
            System.arraycopy(array, 0, temp, 0, newSize);
            array = temp;
        }
    }

    /**
     * Служебный метод, проверяет индекс массива на вхождение в диапазон.
     * @param index проверяемый индекс.
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
     * Метод проверяет есть ли объекты в базовом массиве.
     * @return true если базовый масси пуст, в противном случае false.
     */
    public boolean isEmpty() {
            return size == 0;
    }
}
