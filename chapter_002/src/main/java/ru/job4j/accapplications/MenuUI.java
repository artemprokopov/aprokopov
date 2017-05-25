package ru.job4j.accapplications;

/**
 * Класс создает меню приложения.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class MenuUI {
    /**
     * Массив строк пунктов меню.
     */
    private final String[] itemMenu = {
            "0. Add new Item",
            "1. Show all items",
            "2. Edit item",
            "3. Delete item",
            "4. Find item by Id",
            "5. Find items by name",
            "6. Exit Program"
    };

    /**
     * Геттер возвращает масив пунктов меню.
     * @return массив строк меню.
     */
    public String[] getMenu() {
        return itemMenu;
    }

    /**
     * Метод возвращаем номер пункта меню по переданной строке.
     * @param str строка искомого пункта меню.
     * @return номер пункта меню, иначе -1.
     */
    public int getItemMenu(String str) {
        for (int i = 0; i < itemMenu.length; ++i) {
            if (itemMenu[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возвращает строку наименование пункта меню по номеру.
     * @param i номер пункта меню.
     * @return строку пункта меню, иначе , иначе бросает исключение IllegalArgumentException.
     */
    public  String getItemMenu(int i) {
        if (i < 0 && i > itemMenu.length - 1) {
            throw  new IllegalArgumentException("Передан номер пункта меню: " + i + " - не существует данного пункта меню!!!");
        }
        return itemMenu[i];
    }

    /**
     * Метод возвращает количество пунктов меню.
     * @return количество пунктов меню.
     */
    public int numberOfMenuItem() {
        return itemMenu.length;
    }
}
