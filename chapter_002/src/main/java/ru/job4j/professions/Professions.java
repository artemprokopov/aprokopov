package ru.job4j.professions;
/**
 *  Класс Professions описывает базовые характеристики профессий.
 * @author Prokopov Artem
 * @since 16.04.2017
 * @version 1.0
 */
public class Professions {
    /**
     *  Основные характеристики профессии:
     *  profile - профиль профессии
     *  education - образование подкрепляющее профиль профессии
     *  experience - опыт в годах, полученный по данной профессии
     *  skills - основныенаправления умения по данной профессии
     *  position - должность занимаемая и связанная с данной профессией
     */
    private String profile;
    private String education;
    private int experience;
    private String skills;
    private String position;
    /**
     * Основной конструктор инициализтрующий класс.
     * @param profile - профиль профессии
     * @param education - образование подкрепляющее профиль профессии
     * @param experience - опыт в годах, полученный по данной профессии
     * @param skills - основныенаправления умения по данной профессии
     * @param position - должность занимаемая и связанная с данной профессией
     */
    Professions(String profile, String education, int experience, String skills, String position) {
        this.profile = profile;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
        this.position = position;
    }
    /**
     * Метод выполняющий абстрактную переданную работу по умолчанию
     * @param obj - набор объектовнад которыми производится работа
     * @return возвращает результат работы ввиде ссылки на объект Result
     */
    public Result work(Object... obj) {
        Result result = new Result();
        result.resultWork("Работа выполнена", true);
        return result;
    }
    /**
     * @return поле profile
     */
    public String getProfile() {
        return profile;
    }
    /**
     * @return  поле education
     */
    public String getEducation() {
        return education;
    }
    /**
     * @return поле experience
     */
    public int getExperience() {
        return experience;
    }
    /**
     * @return поле skills
     */
    public String getSkills() {
        return skills;
    }
    /**
     * @return поле position
     */
    public String getPosition() {
        return position;
    }
}