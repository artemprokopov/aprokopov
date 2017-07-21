package ru.job4j.accapplications;


import java.io.IOException;

/**
 * Интерфейс выполнения действий над заявками.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public interface Action {
    /**
     * Метод запуска заданий действий над заявкми.
     * @param tracker хранилище заявок
     * @param input интерфейс ввода информации с консоли.
     * @return ActionType сигнал результата выполнения заявки.
     */
    ActionType execute(Tracker tracker, Input input) throws IOException;

    /**
     *  Метод отображения объекта.
     * @return возвращает строку отображения объекта.
     */
    String show();

    /**
     * Метод фозвращающий уникальный ключ события.
     * @return целочисленный уникальный ключ события.
     */
    int key();
}
