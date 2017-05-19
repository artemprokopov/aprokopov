package ru.job4j.accapplications;

/**
 * Created by Prokopov on 19.05.2017.
 */
public class MenuUI {
    private String[] itemMenu = {
                                    "0. Add new Item",
                                    "1. Show all items",
                                    "2. Edit item",
                                    "3. Delete item",
                                    "4. Find item by Id",
                                    "5. Find items by name",
                                    "6. Exit Program"
                                };
    public void printMenu() {
        for (String s: itemMenu) {
            System.out.println(s);
        }
    }

    public  String getItemMenu (int i) {
        return itemMenu[i];
    }

    public int numberOfMenuItem () {
        return itemMenu.length;
    }
}
