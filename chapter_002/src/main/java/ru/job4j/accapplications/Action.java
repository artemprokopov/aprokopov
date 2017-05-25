package ru.job4j.accapplications;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Интерфейс выполнения действий над заявками.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public interface Action {
    /**
     * Метод запуска заданий действий над заявкми.
     * @param tracker хранилище заявок
     * @param input интерфейс ввода информации с консоли.
     * @return ActionType сигнал результата выполнения заявки.
     */
    ActionType execute(Tracker tracker, Input input);

    /**
     * Метод по умолчани, действие вывода массива заявок на экран.
     * @param items масив заявок.
     */
    default void actionShowItemArray(Item[] items) {
        for (Item item: items) {
            actionShowItem(item);
        }
    }

    /**
     * Метод по умолчанию вывод заявки на экран.
     * @param item заявка.
     */
    default void actionShowItem(Item item) {
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
