package ru.job4j.accapplications;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов класса Item.
 * @author Prokopov Artem
 * @since 28.04.2017
 * @version 1.0
 */
public class ItemTest {
    /**
     * Тестируем метод equalsId и getCopyItemSafeIdAndCreated, сравниваем объект
     * и его копию, по полю id, ожидаем true.
     */
    @Test
    public void equalsIdWhenAddCopyItemTrue() {
        Item item = new Item();
        Item copyItem = item.getCopyItemSafeIdAndCreated();
        boolean result = item.equalsId(copyItem);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод equalsId , сравниваем два объекта по полю id,
     * ожидаем false.
     */
    @Test
    public void equalsIdWhenAddItemFalse() {
        Item item = new Item();
        Item item1 = new Item();
        boolean result = item.equalsId(item1);
        assertThat(result, is(false));
    }

    /**
     * Тестируем метод equalsItem , сравниваем два объекта по всем полям кроме
     * id и created, ожидаем true.
     */
    @Test
    public void equalsItem()  {
        Item item = new Item();
        Item item1 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name");
        item1.setDesc("desc");
        item1.setComments(new String[]{"111", "2222", "3333"});
        boolean result = item.equalsItem(item1);
        assertThat(result, is(true));
    }

    /**
     * Тестируем метод getCopyItemWithNewIdAndCreated,
     * сравниваем два объекта по всем полям кроме
     * id и created, ожидаем true.
     */
    @Test
    public void getCopyItemWithNewIdAndCreated() {
        Item item = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        Item item1 = item.getCopyItemWithNewIdAndCreated();
        boolean result = item.equalsItem(item1);
        assertThat(result, is(true));
    }

    /**
     * Тест проводит проверку выполнения метода addComments, при отсутствии комментариев в заявке.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void addCommentAddStringReturnArrayWithOneString() {
        Item item = new Item();
        String comment = "Привет мир";
        item.addComments(comment);
        String[] expected = {"Привет мир"};
        assertArrayEquals(item.getComments(), expected);
    }

    /**
     * Тест проводит проверку выполнения метода addComments, добавление двух комментариев подряд.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void addCommentAddTwoStringReturnArrayWithTwoString() {
        Item item = new Item();
        String comment = "Привет мир";
        item.addComments(comment);
        item.addComments(comment);
        String[] expected = {"Привет мир", "Привет мир"};
        assertArrayEquals(item.getComments(), expected);
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
        assertArrayEquals(item.getComments(), expected);
        assertThat(result, is(true));
    }

    /**
     * Тест проводит проверку выполнения метода deletComment, удаление второго комментария из массива.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void deletCommentArrayThreeStringDeletCommentNotExist() {
        Item item = new Item();
        String[] comment = {"Привет мир",
                "Да здравствует мир",
                "Я люблю тебя мир"};
        String delComment = "Да здравствует";
        item.setComments(comment);
        boolean result = item.deletComment(delComment);
        String[] expected = {"Привет мир", "Да здравствует мир", "Я люблю тебя мир"};
        assertArrayEquals(item.getComments(), expected);
        assertThat(result, is(false));
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
        assertArrayEquals(item.getComments(), expected);
        assertThat(result, is(true));
    }
    /**
     * Тест проводит проверку выполнения метода updateComment, обновляем комментарий которогрого нет.
     * Проверяется результат возвращаемый методом getComments.
     */
    @Test
    public void updateCommentArrayThreeStringUpdateCommentNotExist() {
        Item item = new Item();
        String updateComment = "Да здравствует мир";
        String newComment = "Мир прекрасен";
        boolean result = item.updateComment(updateComment, newComment);
        String[] expected = new String[0];
        assertArrayEquals(item.getComments(), expected);
        assertThat(result, is(false));
    }

    /**
     * Тестируем метод equals и getCopyItemSafeIdAndCreated, сравниваем объект
     * и его копию, ожидаем true.
     */
    @Test
    public void equalsWhenAddCopyItemTrue() {
        Item item = new Item();
        Item copyItem = item.getCopyItemSafeIdAndCreated();
        boolean result = item.equals(copyItem);
        assertThat(result, is(true));
    }
}
