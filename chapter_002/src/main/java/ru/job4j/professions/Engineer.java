package ru.job4j.professions;

/**
 * Created by art18 on 12.04.2017.
 */
public class Engineer extends Professions {
    public Engineer(String profile, String education, int experience, String skills, String position) {
        super(profile, education, experience, skills, position);
    }

    public ResultEngineerWork work(Project project, Personal personal) {
        return null;
    }

    public ResultEngineerWork work(Project project) {
        return null;
    }

    @Override
    public ResultEngineerWork work(Object... obj) {
        return null;
    }
}
