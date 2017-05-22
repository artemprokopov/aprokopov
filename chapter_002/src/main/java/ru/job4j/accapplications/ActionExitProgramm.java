package ru.job4j.accapplications;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionExitProgramm implements Action {
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        return ActionType.EXIT;
    }
}
