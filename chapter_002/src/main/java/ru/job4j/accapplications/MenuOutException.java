package ru.job4j.accapplications;

/**
 * Класс описывающий исключительную ситуацию ввод неверных данных при выборе пунктов меню.
 * @author Artem Prokopov
 * @since 27.07.2017
 * @version 1.0
 * @see java.lang.RuntimeException
 */

public class MenuOutException extends RuntimeException {
    /**
     * Конструктор класса.
     * @param message страка сообщения об исключительной ситуации.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
