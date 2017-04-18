package ru.job4j.professions;
/**
 *  Класс Teacher реализует функционал профессии Учитель.
 * @author Prokopov Artem
 * @since 18.04.2017
 * @version 1.0
 */
public class Engineer extends Professions {
    /**
     Основной конструктор инициализтрующий классб через вызов
     * @param profile - профиль профессии
     * @param education - образование подкрепляющее профиль профессии
     * @param experience - опыт в годах, полученный по данной профессии
     * @param skills - основныенаправления умения по данной профессии
     * @param position - должность занимаемая и связанная с данной профессией
     */
    public Engineer(String profile, String education, int experience, String skills, String position) {
        super(profile, education, experience, skills, position);
    }

    public ResultEngineerWork work(Project project, Personal personal) {
        ResultEngineerWork resultEngineerWork = new ResultEngineerWork();
        StringBuilder stringResultWork = new StringBuilder();
        return resultEngineerWork;
    }

    public ResultEngineerWork work(Project project) {
        ResultEngineerWork resultEngineerWork = new ResultEngineerWork();
        StringBuilder stringResultWork = new StringBuilder();
        return resultEngineerWork;
    }
    /**
     * Метод выполняющий абстрактную переданную работу по умолчанию, возвращает отрицательный результат
     * выполнения работы так как данный вид работы данному классу не известен, перегружает соответствующий
     * метод класса Professions.
     * @param obj - набор объектовнад которыми производится работа
     * @return возвращает результат работы ввиде ссылки на объект ResultEngineerWork
     */
    @Override
    public ResultEngineerWork work(Object... obj) {
        ResultEngineerWork resultEngineerWork = new ResultEngineerWork();
        StringBuilder stringResultWork = new StringBuilder();
        stringResultWork.append("Инженер ");
        stringResultWork.append(super.getProfile());
        stringResultWork.append(" сообщает: Работа не выполнена, мне не известен данный вид работы");
        resultEngineerWork.resultWork(stringResultWork.toString(), false);
        return resultEngineerWork;
    }
}
