package ru.job4j.professions;
/**
 * Класс Result предоставляет результат выпоненой работы.
 * @author Prokopov Artem
 * @since 16.04.2017
 * @version 1.0
 */
public class Result {
    /**
     * Поле resultWork сохраняет строку сообщение характерзующую результат выпонениой работы.
     */
    private String resultWork;
    /**
     * Поле statusResultWork содержит результат успешности выполнения работы.
     */
    private boolean statusResultWork;
    {
        resultWork = "Работа не выполнена";
        statusResultWork = false;
    }
    /**
     * Метод формирующей результаты выпонения работы.
     * @param resultWork строка информирующая о содержании и результатах выполненой работы.
     * @param statusResultWork парамет статуса выполнения работы.
     */
    public void resultWork(String resultWork, boolean statusResultWork) {
        this.resultWork = resultWork;
        this.statusResultWork = statusResultWork;
    }
    /**
     * Метод выводит на экран строку состояния выполненой работы, и возврщающий статус результата выполненой работы.
     * @return возвращает статус выполненой работы, успешно выполненая работа true, иначе false.
     */
    public boolean whatResultWork() {
        System.out.println(resultWork);
        return statusResultWork;
    }
    /**
     * @return поле статуса выполнения работы resultWork
     */
    public String getResultWork() {
        return resultWork;
    }
}
