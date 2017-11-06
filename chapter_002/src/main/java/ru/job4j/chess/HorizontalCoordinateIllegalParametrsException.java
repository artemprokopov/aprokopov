package ru.job4j.chess;
/**
 * Класс исключения, предназначено для генерации в случае
 * если задается неверная горизонтальная координата(выходящая за диапазон).
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class HorizontalCoordinateIllegalParametrsException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 3335632739422682964L;

	/**
     * Конструктор.
     * @param message сообщение.
     */
    public HorizontalCoordinateIllegalParametrsException(String message) {
        super(message);
    }
}
