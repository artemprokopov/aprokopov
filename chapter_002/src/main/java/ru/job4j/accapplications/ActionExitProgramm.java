package ru.job4j.accapplications;

/**
 * Класс выполнения запроса на выход из программы.
 * @author Artem Prokopov
 * @since 22.05.2017
 * @version 1.0
 */
public class ActionExitProgramm implements Action {
    /**
     * Метод запускает выполнения задачи, на выход из программы.
     * @param tracker хранилище где ведется поиск заявок.
     * @param input интерфейс получения вводимых данных.
     * @return ActionType.EXIT, сигнал выхода из программы.
     */
    @Override
    public ActionType execute(Tracker tracker, Input input) {
        return ActionType.EXIT;
    }
}
