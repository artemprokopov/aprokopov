package ru.job4j.accapplications;

import java.text.SimpleDateFormat;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionDeletItem implements Action {
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println("***************************************************************");
        String id = input.ask("Enter application id to delete: ");
        Item item = tracker.findById(id);
        if (item == Item.EMPTY_ITEM) {
            System.out.println("Item not found!");
            System.out.println("***************************************************************");
            return ActionType.ERROR;
        }
        tracker.delete(item);
        System.out.println("Item removed!");
        System.out.println("***************************************************************");
        return ActionType.NORMAL;
    }
}
