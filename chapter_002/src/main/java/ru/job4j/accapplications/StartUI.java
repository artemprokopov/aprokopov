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
    private Tracker tracker = new Tracker();

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
        Input input = new ConsoleInput(new MenuUI());
        ActionFactory actionFactory = new ActionFactory();
        ActionType notExit = ActionType.NORMAL;
        while (notExit != ActionType.EXIT) {
            notExit = actionFactory.prodact(input.ask()).execute(tracker, input);
        }
    }
}
