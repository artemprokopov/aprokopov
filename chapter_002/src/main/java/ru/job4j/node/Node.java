package ru.job4j.node;

/**
 * Класс узел списка.
 * @author Artem Prokopov
 * @since 04.08.2017
 * @version 1.0
 */
class Node {
    /**
     * Ссылка на следующий элемнт списка.
     */
    private Node next;
    /**
     * Значение элемента.
     */
    private int value;

    /**
     * Геттер для поля класса next.
     * @return поле класса {@link Node#next}
     */
    public Node getNext() {
        return next;
    }

    /**
     * Сеттер для поля класса next.
     * @param next устанавливаемое значение.
     */
    public void setNext(Node next) {
        this.next = next;
    }

    /**
     * Геттер поля класса value.
     * @return поле класса {@link Node#value}
     */
    public int getValue() {
        return value;
    }

    /**
     * Сеттер для поля класса value.
     * @param value устанавливаемое значение.
     */
    public void setValue(int value) {
        this.value = value;
    }
}