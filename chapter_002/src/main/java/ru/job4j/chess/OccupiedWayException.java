package ru.job4j.chess;
/**
 * Класс исключения, предназначено для генерации в случае
 * если шахматная фигура не может совершить ход, так как путь закрывает
 * другая фигура расположенная на шахматной доске.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class OccupiedWayException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = 4644644258181826934L;

	/**
     * Констуктор.
     * @param message сообщение.
     */
    public OccupiedWayException(String message) {
        super(message);
    }
}
