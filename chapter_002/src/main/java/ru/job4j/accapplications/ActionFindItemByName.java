package ru.job4j.accapplications;

import java.text.SimpleDateFormat;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionFindItemByName implements Action {
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println("***************************************************************");
        String id = input.ask("Enter name to find Item: ");
        Item[] items = tracker.findByName(id);
        if (items == Tracker.NULL_ITEM_ARRAY) {
            System.out.println("Item not found!");
            System.out.println("***************************************************************");
            return ActionType.ERROR;
        }
        ActionShowItemArray(items);
        return ActionType.NORMAL;
    }
}
