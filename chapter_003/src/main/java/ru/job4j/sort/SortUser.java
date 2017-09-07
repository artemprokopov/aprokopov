package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Класс преобразования не отсортированного List<User> в TreeSet отсортированную по полю
 * класса User{@link User#age} по возрастанию.
 * @author Artem Prokopov
 * @since 07.09.2017
 * @version 1.0
 */

public class SortUser {
    /**
     * Метод преобразования не отсортированного List<User> в TreeSet отсортированную по полю
     * класса User{@link User#age} по возрастанию.
     * @param list преобразуемый List.
     * @return TreeSet с отсортированными элементами по полю класса User {@link User#age}
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
