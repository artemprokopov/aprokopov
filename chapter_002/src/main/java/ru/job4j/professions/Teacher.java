package ru.job4j.professions;

/**
 * Created by art18 on 12.04.2017.
 */
public class Teacher extends Professions {
    public Teacher(String profile, String education, int experience, String skills, String position) {
        super(profile, education, experience, skills, position);
    }

    public ResultTeacherWork work(Students students, Lesson lesson) {
        return null;
    }

    public ResultTeacherWork work(Students students, HomeWork homeWork) {
        return null;
    }

    public ResultTeacherWork work(Students students, Examine examine) {
        return null;
    }
    @Override
    public ResultTeacherWork work(Object... objects) {
        return null;
    }

}
