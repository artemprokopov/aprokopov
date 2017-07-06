package ru.job4j.accapplications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Класс ввода запроса и ввод информации с консоли.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ConsoleInput implements Input {
    /**
     * Поле содержащие меню приложения с которым оперирует класс при организации ввода.
     */
    private final MenuUI menuUI;

    /**
     * Конструктор с параметром принемающие объект меню с которым оперирует класс.
     * @param menuUI объект меню.
     */
    ConsoleInput(MenuUI menuUI) {
        this.menuUI = menuUI;
    }

    /**
     * Служебный метод запрашивающий ввод числа для выбора пункта меню приложения.
     * @return номер выбранного пункта меню.
     */
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

    /**
     * Метод запроса и ожидания на ввод информации из консоли.
     * @return возвращает номер выбранного пункта меню.
     */
    @Override
    public int ask() {
        for (String s: menuUI.getMenu()) {
            System.out.println(s);
        }
        return printAndWaitSelect();
    }

    /**
     * Метод запроса и ожидания на ввод информации из консоли.
     * Получает информационную строку какую информацию требуется ввести.
     * @param str информационная строка, о требуемой к вводу информации.
     * @return введеную строку.
     */
    @Override
    public String ask(String str) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        while (result.equals("")) {
            try {
                System.out.print(str);
                result = reader.readLine();
            } catch (IOException e) {
                System.out.println("Error input");
            }
        }
        return result;
    }
}
