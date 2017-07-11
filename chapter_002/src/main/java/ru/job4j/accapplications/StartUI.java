package ru.job4j.accapplications;
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
        this.input = new ConsoleInput();
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
     */
    public static void main(String[] args) {
         new StartUI().init();
    }

    /**
     * Метод запускает основной цикл программы.
     */
    public void init() {
        ActionType notExit = ActionType.NORMAL;
        while (notExit != ActionType.EXIT) {
            notExit = new MenuTracker(tracker, input).init();
        }
    }
}
