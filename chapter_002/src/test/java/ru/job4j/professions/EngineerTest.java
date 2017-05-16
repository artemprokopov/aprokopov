package ru.job4j.professions;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов класса Engineer.
 * @author Prokopov Artem
 * @since 18.04.2017
 * @version 1.0
 */

public class EngineerTest {
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenObjectThenWhatResultWorkFalse() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        ResultEngineerWork result = engineer.work(new Object());
        boolean expected = false;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenObjectThenResultWorkString() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        ResultEngineerWork result = engineer.work(new Object());
        String expected = "Инженер Электрик сообщает: Работа не выполнена, мне не известен данный вид работы";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Project.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenProjectThenWhatResultWorkTrue() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        Project project = new Project();
        ResultEngineerWork result = engineer.work(project);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Project.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenProjectThenResultWorkString() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        Project project = new Project();
        ResultEngineerWork result = engineer.work(project);
        String expected = "Инженер Электрик сообщает: Работа по проекту Проект выполнена.";
        assertThat(result.getResultWork(), is(expected));

    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Project и Personal.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenProjectAndPersonalThenWhatResultWorkTrue() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        Project project = new Project();
        Personal personal = new Personal();
        ResultEngineerWork result = engineer.work(project, personal);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Project и Personal.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenProjectAndPersonalThenResultWorkString() {
        Engineer engineer = new Engineer("Электрик", "высшее", 5,
                "кабельные сети", "инженер ПТО");
        Project project = new Project();
        Personal personal = new Personal();
        ResultEngineerWork result = engineer.work(project, personal);
        String expected = "Инженер Электрик сообщает: Работа по проекту Проект выполнена."
                + " Использован подчиненный персонал.";
        assertThat(result.getResultWork(), is(expected));
    }
}