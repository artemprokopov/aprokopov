package ru.job4j.accapplications;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов класса Item.
 * @author Prokopov Artem
 * @since 28.04.2017
 * @version 1.0
 */
public class ItemTest {
    /**
     * Тест проводит проверку выполнения метода addComments, при отсутствии комментариев в заявке.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void addCommentsAddStringReturnArrayWithOneString() {
        Item item = new Item();
        String comment = "Привет мир";
        item.addComments(comment);
        String[] expected = {"Привет мир"};
        assertThat(item.getComments(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода addComments, добавление двух комментариев подряд.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void addCommentsAddTwoStringReturnArrayWithTwoString() {
        Item item = new Item();
        String comment = "Привет мир";
        item.addComments(comment);
        item.addComments(comment);
        String[] expected = {"Привет мир", "Привет мир"};
        assertThat(item.getComments(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода deletComment, удаление второго комментария из массива.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void deletCommentArrayThreeStringDeletStringNumberTwo() {
        Item item = new Item();
        String[] comment = {"Привет мир",
                            "Да здравствует мир",
                            "Я люблю тебя мир"};
        String delComment = "Да здравствует мир";
        item.setComments(comment);
        boolean result = item.deletComment(delComment);
        String[] expected = {"Привет мир", "Я люблю тебя мир"};
        boolean  expected1 = true;
        assertThat(item.getComments(), is(expected));
        assertThat(result, is(expected1));
    }

    /**
     * Тест проводит проверку выполнения метода updateComment, перезапись второго комментария из массива.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void updateCommentArrayThreeStringUpdateStringNumberTwo() {
        Item item = new Item();
        String[] comment = {"Привет мир",
                "Да здравствует мир",
                "Я люблю тебя мир"};
        String updateComment = "Да здравствует мир";
        String newComment = "Мир прекрасен";
        item.setComments(comment);
        boolean result = item.updateComment(updateComment, newComment);
        String[] expected = {"Привет мир", "Мир прекрасен", "Я люблю тебя мир"};
        boolean  expected1 = true;
        assertThat(item.getComments(), is(expected));
        assertThat(result, is(expected1));
    }
}
