package ru.job4j.accapplications;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionAddNewItem implements Action {

    @Override
    public ActionType execute(Tracker tracker, Input input) {
        Item item = new Item();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
        System.out.println("***************************************************************");
        System.out.println("Id: " + item.getId());
        System.out.println("Data: " + simpleDateFormat.format(new Date(item.getCreated())));
        item.setName(input.ask("Enter you name: "));
        item.setDesc(input.ask("Enter desc: "));
        item.addComments(input.ask("Enter comments: "));
        if (tracker.add(item) == false) {
            System.out.println("Error can't add Item!");
            return ActionType.ERROR;
        }
        System.out.println("Add Item success!");
        System.out.println("***************************************************************");
        return ActionType.NORMAL;
    }
}
