package ru.job4j.professions;
/**
 *  Класс Teacher реализует функционал профессии Учитель.
 * @author Prokopov Artem
 * @since 18.04.2017
 * @version 1.0
 */
public class Teacher extends Professions {
    /**
     Основной конструктор инициализтрующий классб через вызов
     * @param profile - профиль профессии
     * @param education - образование подкрепляющее профиль профессии
     * @param experience - опыт в годах, полученный по данной профессии
     * @param skills - основныенаправления умения по данной профессии
     * @param position - должность занимаемая и связанная с данной профессией
     */
    public Teacher(String profile, String education, int experience, String skills, String position) {
        super(profile, education, experience, skills, position);
    }
    /**
     * Метод выполняет работу(учитель проводит урок) над группой студентов в соответствии с предписаниями объекта Lesson.
     * @param students - объект описывающий группу студентов.
     * @param lesson - объект предоставляющий программу  и тему урока
     * @return - результат проведения урока объект ResultTeacherWork
     */
    public ResultTeacherWork work(Students students, Lesson lesson) {
        ResultTeacherWork resultTeacherWork = new ResultTeacherWork();
        StringBuilder stringResultWork = new StringBuilder();
        return resultTeacherWork;
    }
    /**
     * Метод выполняет работу(выдача домашнего задания)  группе студентов в соответствии с предписаниями объекта HomeWork.
     * @param students - объект описывающий группу студентов.
     * @param homeWork - объект предоставляющий программу  домашнего задания
     * @return - результат выдачи домашнего задания, объект ResultTeacherWork
     */
    public ResultTeacherWork work(Students students, HomeWork homeWork) {
        ResultTeacherWork resultTeacherWork = new ResultTeacherWork();
        StringBuilder stringResultWork = new StringBuilder();
        return resultTeacherWork;
    }
    /**
     * Метод выполняет работу(проведения экзамена, контрольной работы) в группе студентов в соответствии с предписаниями объекта Examine.
     * @param students - объект описывающий группу студентов.
     * @param examine - объект предоставляющий программу  экзамена
     * @return - результат проведения экзамена, объект ResultTeacherWork
     */
    public ResultTeacherWork work(Students students, Examine examine) {
        ResultTeacherWork resultTeacherWork = new ResultTeacherWork();
        StringBuilder stringResultWork = new StringBuilder();
        return resultTeacherWork;
    }
    /**
     * Метод выполняющий абстрактную переданную работу по умолчанию, возвращает отрицательный результат
     * выполнения работы так как данный вид работы данному классу не известен, перегружает соответствующий
     * метод класса Professions.
     * @param obj - набор объектовнад которыми производится работа
     * @return возвращает результат работы ввиде ссылки на объект ResultDoctorWork
     */
    @Override
    public ResultTeacherWork work(Object... obj) {
        ResultTeacherWork resultTeacherWork = new ResultTeacherWork();
        StringBuilder stringResultWork = new StringBuilder();
        stringResultWork.append("Учитель ");
        stringResultWork.append(super.getProfile());
        stringResultWork.append(" сообщает: Работа не выполнена, мне не известен данный вид работы");
        resultTeacherWork.resultWork(stringResultWork.toString(), false);
        return resultTeacherWork;
    }

}
