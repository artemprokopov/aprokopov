package ru.job4j.user;

import java.time.LocalTime;
import java.util.Random;

/**
 * Класс описания юзера.
 * @author Arterm Prokopov
 * @since 06.09.2017
 * @version 1.0
 */
public class User {
    /**
     * Поле уникального идентификатора пользователя.
     */
    private final Integer id;
    /**
     * Имя пользователя.
     */
    private final String name;
    /**
     * Место нахождение пользователя.
     */
    private final String city;

    /**
     * Конструктор.
     * @param initName имя пользователя.
     * @param initCity Место нахождение пользователя.
     */
    public User(final String initName, final String initCity) {
        id = LocalTime.now().getNano() / new Random().nextInt(1000);
        name = initName;
        city = initCity;
    }

    /**
     * Получаем уникальный индификатор пользователя.
     * @return индентификатор пользователя.
     */
    public  Integer getId() {
        return id;
    }
}
