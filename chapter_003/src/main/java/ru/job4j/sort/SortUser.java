package ru.job4j.sort;

import java.util.Comparator;
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

    /**
     * Сортируем List<User> по длине имени {@link User#name}.
     * @param list преобразуемый List.
     * @return List отсортированными элементами по длине строки полю класса User {@link User#name}
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() != o2.getName().length()
                        ? o1.getName().length() > o2.getName().length() ? 1 : -1 : 0;
            }
        });
        return list;
    }

    /**
     *  Сортируем List<User> по  имени {@link User#name} и возрасту {@link User#age}.
     * @param list  преобразуемый List.
     * @return List отсортированными элементами по полю класса User {@link User#name}  в алфавитном порядке
     * и {@link User#age} по возрастанию.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = 0;
                result = o1.getName().compareTo(o2.getName());
                if (result == 0) {
                    result = o1.getAge() != o2.getAge() ? o1.getAge() > o2.getAge() ? 1 : -1 : 0;
                }
                return result;
            }
        });
        return list;
    }

}
