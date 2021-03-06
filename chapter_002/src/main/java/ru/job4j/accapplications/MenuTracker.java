package ru.job4j.accapplications;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Класс создает меню приложения.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class MenuTracker {
    /**
     * Поле ссылка на хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Поле ссылка на систему вводв вывода заявок.
     */
    private final Input input;

    /**
     * Массив действий пользователя над хранилищем заявок и над заявками {@link Action}.
     */
    private final ArrayList<Action> actions = new ArrayList<>();

    /**
     * Инициализация массива действий пользователя.
     */
    {
        actions.add(new AddNewItemAction());
        actions.add(new ShowAllItemAction());
        actions.add(new EditItemAction());
        actions.add(new DeletItemAction());
        actions.add(new FindItemByIdAction());
        actions.add(new FindItemByNameAction());
        actions.add(new ExitProgrammeAction());
    }
    /**
     * Конструктор класса задает хранилище заявок и систему ввода вывода.
     * @param tracker объект хранилища заявок {@link Tracker}
     * @param input объект реализующий интерфейс {@link Input}
     */
    public MenuTracker(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }

    /**
     * Инициализирует выполнения функционала объекта.
     * @return результат операции типа {@link ActionType}. В случае успеха {@link ActionType#NORMAL}
     * в случае ошибки {@link ActionType#ERROR}, при инициализации выхода
     * из программы {@link ActionType#EXIT}.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    public ActionType init() throws IOException {
        ActionType result = ActionType.NORMAL;
        int userAction = 6;
        for (Action action: actions) {
            System.out.println(action.show());
        }
        do {
            try {
                userAction = input.ask("Select: ", 0, 6);
                result = ActionType.NORMAL;
            } catch (MenuOutException moe) {
                System.out.println(moe.getMessage());
                result = ActionType.ERROR;
            }
        } while (result == ActionType.ERROR);
        result = actions.get(userAction).execute(tracker, input);
        return result;
    }

    /**
     *Внутренний класс реализует добавление новой заявки {@link Item} в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    private class AddNewItemAction extends BaseAction {

        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        AddNewItemAction() {
            super(0, "Add new Item");
        }

        /**
         * Метод запускает выполнения задачи, на добавление новой заявки в хранилище.
         * @param tracker хранилище где ведется поиск заявок.
         * @param input   интерфейс получения вводимых данных.
         * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
         */
        @Override
        public ActionType execute(Tracker tracker, Input input) throws IOException {
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

    /**
     *Внутренний класс реализует показ всех заявок {@link Item} в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    public class ShowAllItemAction extends BaseAction {
        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        public ShowAllItemAction() {
            super(1, "Show all items");
        }
        /**
         * Метод запускает выполнения задачи по выводу всех имеющихся заявок в хранилище tacker.
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
            for (Item item: items) {
                ActionShowItem.actionShowItem(item);
            }
            return ActionType.NORMAL;
        }
    }

    /**
     *Внутренний класс реализует редактирование заявки {@link Item} в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    public class EditItemAction extends BaseAction {
        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        public EditItemAction() {
            super(2, "Edit item");
        }
        /**
         * Метод запускает выполнения задачи, на редактирование заявки в хранилище.
         * @param tracker хранилище где ведется поиск заявок.
         * @param input   интерфейс получения вводимых данных.
         * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
         */
        @Override
        public ActionType execute(Tracker tracker, Input input) throws IOException {
            System.out.println("***************************************************************");
            String id = input.ask("Enter application id to edit: ");
            Item item = tracker.findById(id);
            if (item == Item.EMPTY_ITEM) {
                System.out.println("Item not found!");
                System.out.println("***************************************************************");
                return ActionType.ERROR;
            }
            ActionShowItem.actionShowItem(item);
            item.setName(input.ask("Enter new name: "));
            item.setDesc(input.ask("Enter new desc: "));
            item.addComments(input.ask("Enter new comments: "));
            System.out.println("***************************************************************");
            return ActionType.NORMAL;
        }
    }

    /**
     *Внутренний класс реализует удаление заявки {@link Item} в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    private class DeletItemAction extends BaseAction {
        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        DeletItemAction() {
            super(3, "Delete item");
        }
        /**
         * Метод запускает выполнения задачи, по удалению заявки по, запрашивает Id заявки.
         * @param tracker хранилище где ведется поиск заявок.
         * @param input   интерфейс получения вводимых данных.
         * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
         */
        @Override
        public ActionType execute(Tracker tracker, Input input) throws IOException {
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

    /**
     *Внутренний класс реализует нахождение заявки {@link Item} по Id в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    public class FindItemByIdAction extends BaseAction {
        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        FindItemByIdAction() {
            super(4, "Find item by Id");
        }
        /**
         * Метод запускает выполнения задачи, по нахождение заявки по Id, запрашивает Id заявки.
         * @param tracker хранилище где ведется поиск заявок.
         * @param input   интерфейс получения вводимых данных.
         * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
         */
        @Override
        public ActionType execute(Tracker tracker, Input input) throws IOException {
            System.out.println("***************************************************************");
            String id = input.ask("Enter application id to find: ");
            Item item = tracker.findById(id);
            if (item == Item.EMPTY_ITEM) {
                System.out.println("Item not found!");
                System.out.println("***************************************************************");
                return ActionType.ERROR;
            }
            ActionShowItem.actionShowItem(item);
            System.out.println("***************************************************************");
            return ActionType.NORMAL;
        }
    }


    /**
     *Внутренний класс реализует нахождение заявки {@link Item} по name в хранилище заявок {@link Tracker}.
     * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}
     */
    private class FindItemByNameAction extends BaseAction {
        /**
         * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
         */
        FindItemByNameAction() {
            super(5, "Find items by name");
        }

        /**
         * Метод запускает выполнения задачи, по поиску заявки по имени.
         * @param tracker хранилище где ведется поиск заявок.
         * @param input интерфейс получения вводимых данных.
         * @return ActionType.NORMAL в случае успеха, иначе ActionType.ERROR.
         */
        @Override
        public ActionType execute(Tracker tracker, Input input) throws IOException {
            System.out.println("***************************************************************");
            String id = input.ask("Enter name to find Item: ");
            Item[] items = tracker.findByName(id);
            if (items == Tracker.NULL_ITEM_ARRAY) {
                System.out.println("Item not found!");
                System.out.println("***************************************************************");
                return ActionType.ERROR;
            }
            for (Item item: items) {
                ActionShowItem.actionShowItem(item);
            }
            System.out.println("***************************************************************");
            return ActionType.NORMAL;
        }
    }

    /**
     *Внутренний класс реализует вывод в консоль заявки {@link Item} .
     */
    private static class ActionShowItem {
        /**
         * Метод вывода заявки в консоль.
         * @param item заявка типа{@link Item} которая выводится в консоль.
         */
        public static void actionShowItem(Item item) {
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

}

/**
 *Внутренний класс реализует событие выход из программы.
 * Наследует абстрактный класс {@link BaseAction}, и до конца имплементирует интерфейс {@link Action}.
 */
class ExitProgrammeAction extends BaseAction {
    /**
     * Конструктор вызывает конструктор суперкласса {@link BaseAction#BaseAction(int, String)}.
     */
     ExitProgrammeAction() {
        super(6,  "Exit Program");
    }

    /**
     * Метод запускает выполнения задачи, на выход из программы.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.EXIT, сигнал выхода из программы.
     */
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        return ActionType.EXIT;
    }
}