package ru.job4j.simplecontainer;
/**
 * Интерфейс простого контейнера Set<E>.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */
public interface SimpleSet<E> extends SimpleContainer<E> {
    /**
     * Метод добавления элемента в контейнер.
     * @param addItem добавляемый в контейнер элемент тип E.
     * @return true если операция завершена, в противном случа false.
     */
    boolean add(E addItem);

    /**
     * Метод поиска элемента в контейнере.
     * @param e искомый элемент.
     * @return true если элемнтв существует в контейнере, в противном случа false.
     */
    boolean contains(E e);
    /**
     * Метод удаления элемента из контейнера.
     * @param e удаляемый элемент.
     * @return true если операция завершена, в противном случа false.
     */
    boolean remove(E e);
}
