package ru.job4j.accapplications;

/**
 * Класс фабрики объектов Action.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionFactory {
    /**
     * Массив объектов Action, фабрики.
     */
    private final Action[] arrayAction = {
            new ActionAddNewItem(),
            new ActionShowAllItem(),
            new ActionEditItem(),
            new ActionDeletItem(),
            new ActionFindItemById(),
            new ActionFindItemByName(),
            new ActionExitProgramm()
    };

    /**
     * Метод поиска объекта действия Action по индентификатору.
     * @param i индификатор действия.
     * @return объект типа Action.
     */
    public Action prodact(int i) {
        return arrayAction[i];
    }
}
