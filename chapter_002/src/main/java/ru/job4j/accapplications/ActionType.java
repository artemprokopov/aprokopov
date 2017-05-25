package ru.job4j.accapplications;

/**
 * Перечисление, сигналы возвращаемые объектами типа Action.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public enum ActionType {
    /**
     * Сигнал выхода из программы.
     */
    EXIT,
    /**
     * Сигнад нормального следования, успешного выполнения операции программы.
     */
    NORMAL,
    /**
     *  Сигнал ошибки при выполнении операции.
     */
    ERROR
}
