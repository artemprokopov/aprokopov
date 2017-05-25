package ru.job4j.accapplications;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Класс выполнения запроса на добавление заявки.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionAddNewItem implements Action {
    /**
     * Метод запускает выполнения задачи, на добавление новой заявки в хранилище.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
     */
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
        if (!tracker.add(item)) {
            System.out.println("Error can't add Item!");
            return ActionType.ERROR;
        }
        System.out.println("Add Item success!");
        System.out.println("***************************************************************");
        return ActionType.NORMAL;
    }
}
