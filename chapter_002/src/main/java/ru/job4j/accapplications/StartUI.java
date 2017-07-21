package ru.job4j.accapplications;

import java.io.IOException;

/**
 * Main класс приложения.
 * @author Artem Prokopov
 * @since 10.05.2017
 * @version 1.0
 */
public class StartUI {
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     * Интерфейс ввода данных.
     */
    private final Input input;

    /**
     * Конструктор по умолчанию.
     */
    public StartUI() {
        this.input = new ValidateInput();
        this.tracker = new Tracker();
    }

    /**
     * Конструктор для замены пользовательского ввода, для тестов.
     * @param input интерфейс ввода данных
     * @param tracker хранилище заявок
     */
    protected StartUI(Tracker tracker, Input input) {
        this.input = input;
        this.tracker = tracker;
    }
    /**
     * Метод main.
     * @param args параметры командной строки.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    public static void main(String[] args) throws IOException {
         new StartUI().init();
    }

    /**
     * Метод запускает основной цикл программы.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    public void init() throws IOException {
        ActionType notExit = ActionType.NORMAL;
        while (notExit != ActionType.EXIT) {
            notExit = new MenuTracker(tracker, input).init();
        }
    }
}
