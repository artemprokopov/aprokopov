package ru.job4j.accapplications;

/**
 * Created by Prokopov on 10.05.2017.
 */
public class StartUI {


    /**
     *
     * @param args параметры командной строки.
     */
    private Tracker tracker = new Tracker();

    public static void main(String[] args) {
         new StartUI().init();
    }

    public void init() {
        Input input = new ConsoleInput(new MenuUI());
        ActionFactory actionFactory = new ActionFactory();
        ActionType notExit = ActionType.NORMAL;
        while(notExit != ActionType.EXIT)
        {
            notExit = actionFactory.prodact(input.ask()).execute(tracker, input);
        }
    }
}
