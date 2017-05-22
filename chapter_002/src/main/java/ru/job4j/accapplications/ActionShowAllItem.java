package ru.job4j.accapplications;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionShowAllItem implements Action {
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        Item[] items = tracker.findAll();
        if (items == Tracker.NULL_ITEM_ARRAY) {
            System.out.println("No Items in database!");
            return ActionType.ERROR;
        }
        ActionShowItemArray(tracker.findAll());
        return ActionType.NORMAL;
    }
}
