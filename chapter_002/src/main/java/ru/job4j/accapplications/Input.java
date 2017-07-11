package ru.job4j.accapplications;

/**
 * Интерфейс ввод информации.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public interface Input {
    /**
     *  Метод запроса на ввод информации.
     * @param question параметр запроса.
     * @return String возвращает введеную строку.
     */
    String ask(String question);
}
