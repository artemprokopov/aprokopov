package ru.job4j.chess;
/**
 * Класс исключения, предназначено для генерации в случае
 * если шахматная фигура отсутствует на указанных клетках.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class FigureNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2135127157042031839L;

	/**
     * Конструктор.
     * @param message сообщение.
     */
    public FigureNotFoundException(String message) {
        super(message);
    }
}
