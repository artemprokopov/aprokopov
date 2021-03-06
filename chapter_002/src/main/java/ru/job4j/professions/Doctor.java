package ru.job4j.professions;
/**
 * Класс Doctor описывает профессию доктора, наследует класс Professions.
 * @author Prokopov Artem
 * @since 16.04.2017
 * @version 1.0
 */
public class Doctor extends Professions {
    /**
     * Конструктор вызывает конструкор супер класса.
     * @param profile - профиль профессии
     * @param education - образование подкрепляющее профиль профессии
     * @param experience - опыт в годах, полученный по данной профессии
     * @param skills - основныенаправления умения по данной профессии
     * @param position - должность занимаемая исвязанная сданной профессией
     */
    Doctor(String profile, String education, int experience, String skills, String position) {
        super(profile, education, experience, skills, position);
    }
    /**
     * Метод выполняющий абстрактную переданную работу по умолчанию, возвращает отрицательный результат
     * выполнения работы так как данный вид работы данному классу не известен, перегружает соответствующий
     * метод класса Professions.
     * @param obj - набор объектовнад которыми производится работа
     * @return возвращает результат работы ввиде ссылки на объект ResultDoctorWork
     */
    @Override
    public ResultDoctorWork work(Object... obj) {
        ResultDoctorWork resultDoctorWork = new ResultDoctorWork();
        String stringResultWork = "Доктор "
                + super.getProfile()
                + " сообщает: Работа не выполнена, мне не известен данный вид работы";
        resultDoctorWork.resultWork(stringResultWork, false);
        return resultDoctorWork;
    }
    /**
     * Маетод выполняющий манипуляции по умолчанию над пациентом.
     * @param patient пациент над которым производит работу доктор.
     * @return возвращает объект результата работы доктора типа ResultDoctorWork.
     */
    public ResultDoctorWork work(Patient patient) {
        ResultDoctorWork resultDoctorWork = new ResultDoctorWork();
        String stringResultWork = "Доктор "
                + super.getProfile()
                + " сообщает: Работа с пациентом "
                + patient.getPatient()
                + " выполнена.";
        resultDoctorWork.resultWork(stringResultWork, true);
        return resultDoctorWork;
    }
    /**
     * Метод производит работу с пациентом и его историей болезни.
     * @param patient пациент над которым производит работу доктор.
     * @param clinicalRecord История болезни пациента
     * @return возвращает объект результата работы доктора типа ResultDoctorWork.
     */
    public ResultDoctorWork work(Patient patient, ClinicalRecord clinicalRecord) {
        ResultDoctorWork resultDoctorWork = new ResultDoctorWork();
        String stringResultWork = "Доктор "
                + super.getProfile()
                + " сообщает: Работа с пациентом "
                + patient.getPatient()
                + " выполнена. "
                + clinicalRecord.getClinicalRecord()
                + " заполнена.";
        resultDoctorWork.resultWork(stringResultWork, true);
        return resultDoctorWork;
    }
    /**
     * Метод производит работу с пациентомб производится осмотр пациента на предмет его жалоб.
     * @param patient пациент над которым производит работу доктор.
     * @param examinePatient предмет жалоб пациента.
     * @return возвращает объект результата работы доктора типа ResultDoctorWork.
     */
    public ResultDoctorWork work(Patient patient, ExaminePatient examinePatient) {
        ResultDoctorWork resultDoctorWork = new ResultDoctorWork();
        String stringResultWork = "Доктор "
                + super.getProfile()
                + " сообщает: Работа с пациентом "
                + patient.getPatient()
                + " выполнена. "
                + "Осмотр на предмет "
                + examinePatient.getExaminePatient()
                + " выполнен.";
        resultDoctorWork.resultWork(stringResultWork, true);
        return resultDoctorWork;
    }
}
