package ru.job4j.strategy;

/**
 * Класс Paint, реализует отображение псевдографикой геометрической фигур в консоле.
 * Реализует интерфейс {@link Shape}
 * @author Artem Prokopov
 * @since 07.07.2017
 * @version 1.0
 */
public class Paint {
    /**
     * Метод выводит в консоль изображение фигур реализованых с помощью псевдографики.
     * @param shape принимает объекты реализующие интерфейс {@link Shape}
     */
    public void draw(Shape shape) {
        System.out.print(shape.pic());
    }
}
