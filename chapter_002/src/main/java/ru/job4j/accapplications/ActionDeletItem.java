package ru.job4j.accapplications;

/**
 * Класс выполнения запроса на удаление заявки.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionDeletItem implements Action {
    /**
     * Метод запускает выполнения задачи, по удалению заявки поб запрашивая id заявки.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
     */
    @Override
    public ActionType execute(Tracker tracker, Input input) {
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
