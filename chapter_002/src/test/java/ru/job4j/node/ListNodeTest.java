package ru.job4j.node;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Тесты односвязного списка {@link ListNode}.
 * @author Artem Prokopov
 * @since 04.08.2017
 * @version 1.0
 */

public class ListNodeTest {
    /**
     * Тест метода {@link ListNode#addValueFirst(int)}, добавление элемента в голову списка.
     */
    @Test
    public void addValueFirstOneTwoThreeThenListOneTwoThree() {
        ListNode listNode = new ListNode();
        listNode.addValueFirst(1);
        listNode.addValueFirst(2);
        listNode.addValueFirst(3);
        assertThat(listNode.getValue(1), is(1));
        assertThat(listNode.getValue(2), is(2));
        assertThat(listNode.getValue(3), is(3));
    }

    /**
     * Тест метода {@link ListNode#addValueLast(int)}, добавление жлемента в хвост списка.
     */
    @Test
    public void addValueLastOneTwoThreeThenListThreeTwoOne() {
        ListNode listNode = new ListNode();
        listNode.addValueLast(1);
        listNode.addValueLast(2);
        listNode.addValueLast(3);
        assertThat(listNode.getValue(1), is(3));
        assertThat(listNode.getValue(2), is(2));
        assertThat(listNode.getValue(3), is(1));
    }

    /**
     * Тест метода {@link ListNode#rotate()}.
     * Добавляем в список три элемента, значения которых равны 1, 2, 3.
     * Вызывем метод {@link ListNode#rotate()}, ожидаем перевернутый список 3, 2, 1.
     */
    @Test
    public void addValueOneTwoThreeRotateThenListThreeTwoOne() {
        ListNode listNode = new ListNode();
        listNode.addValueFirst(1);
        listNode.addValueFirst(2);
        listNode.addValueFirst(3);
        listNode.rotate();
        assertThat(listNode.getValue(1), is(3));
        assertThat(listNode.getValue(2), is(2));
        assertThat(listNode.getValue(3), is(1));
    }
    /**
     * Тест метода {@link ListNode#rotateLinkRecur()}.
     * Добавляем в список три элемента, значения которых равны 1, 2, 3.
     * Вызывем метод  {@link ListNode#rotateLinkRecur()}, ожидаем перевернутый список 3, 2, 1.
     */
    @Test
    public void addValueOneTwoThreeRotateLinkRecurThenListOneTwoThree() {
        ListNode listNode = new ListNode();
        listNode.addValueFirst(1);
        listNode.addValueFirst(2);
        listNode.addValueFirst(3);
        listNode.rotateLinkRecur();
        assertThat(listNode.getValue(1), is(3));
        assertThat(listNode.getValue(2), is(2));
        assertThat(listNode.getValue(3), is(1));
    }

    /**
     * Тест метода {@link ListNode#rotateThis()}.
     * Добавляем в список три элемента, значения которых равны 1, 2, 3.
     * Вызывем метод  {@link ListNode#rotateThis()}, ожидаем перевернутый список 3, 2, 1.
     */
    @Test
    public void addValueOneTwoThreeRotateThisThenListOneTwoThree() {
        ListNode listNode = new ListNode();
        listNode.addValueFirst(1);
        listNode.addValueFirst(2);
        listNode.addValueFirst(3);
        listNode.rotateThis();
        assertThat(listNode.getValue(1), is(3));
        assertThat(listNode.getValue(2), is(2));
        assertThat(listNode.getValue(3), is(1));
    }

    /**
     * Тест метода {@link ListNode#rotateLink()} ()}.
     * Добавляем в список три элемента, значения которых равны 1, 2, 3, 4, 5.
     * Вызывем метод  {@link ListNode#rotateLink()} ()}, ожидаем перевернутый список 5, 4, 3, 2, 1.
     */
    @Test
    public void addValueOneTwoThreeRotateLinkThenListOneTwoThree() {
        ListNode listNode = new ListNode();
        listNode.addValueFirst(1);
        listNode.addValueFirst(2);
        listNode.addValueFirst(3);
        listNode.addValueFirst(4);
        listNode.addValueFirst(5);
        listNode.rotateLink();
        assertThat(listNode.getValue(1), is(5));
        assertThat(listNode.getValue(2), is(4));
        assertThat(listNode.getValue(3), is(3));
        assertThat(listNode.getValue(4), is(2));
        assertThat(listNode.getValue(5), is(1));
    }
}