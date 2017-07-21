package ru.job4j.accapplications;

import java.io.IOException;
/**
 * Класс ввода запроса и ввод информации с консоли, с проверкой вводимой информации.
 * @author Artem Prokopov
 * @since 21.07.2017
 * @version 1.0
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Метод запроса и ожидания на ввод информации из консоли.
     * Получает информационную строку какую информацию требуется ввести.
     * @param str информационная строка, о требуемой к вводу информации.
     * @return введеную строку.
     */
    @Override
    public String ask(String str) {
        String result = "";
        try {
           result = super.ask(str);
        } catch (IOException ioe) {
            System.out.println("Input error!!! Enter the correct data.!!!");
        }
        return result;
    }
    /**
     * Метод запроса и ожидания на ввод информации из консоли.
     * @param str строка запроса
     * @param rangeMin нижняя граница диапазона возвращаемого целочисленного параметра
     * @param rangeMax верхняя граница диапазона возвращаемого целочисленного параметра
     * @return целочисленный параметр ответа на запрос от rangeMin... rangeMax,
     * в противном случае -1.
     * @throws IOException
     */
    @Override
    public int ask(String str, int rangeMin, int rangeMax) throws IOException {
        int result = -1;
        try {
            result = super.ask(str, rangeMin, rangeMax);
            if (result < rangeMin || result > rangeMax) {
                throw new MenuOutException("Input error!!! Enter validate number of  item menu!!!");
            }
        } catch (IOException ioe) {
            System.out.println("Input error!!!");
        }
        return result;
    }
}
