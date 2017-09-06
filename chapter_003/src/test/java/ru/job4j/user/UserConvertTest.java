package ru.job4j.user;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Тесты для класса UserConvert.
 */
public class UserConvertTest {
    /**
     *Тест метода process.
     * Создаем 3-х эзеров. Добавляем в List и в ожидаемую HashMap.
     * Проверяем работу метода.
     */
    @Test
    public void processAddListThenMap() {
        //Готовим данные.
        UserConvert userConvert = new UserConvert();
        User user = new User("Anton", "Volgograd");
        User user1 = new User("Sergey", "Smolensk");
        User user2 = new User("Valya", "Saratov");
        List<User> testList = new LinkedList<>();
        testList.add(user);
        testList.add(user1);
        testList.add(user2);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(user.getId(), user);
        expected.put(user1.getId(), user1);
        expected.put(user2.getId(), user2);
        //Тестируем.
        HashMap<Integer, User> result = userConvert.process(testList);

        assertEquals(expected, result);
    }
}