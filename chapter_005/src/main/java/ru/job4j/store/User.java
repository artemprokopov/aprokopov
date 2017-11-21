package ru.job4j.store;

/**
 * Класс модели User.
 * @author Artem Prokopov
 * @since 21/11/2017
 * @version 1.0
 */
public class User extends Base {
    /**
     * Конструктор.
     * @param initId параметр инициализирующий поле {@link Base#id}.
     */
    public User(String initId) {
        super(initId);
    }
}
