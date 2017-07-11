package ru.job4j.accapplications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс ввода запроса и ввод информации с консоли.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ConsoleInput implements Input {

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
