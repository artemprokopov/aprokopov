package ru.job4j.chess;
/**
 * Класс исключения, предназначено для генерации в случае
 * если шахматная фигура не может совершить ход так как
 * он будет противоречить правилам шахмат.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class ImpossibleMoveException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -603193920940086393L;

	/**
     * Конструктор.
     * @param message сообщение.
     */
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
