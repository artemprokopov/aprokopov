package ru.job4j.strategy;

/**
 * Класс квадрат, реализует отображение псевдографикой геометрической фигуры квадрат.
 * Реализует интерфейс {@link Shape}
 * @author Artem Prokopov
 * @since 07.07.2017
 * @version 1.0
 */
public class Square implements Shape {
    /**
     * Поле, хранит строку изображения фигуры псевдографикой.
     */
    private final String shapePic;

    /**
     * Инициализация поля, присваевается строка изображающая фигуру ввиде псевдографики.
     */
    {
        shapePic = "#######\n#######\n#######\n#######\n#######\n#######\n#######";
    }

    /**
     * @return Возвращает строку содержащую изображение геометрической фигуры ввиде псевдографики.
     */
    @Override
    public String pic() {
        return shapePic;
    }
}
