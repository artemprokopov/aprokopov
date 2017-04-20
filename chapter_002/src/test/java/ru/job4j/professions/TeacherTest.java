package ru.job4j.professions;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов класса Engineer.
 * @author Prokopov Artem
 * @since 18.04.2017
 * @version 1.0
 */
public class TeacherTest {
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenObjectThenWhatResultWorkFalse() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        ResultTeacherWork result = teacher.work(new Object());
        boolean expected = false;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenObjectThenResultWorkString() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        ResultTeacherWork result = teacher.work(new Object());
        String expected = "Учитель Биологии сообщает: Работа не выполнена, мне не известен данный вид работы";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и Lesson.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenStudentsAndLessonThenWhatResultWorkTrue() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        Lesson lesson = new Lesson();
        ResultTeacherWork result = teacher.work(students, lesson);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и Lesson.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenStudentsAndLessonThenResultWorkString() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        Lesson lesson = new Lesson();
        ResultTeacherWork result = teacher.work(students, lesson);
        String expected = "Учитель Биологии сообщает: Работа с Группа студентов по теме урока выполнена.";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и HomeWork.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenStudentsAndHomeWorkThenWhatResultWorkTrue() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        HomeWork homeWork = new HomeWork();
        ResultTeacherWork result = teacher.work(students, homeWork);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и HomeWork.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenStudentsAndHomeWorkThenResultWorkString() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        HomeWork homeWork = new HomeWork();
        ResultTeacherWork result = teacher.work(students, homeWork);
        String expected = "Учитель Биологии сообщает: Работа с Группа студентов по выдачи Домашнее задание выполнена.";
        assertThat(result.getResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и Examine.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenStudentsAndExamineThenWhatResultWorkTrue() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        Examine examine = new Examine();
        ResultTeacherWork result = teacher.work(students, examine);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объекты Students и Examine.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenStudentsAndExamineThenResultWorkString() {
        Teacher teacher = new Teacher("Биологии", "высшее", 5,
                "насекомые", "Завуч");
        Students students = new Students();
        Examine examine = new Examine();
        ResultTeacherWork result = teacher.work(students, examine);
        String expected = "Учитель Биологии сообщает: Работа с Группа студентов по приему экзамена выполнена.";
        assertThat(result.getResultWork(), is(expected));
    }
}