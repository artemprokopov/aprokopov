package ru.job4j.accapplications;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Prokopov on 19.05.2017.
 */
public interface Action {
    ActionType execute(Tracker tracker, Input input);
    default void ActionShowItemArray(Item[] items) {
        for (Item item: items) {
            ActionShowItem(item);
        }
    }
    default void ActionShowItem(Item item) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
            System.out.println("***************************************************************");
            System.out.println("Id: " + item.getId());
            System.out.println("Data: " + simpleDateFormat.format(new Date(item.getCreated())));
            System.out.println("Name: " + item.getName());
            System.out.println("Desc: " + item.getDesc());
            System.out.println("Comments: ");
            for (String str : item.getComments()) {
                System.out.println(str);
            }
            System.out.println("***************************************************************");
    }
}
