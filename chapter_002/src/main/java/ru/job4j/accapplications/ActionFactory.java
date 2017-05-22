package ru.job4j.accapplications;

/**
 * Created by Prokopov on 22.05.2017.
 */
public class ActionFactory {
    private final Action[] ArrayAction = {
            new ActionAddNewItem(),
            new ActionShowAllItem(),
            new ActionEditItem(),
            new ActionDeletItem(),
            new ActionFindItemById(),
            new ActionFindItemByName(),
            new ActionExitProgramm()
    };

    public Action prodact (int i) {
        return ArrayAction[i];
    }
}
