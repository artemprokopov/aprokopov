package ru.job4j.accapplications;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Prokopov on 10.05.2017.
 */
public class ConsoleInput implements Input {

    private MenuUI menuUI;


    ConsoleInput(MenuUI menuUI) {
        this.menuUI = menuUI;
    }

    private int printAndWaitSelect() {
        Scanner scanner = new Scanner(System.in);
        int result = -1;
        while (result == -1) {
            try {
                System.out.print("Select: ");
                result = scanner.nextInt();
                if (result < 0 | result >= menuUI.numberOfMenuItem()) {
                    System.out.println("Not the right menu item!");
                    result = -1;
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Enter the number of the selected menu!");
                scanner.next();
            }
        }
        return result;
    }
    @Override
    public int ask() {
        for (String s: menuUI.getMenu()) {
            System.out.println(s);
        }
        return printAndWaitSelect();
    }

    @Override
    public String ask(String str) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        while (result.equals("")) {
            try {
                System.out.print(str);
                result = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Error input");
                scanner.next();
            }
        }
        return result;
    }

}
