package ru.job4j.chess;
/**
 * Класс перечисление задает направление жвижения.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */

public enum Gradient {
    /**
     * Значения перечисления.
     */
    POSITIVE(1), ZERO(0), NEGATIVE(-1);

    /**
     *Ассоциативный номер перечисления.
     */
    private final int countGradient;

    /**
     * Конструктор.
     * @param i инициализация ассоциативного параметра.
     */
    Gradient(int i) {
        this.countGradient = i;
    }

    /**
     * Определение типа направления по переданному значению,
     * если значение отрицательное или положительное.
     * @param j оцениваемый параметр.
     * @return Направлени движения если j отрицательное то возвращается NEGATIVE,
     * если положительное, то POSITIVE, если равно 0 то ZERO.
     */
    public static Gradient getTypeGradient(int j) {
        if (j != 0) {
            return j > 0 ? POSITIVE : NEGATIVE;
        }
        return ZERO;
    }

    /**
     * Возвращает ассоциативный номер.
     * @return ассоциативный номер.
     */
    public int getCountGradient() {
        return countGradient;
    }
}
