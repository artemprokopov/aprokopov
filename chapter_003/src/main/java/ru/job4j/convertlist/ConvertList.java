package ru.job4j.convertlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *Класс ConvertList, содержит методы для конвертации двумерного массива в ArrayList
 * и List в двухмерный массив.
 * @author Artem Prokopov
 * @since 05.09.2017
 * @version 1.0
 */
public class ConvertList {
    /**
     * Метод преобразует двумерный массив в ArrayList.
     * @param array преобразуемый двумерный массив.
     * @return ArrayList.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] i : array) {
            for (int j : i) {
                list.add(j);
            }
        }
        return list;
    }

    /**
     * Метод преобразует List в двумерный массив.
     * @param list преобразуемый List.
     * @param rows параметр количества строк.
     * @return двумерный массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int k = 0;
        int[][] intArray = new int[0][0];
        if (rows != 0) {
        k = list.size() / rows + (list.size() % rows != 0 ? 1 : 0);
        intArray = new int[rows][k];
        } else {
            rows = 0;
        }
        Iterator iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < k; j++) {
                if (iterator.hasNext()) {
                    intArray[i][j] = (int) iterator.next();
                } else {
                    intArray[i][j] = 0;
                }
            }
        }
        return intArray;
    }
}
