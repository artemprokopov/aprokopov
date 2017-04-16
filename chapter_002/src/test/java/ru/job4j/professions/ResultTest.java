package ru.job4j.professions;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Группа тестов класса Result.
 * @author Prokopov Artem
 * @since 20.03.2017
 * @version 1.0
 */
public class ResultTest {
    /**
     * Тест проверяющи работу метода resultWork при передаче строки и значения true.
     */
    @Test
    public void resultWorkWhenStingThenString() {
        Result result = new Result();
        result.resultWork("Работа выполнена", true);
        String expected1 = "Работа выполнена";
        boolean expected2 = true;
        assertThat(result.getResultWork(), is(expected1));
        assertThat(result.whatResultWork(), is(expected2));
    }
    /**
     * Тест проверяющи работу метода whatResultWork при передаче значения true.
     */
    @Test
    public void whatResultWorkWhenResultWorkTrueThenReturnTrue() {
        Result result = new Result();
        result.resultWork("Работа выполнена", true);
        boolean expected = true;
        assertThat(result.whatResultWork(), is(expected));
    }

}