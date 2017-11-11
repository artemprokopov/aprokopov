package ru.job4j.simplearray;

/**
 * Интерфейс массива.
 */
public interface Array<T> {
    /**
     * Проверка есть ли элементы в контейнере.
     * @return true если контейнер не содержит ни одного элемента.
     */
    boolean isEmpty();
    /**
     * Размера массива.
     * @return число элементов в массиве.
     */
    int size();

    /**
     * Уменьшает размер массива до указанного размера trimSize.
     * @param trimSize размер обрезки массива.
     * @return обрезанный справа массив.
     */
    boolean trim(int trimSize);

    /**
     * Возвращаем i-ый элемент массива.
     * @param i номер элемента.
     * @return знаение элемнта массива.
     */
    T get(int i);

    /**
     * Устанавливаем
     * @param setElement
     * @param
     * @return
     */
    <T> void set(T setElement, int i);

    /**
     *
     * @param newSize
     * @return
     */
    boolean increaseArraySize(int newSize);

    /**
     *
     * @param startIndex
     * @return
     */
    boolean shiftElementLeft(int startIndex, int endIndex);

    /**
     *
     * @param startIndex
     * @return
     */
    boolean shiftElementRight(int startIndex, int endIndex);

    /**
     *
     * @param findElemetn
     * @return
     */
    int findItem(T findElemetn);
}
