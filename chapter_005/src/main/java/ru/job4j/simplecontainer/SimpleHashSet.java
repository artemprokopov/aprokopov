package ru.job4j.simplecontainer;

import java.util.Iterator;

/**
 * Класс контейнера Set основанного на {@link SimpleListContainer}, реализует интерфейс {@link SimpleSet}.
 * @param <E> тип контейнера.
 * @author Artem Prokopov
 * @since 04/03/2018
 * @version 1.0
 */
public class SimpleHashSet<E> implements SimpleSet<E> {
    /**
     * Хранилище Set на основе {@link SimpleListContainer}.
     */
    final SimpleHashMap<E, Object> simpleHashContainer;
    /**
     * Буферный объект для значения Map.
     */
    private static final Integer TEMP_OBJECT = 0;

    /**
     * Конструктор по умолчанию. Инициализируем {@link SimpleHashSet#simpleHashContainer}
     */
    public SimpleHashSet() {
        this.simpleHashContainer = new SimpleHashMap<>();
    }



    /**
     * Конструктор принимет в качестве параметра массив типа E, копия которого используется как элементы контейнера.
     * @param initArray массив иницыализирующий контейнер.
     */
    public SimpleHashSet(E[] initArray) {
        this();
        for (E e : initArray) {
            add(e);
        }
    }

    /**
     * Добавляет элемент в контейнер, если добавляемый элемент addItem существует в контейнере возвращает false,
     * если операция закончилась неудачей, возвращает false, в случае успеха возвращате true.
     *
     * @param addItem добавляемый в контейнер элемент тип E.
     * @return если добавляемый элемент addItem существует в контейнере возвращает false,
     * если операция закончилась неудачей, возвращает false, в случае успеха возвращате true.
     */
    @Override
    public boolean add(E addItem) {
        return  simpleHashContainer.put(addItem, TEMP_OBJECT) == TEMP_OBJECT;
    }

    /**
     * Метод поиска элемента в контейнере.
     *
     * @param e искомый элемент.
     * @return true если элемнтв существует в контейнере, в противном случа false.
     */
    @Override
    public boolean contains(E e) {
        return simpleHashContainer.containsKey(e);
    }

    /**
     * Метод удаления элемента из контейнера.
     *
     * @param e удаляемый элемент.
     * @return true если операция завершена, в противном случа false.
     */
    @Override
    public boolean remove(E e) {
        return simpleHashContainer.remove(e) == TEMP_OBJECT;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}