package ru.job4j.accapplications;

/**
 * Created by A003 on 11.07.2017.
 */
public abstract class BaseAction implements Action {
    /**
     * Уникальный индификатор действия.
     */
    private final int keyAction;
    /**
     * Наименование действия.
     */
    private final String actionName;

    /**
     * Конструктор инициальзирует поля {@link BaseAction#keyAction} и {@link BaseAction#actionName}.
     * @param keyAction уникальный индификатор действия.
     * @param actionName наименование действия.
     */
    protected BaseAction(int keyAction, String actionName) {
        this.keyAction = keyAction;
        this.actionName = actionName;
    }

    /**
     * Метод возвращает уникальный индификатор действия.
     * @return уникальный индификатор действия пользователя.
     */
    @Override
    public int key() {
        return keyAction;
    }

    /**
     * Метод формирует строку из полей {@link BaseAction#keyAction} и {@link BaseAction#actionName}.
     * @return строку информирующую о уникальном индификаторе и наименовании действия в формате "%s. %s".
     */
    @Override
    public String show() {
        return String.format("%s. %s", keyAction, actionName);
    }
}
