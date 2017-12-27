package ru.job4j.checkcyclicallist;
/**
 * Класс узла односвязного списка.
 * @param <T> тип контейнера.
 * @author Artem Prokopov
 * @since 27/12/2017
 * @version 1.0
 */
public class Node<T> {
    T value;
    Node<T> next;
}
