package ru.job4j.chess;
/**
 * Класс исключения, предназначено для генерации в случае
 * если задается неверная вертикальная координата(выходящая за диапазон).
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0*/
public class VerticalCoordinateIllegalParametersException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = -78717189416194017L;

	/**
     * Конструктор.
     * @param message сообщение.
     */
    public VerticalCoordinateIllegalParametersException(String message) {
        super(message);
    }
}
