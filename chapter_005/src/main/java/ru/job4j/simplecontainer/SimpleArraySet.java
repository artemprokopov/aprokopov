package ru.job4j.simplecontainer;

import java.util.Iterator;
/**
 * Класс контейнера Set основанного на {@link SimpleArrayContainer}, реализует интерфейс {@link SimpleSet}.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */
public class SimpleArraySet<E> implements SimpleSet<E> {
    /**
     * Хранилище Set на основе {@link SimpleArrayContainer}.
     */
    final SimpleArrayContainer<E> simpleArrayContainer;

    /**
     * Конструктор по умолчанию. Инициализируем {@link SimpleArraySet#simpleArrayContainer}
     */
    public SimpleArraySet() {
        this.simpleArrayContainer = new SimpleArrayContainer<>();
    }
    /**
     * Конструктор принимет в качестве параметра массив типа T, копия которого используется как элементы
     * контейнера.
     * @param initArray массив иницыализирующий контейнер.
     */
    public SimpleArraySet(E[] initArray) {
        this();
        for (E e : initArray) {
            add(e);
        }
    }

    /**
     * Добавляет элемент в контейнер, если добавляемый элемент addItem существует в контейнере возвращает false,
     * если операция закончилась неудачей, возвращает false, в случае успеха возвращате true.
     * @param addItem добавляемый в контейнер элемент тип E.
     * @return если добавляемый элемент addItem существует в контейнере возвращает false,
     * если операция закончилась неудачей, возвращает false, в случае успеха возвращате true.
     */
    @Override
    public boolean add(E addItem) {
        boolean result = false;
        if (this.simpleArrayContainer.findItem(addItem) == -1) {
            result = simpleArrayContainer.add(addItem);
        }
        return result;
    }
    /**
     * Реализуем метод интерфейса {@link Iterable#iterator()}.
     * @return итератор типа <E>.
     */
    @Override
    public Iterator<E> iterator() {
        return simpleArrayContainer.iterator();
    }
}
