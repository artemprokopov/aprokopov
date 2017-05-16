package ru.job4j.professions;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Группа тестов класса Professions.
 * @author Prokopov Artem
 * @since 16.04.2017
 * @version 1.0
 */

public class ProfessionsTest {
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется результат возвращаемый методом whatResultWork.
     */
    @Test
    public void workWhenObjectThenWhatResultWorkTrue()  {
        Professions professions = new Professions("Биология", "высшее", 3,
                                                    "рыбы", "младший преподаватель");
        Result result = professions.work(new Object());
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }
    /**
     * Тест проводит проверку выполнения метода work, в который передается произвольный объект Object.
     * Проверяется значение поля resultWork после выполнения метода work.
     */
    @Test
    public void workWhenObjectThenResultWorkString() {
        Professions professions = new Professions("Биология", "высшее", 3,
                "рыбы", "младший преподаватель");
        Result result = professions.work(new Object());
        String expected = "Работа выполнена";
        assertThat(result.getResultWork(), is(expected));
    }
}