package ru.job4j.node;

/**
 * Класс односвязный список.
 * @author Artem Prokopov
 * @since 04.08.2017
 * @version 1.0
 */

public class ListNode {
    /**
     * Указатель на голову списка.
     */
    private  Node startNode;
    /**
     * Указатель на последний элемент списка.
     */
    private  Node lastNode;
    /**
     * Количество элементов в списке.
     */
    private  int size = 0;

    /**
     * Вставка элемента в голову списка.
     * @param value добавляемое значение.
     */
    public void addValueFirst(int value) {
        Node newNode = new Node();
        newNode.setValue(value);
        if (startNode == null) {
            startNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        size++;
    }

    /**
     * Добавление значения в хвост списка.
     * @param value добавляемое значение.
     */
    public  void addValueLast(int value)  {
        Node newNode = new Node();
        newNode.setValue(value);
        if (startNode == null) {
            startNode = newNode;
        } else {
            newNode.setNext(startNode);
            lastNode = startNode;
            startNode = newNode;
        }
        size++;
    }

    /**
     * Получение значения i-ого элемента списка.
     * @param nodeNumber номер элемнта списка.
     * @return значение элемента списка.
     * @throws IndexOutOfBoundsException выбрасывается исключение при указании несуществующего индекса.
     */
    public int getValue(int nodeNumber) throws IndexOutOfBoundsException {
        if (nodeNumber < 0 && nodeNumber > size) {
            throw new IndexOutOfBoundsException();
        }
        Node result = startNode;
        for (int i = 1; i < nodeNumber; i++) {
            result = result.getNext();
        }
        return result.getValue();
    }

    /**
     * Получение i-ого узла списка.
     * @param nodeNumber номер элемнта списка.
     * @return узел списка.
     */
    public Node get(int nodeNumber) {
        if (nodeNumber < 0 && nodeNumber > size) {
            throw new IndexOutOfBoundsException();
        }
        Node result = startNode;
        for (int i = 1; i < nodeNumber; i++) {
            result = result.getNext();
        }
        return result;
    }

    /**
     * Поворот списка путем добавления текущего значений в хвост нового списка.
     */
    public void rotate() {
        Node oldNode = startNode;
        if (oldNode != null) {
            startNode = null;
            size = 0;
           do {
                addValueLast(oldNode.getValue());
                oldNode = oldNode.getNext();
           } while (oldNode != null);
        }
    }

    /**
     * Поворот списка путем манипуляции ссылками.
     */
    public void rotateLink() {
        Node current  = startNode;
        Node newNod = null;
        if (startNode != null) {
            lastNode = current;
            while (current != null) {
                Node next = current.getNext();
                current.setNext(newNod);
                newNod = current;
                current = next;
            }
        }
        startNode = newNod;
    }

    /**
     * Поворот списка, рекурсивным методом {@link ListNode#rotateThisRecur(Node)}.
     */
    public void rotateLinkRecur() {
        if (startNode != lastNode) {
            lastNode = rotateThisRecur(startNode);
            lastNode.setNext(null);
        }
    }

    /**
     * Рекурсивный метод повората списка.
     * @param current поворачиваемый список.
     * @return Node развернутый список(хвост списка).
     */
    private Node rotateThisRecur(Node current) {
        if (current.getNext() == null) {
            startNode = current;
        } else {
            rotateThisRecur(current.getNext()).setNext(current);
        }
        return current;
    }

    /**
     * Поворот списка считывание элементов списка и их добавления в новы список.
     */
    public void rotateThis() {
        Node newNode = null;
        if (startNode != null) {
            newNode = get(size);
            lastNode = newNode;
            for (int i = size - 1; i > 0; i--) {
               lastNode.setNext(get(i));
               lastNode.getNext().setNext(null);
               lastNode = lastNode.getNext();
            }
        }
        startNode = newNode;
    }
}

