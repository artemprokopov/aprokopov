package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Класс тестов для класса {@link SortUser}.
 * @author Artem Prokopov
 * @since 07.09.2017
 * @version 1.0
 */
public class SortUserTest {
    /**
     * Тестируем {@link SortUser#sort(List)}.
     */
    @Test
    public void sortAddListThenTreeSet() {
        List<User> list = Arrays.asList(new User("aaa", 3),
                new User("bbb", 4),
                new User("ccc", 1),
                new User("ddd", 5));
        User[] expected = new User[]{new User("ccc", 1),
                new User("aaa", 3),
                new User("bbb", 4),
                new User("ddd", 5)};
        Set<User> userSet = new SortUser().sort(list);
        assertArrayEquals(userSet.toArray(), expected);
    }
}