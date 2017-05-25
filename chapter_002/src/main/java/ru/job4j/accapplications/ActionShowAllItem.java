package ru.job4j.accapplications;

/**
 * Класс выполнения запроса на показ всех имеющихся заявок.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionShowAllItem implements Action {
    /**
     * Метод запускает выполнения задачиб по выводу всех имеющихся заявок в хранилище tacker.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
     */
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        Item[] items = tracker.findAll();
        if (items == Tracker.NULL_ITEM_ARRAY) {
            System.out.println("No Items in database!");
            return ActionType.ERROR;
        }
        actionShowItemArray(tracker.findAll());
        return ActionType.NORMAL;
    }
}
