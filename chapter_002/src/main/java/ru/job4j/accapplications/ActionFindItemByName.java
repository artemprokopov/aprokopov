package ru.job4j.accapplications;

import java.text.SimpleDateFormat;

/**
 * Класс выполнения запроса на поиск заявок по имени.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionFindItemByName implements Action {
    /**
     * Метод запускает выполнения задачи, по поиску заявки по имени.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
     */
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
        actionShowItemArray(items);
        return ActionType.NORMAL;
    }
}
