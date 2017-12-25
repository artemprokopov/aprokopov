package ru.job4j.checkcyclicallist;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Тестовый класс для {@link CycleList}.
 * @author Artem Prokopov
 * @since 27/12/2017
 * @version 1.0
 */

public class CycleListTest {
    /**
     * Указатель на голову односвязного списка, для теста метода {@link CycleList#hasCycle(Node)}.
     * Применяется в тестовом методе {@link CycleListTest#hasCycle1()}.
     * Список зациклен ерез первый элемент списка, ожидаем результат возвращаемый методом равный true.
     */
    private final Node<Integer> firstTestNode;
    {
        firstTestNode = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);

        firstTestNode.next = two;
        two.next = third;
        third.next = four;
        four.next = firstTestNode;
    }
    /**
     * Указатель на голову односвязного списка, для теста метода {@link CycleList#hasCycle(Node)}.
     * Применяется в тестовом методе {@link CycleListTest#hasCycle2()}.
     * Список зациклен через третий элемент списка, ожидаем результат возвращаемый методом равный true.
     */
    private final Node<Integer> secondTestNode;
    {
        secondTestNode = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        secondTestNode.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = third;
    }
    /**
     * Указатель на голову односвязного списка, для теста метода {@link CycleList#hasCycle(Node)}.
     * Применяется в тестовом методе {@link CycleListTest#hasCycle3()}.
     * Список не зациклен, ожидаем результат возвращаемый методом равный false.
     */
    private final Node<Integer> thirdTestNode;
    {
        thirdTestNode = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        Node<Integer> five = new Node<>(5);

        thirdTestNode.next = two;
        two.next = third;
        third.next = four;
        four.next = five;
        five.next = null;
    }

    /**
     * Тестируем метод {@link CycleList#hasCycle(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#firstTestNode}, ожидаем результат действия метода равный true.
     */
    @Test
    public void hasCycle1() {
        assertTrue(new CycleList().hasCycle(firstTestNode));
    }
    /**
     * Тестируем метод {@link CycleList#hasCycle(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#secondTestNode}, ожидаем результат действия метода равный true.
     */
    @Test
    public void hasCycle2() {
        assertTrue(new CycleList().hasCycle(secondTestNode));
    }
    /**
     * Тестируем метод {@link CycleList#hasCycle(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#thirdTestNode}, ожидаем результат действия метода равный false.
     */
    @Test
    public void hasCycle3() {
        assertFalse(new CycleList().hasCycle(thirdTestNode));
    }
    /**
     * Тестируем метод {@link CycleList#hasCycleFindLoop(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#firstTestNode}, ожидаем результат действия метода равный true.
     */
    @Test
    public void hasCycle4() {
        assertTrue(new CycleList().hasCycleFindLoop(firstTestNode));
    }
    /**
     * Тестируем метод {@link CycleList#hasCycleFindLoop(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#secondTestNode}, ожидаем результат действия метода равный true.
     */
    @Test
    public void hasCycle5() {
        assertTrue(new CycleList().hasCycleFindLoop(secondTestNode));
    }
    /**
     * Тестируем метод {@link CycleList#hasCycleFindLoop(Node)}, для теста используем список с указателем на голову списка
     * {@link CycleListTest#thirdTestNode}, ожидаем результат действия метода равный false.
     */
    @Test
    public void hasCycle6() {
        assertFalse(new CycleList().hasCycleFindLoop(thirdTestNode));
    }
}