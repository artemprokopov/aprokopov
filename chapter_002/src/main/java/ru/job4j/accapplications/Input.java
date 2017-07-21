package ru.job4j.accapplications;

import java.io.IOException;

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
     * @throws IOException если происходит ошибка ввода вывода.
     */
    String ask(String question) throws IOException;
    /**
     *  Метод запроса на ввод информации.
     * @param question параметр запроса.
     * @param rangeMin нижняя граница диапазона возвращаемого целочисленного параметра
     * @param rangeMax верхняя граница диапазона возвращаемого целочисленного параметра
     * @return int возвращает целочисленный индификатор ответ на запрос.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    int ask(String question, int rangeMin, int rangeMax) throws IOException;
}
