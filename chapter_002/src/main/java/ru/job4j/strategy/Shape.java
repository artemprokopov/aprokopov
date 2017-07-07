package ru.job4j.strategy;

/**
 * Интерфейс для реализации реализации отображения фигур псевдографикой.
 * @author Artem Prokopov
 * @since 07.07.2017
 * @version 1.0
 */
public interface Shape {
    /**
     * @return Возвращает строку содержащую изображение геометрической фигуры ввиде псевдографики.
     */
    String pic();
}
