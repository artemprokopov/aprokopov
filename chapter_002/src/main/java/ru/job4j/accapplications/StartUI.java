package ru.job4j.accapplications;

/**
 * Created by Prokopov on 10.05.2017.
 */
public class StartUI {
    /**
     *
     * @param args параметры командной строки.
     */
    private Input input;


    StartUI(Input input) {
        this.input = input;
    }

    public static void main(String[] args) {
         new StartUI(new ConsoleInput(new MenuUI())).init();
    }

    public void init() {
        input.ask();
    }
}
