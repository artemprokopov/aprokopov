package ru.job4j.accapplications;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

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
    public String ask(String str) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = "";
        while (result.equals("")) {
                System.out.print(str);
                result = reader.readLine();
        }
        return result;
    }

    /**
     * Метод запроса и ожидания на ввод информации из консоли.
     * @param str строка запроса
     * @param rangeMin нижняя граница диапазона возвращаемого целочисленного параметра
     * @param rangeMax верхняя граница диапазона возвращаемого целочисленного параметра
     * @return целочисленный параметр ответа на запрос, в диапазоне от 0 .. 9.
     * @throws IOException
     */
    @Override
    public int ask(String str, int rangeMin, int rangeMax) throws IOException {
        int result = -1;
        String askString;
        Pattern p = Pattern.compile("^\\d$");
        while (result == -1) {
            askString = ask(str);
            if (p.matcher(askString).matches()) {
                result = Integer.parseInt(askString);

            } else {
                System.out.println("Input error!!! Enter validate number of  item menu!!!");
            }
        }
        return result;
    }
}
