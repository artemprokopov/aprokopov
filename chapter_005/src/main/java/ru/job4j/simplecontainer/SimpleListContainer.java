package ru.job4j.simplecontainer;

import java.util.Iterator;
import java.util.function.Consumer;

public class SimpleListContainer<E> implements SimpleContainer<E> {
    @Override
    public boolean add(E addItem) {
        return false;
    }

    @Override
    public void add(int indexAddItem, E addItem) {

    }

    @Override
    public boolean update(int indexUpdateItem, E itemUpdate) {
        return false;
    }

    @Override
    public E delete(int indexDeleteItem) {
        return null;
    }

    @Override
    public E delete(E deleteItem) {
        return null;
    }

    @Override
    public E get(int indexItem) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int findItem(E searchItem) {
        return 0;
    }

    @Override
    public <E1> E1[] toArray(E1[] resultArray) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }
}
