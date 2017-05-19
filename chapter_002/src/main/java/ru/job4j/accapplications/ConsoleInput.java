package ru.job4j.accapplications;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Prokopov on 10.05.2017.
 */
public class ConsoleInput implements Input {
    /**
     *
     * @param o
     * @return
     */
    private MenuUI testArgumentCastMenuUI(Object o) {
        if (o instanceof MenuUI) {
            return (MenuUI) o;
        } else {
            throw new IllegalArgumentException(o + " :Error argument");
        }
    }

    private int printAndWaitSelect(MenuUI menuUI) {
        Scanner scanner = new Scanner(System.in);
        int result = -1;
        while (result == -1) {
            try {
                System.out.print("Select: ");
                result = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Enter the number of the selected menu!");
                scanner.next();
            }
            if (result <= 0 | result >= menuUI.numberOfMenuItem()) {
                System.out.println("Not the right menu item!");
                result = -1;
            }
        }
        return result;
    }

    public String ask(Object o) {
        MenuUI menuUI = testArgumentCastMenuUI(o);
        return menuUI.getItemMenu(printAndWaitSelect(menuUI));
    }
}
