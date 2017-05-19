package ru.job4j.accapplications;

/**
 * Created by Prokopov on 10.05.2017.
 */
public class StartUI {
    /**
     *
     * @param args параметры командной строки.
     */
    public static void main(String[] args) {
        StartUI startUI = new StartUI();
        startUI.init();
    }

    public void init() {
        MenuUI menu = new MenuUI();
        ConsoleInput consoleInput = new ConsoleInput();
        menu.printMenu();
        System.out.println(consoleInput.ask(menu));
    }
}
