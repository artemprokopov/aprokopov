package ru.job4j.accapplications;

/**
 * Класс описывающий исключительную ситуацию ввод неверных данных при выборе пунктов меню.
 * @author Artem Prokopov
 * @since 27.07.2017
 * @version 1.0
 * @see java.lang.RuntimeException
 */

public class MenuOutException extends RuntimeException {
    /**
	 *
	 */
	private static final long serialVersionUID = -8425222286675090525L;

	/**
     * Конструктор класса.
     * @param message страка сообщения об исключительной ситуации.
     */
    public MenuOutException(String message) {
        super(message);
    }
}
