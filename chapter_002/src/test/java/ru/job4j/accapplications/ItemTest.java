package ru.job4j.accapplications;

import org.junit.Test;

import java.util.Date;

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
     * Тест проводит проверку выполнения метода getName.
     * Проверяется результат возвращаемый методом getName, ожидается пустая строка.
     */
    @Test
    public void getNameWhenCreateItemThenGetNameReturnEmptyString() {
        Item item = new Item();
        String expected = "";
        assertThat(item.getName(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода setName.
     * Проверяется результат устанавливаемый методом setName, ожидается "Avrora" .
     */
    @Test
    public void setNameWhenSetAvroraGetNameAvrora() {
        Item item = new Item();
        item.setName("Avrora");
        String expected = "Avrora";
        assertThat(item.getName(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода getDesc.
     * Проверяется результат возвращаемый методом getDesc, ожидается пустая строка.
     */
    @Test
    public void getDescWhenCreateItemGetDeskReturnEmptyString() {
        Item item = new Item();
        String expected = "";
        assertThat(item.getDesc(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода setDesc.
     * Проверяется результат устанавливаемый методом setDesc, ожидается "Avrora" .
     */
    @Test
    public void setDescWhenSetAvroraGetDescAvrora() {
        Item item = new Item();
        item.setDesc("Avrora");
        String expected = "Avrora";
        assertThat(item.getDesc(), is(expected));
    }

    /**
     * Тест проводит проверку выполнения метода getCreated.
     * Проверяется результат получаемы методом getCreated, ожидается разница с
     * текущей датой меньше 5.
     */
    @Test
    public void getCreatedWhenCreateItemThenDateMinusGetCreatedLess5() {
        Item item = new Item();
        long result = new Date().getTime() - item.getCreated();
        assertThat(true, is(result < 5));
    }

    /**
     * Тест проводит проверку выполнения метода setCreated.
     * Проверяется результат получаемы методом setCreated, передаем методу 12
     * ожидаем результат возвращаемый методом getCreated равный 12.
     */
    @Test
    public void setCreatedWhenSet12GetCreatedReturn12() {
        Item item = new Item();
        item.setCreated(12L);
        long result = item.getCreated();
        assertThat(result, is(12L));
    }

    /**
     * Тест проводит проверку выполнения метода setCreated.
     * Проверяется результат получаемы методом setCreated, вызываем метод
     * ожидаем результат возвращаемый методом getCreated и разницей с текущей
     * датой менее 5.
     */
    @Test
    public void setCreatedWhenSetThenDateMinusGetCreatedLess5() {
        Item item = new Item();
        item.setCreated();
        long result = new Date().getTime() - item.getCreated();
        assertThat(true, is(result < 5));
    }

    /**
     * Тестируем методы setComments и getComments передаем массив строк, получаем
     * тот же массив обратно.
     */
    @Test
    public void setGetCommentsWhenSetArrayStringThenGetArrayString() {
        Item item = new Item();
        String[] comments = {"Привет мир",
                "Да здравствует мир",
                "Я люблю тебя мир"};
        item.setComments(comments);
        assertThat(item.getComments(), is(comments));
    }

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
        assertThat(item.getComments(), is(expected));
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
        assertThat(item.getComments(), is(expected));
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
        assertThat(item.getComments(), is(expected));
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
        assertThat(item.getComments(), is(expected));
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
        assertThat(item.getComments(), is(expected));
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
