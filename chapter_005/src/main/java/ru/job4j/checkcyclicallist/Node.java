package ru.job4j.checkcyclicallist;
/**
 * Класс узла односвязного списка.
 * @param <T> тип контейнера.
 * @author Artem Prokopov
 * @since 27/12/2017
 * @version 1.0
 */
public class Node<T> {
    //CHECKSTYLE:OFF
    /**
     * Значение узла.
     */
    T value;
    /**
     * Ссылка на следующий узел.
     */
    Node<T> next;
    //CHECKSTYLE:ON

    /**
     * Конструктор узла.
     * @param initValue значение узла.
     */
    Node(T initValue) {
        this.value = initValue;
    }
}

