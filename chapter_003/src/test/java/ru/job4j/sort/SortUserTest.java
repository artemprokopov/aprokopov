package ru.job4j.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertArrayEquals;

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
        List<User> list = Arrays.asList(new User("Сергей", 27),
                new User("Гена", 30),
                new User("Жора", 20),
                new User("Иван", 25));
        User[] expected = new User[]{new User("Жора", 20),
                new User("Иван", 25),
                new User("Сергей", 27),
                new User("Гена", 30)};
        Set<User> userSet = new SortUser().sort(list);
        assertArrayEquals(userSet.toArray(), expected);
    }

    /**
     * Тестируем {@link SortUser#sortNameLength(List)}.
     */
    @Test
    public void sortNameLengthAddListThenSortList() {
        List<User> list = Arrays.asList(new User("Сергей1", 25),
                new User("Иван1", 30),
                new User("Сергей", 20),
                new User("Иван", 25));
        User[] expected = new User[]{new User("Иван", 25),
                new User("Иван1", 30),
                new User("Сергей", 20),
                new User("Сергей1", 25)};
        List<User> userList = new SortUser().sortNameLength(list);
        assertArrayEquals(userList.toArray(), expected);
    }

    /**
     * Тестируем {@link SortUser#sortByAllFields(List)}.
     */
    @Test
    public void sortByAllFieldsAddListThenSortList() {
        List<User> list = Arrays.asList(new User("Сергей", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Иван", 25));
        User[] expected = new User[]{new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)};
        List<User> userList = new SortUser().sortByAllFields(list);
        assertArrayEquals(userList.toArray(), expected);
    }
}