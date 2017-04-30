package ru.job4j.accapplications;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов класса Tracker.
 * @author Prokopov Artem
 * @since 28.04.2017
 * @version 1.0
 */
public class TrackerTest {
    /**
     * Тестируем метод add и findAll, добавляем Item, ожидаем возвращение
     * массива Item.
     */
    @Test
    public void addAndFindAllAddItemReturnTrue() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name2");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        assertThat(tracker.add(item), is(true));
        assertThat(tracker.add(item1), is(true));
        assertThat(tracker.add(item2), is(true));
        Item[] expected = {item, item1, item2};
        assertArrayEquals(tracker.findAll(), expected);
    }

    /**
     * Тестируем метод add и findAll, добавляем Item, ожидаем возвращение
     * массива Item, одинаковые Item не добавляется.
     */
    @Test
    public void addAddEqualItemReturnFalse() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = item;
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        assertThat(tracker.add(item), is(true));
        assertThat(tracker.add(item1), is(false));
        Item[] expected = {item};
        assertThat(tracker.findAll(), is(expected));
    }

    /**
     *Тестируем метод update, заменяем заявку Item1 на заявку Item2.
     */
    @Test
    public void updateSelectItem1AndUpdateForItem2() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name2");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.update(item1, item2), is(true));
        Item[] expected = {item, item2};
        assertArrayEquals(tracker.findAll(), expected);
    }

    /**
     *Тестируем метод update, заменяем не существующую
     * заявку Item на заявку Item2.
     */
    @Test
    public void updateSelectNewItemAndUpdateForItem2() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name2");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        tracker.add(item);
        tracker.add(item1);
        assertThat(tracker.update(new Item(), item2), is(false));
        Item[] expected = {item, item1};
        assertArrayEquals(tracker.findAll(), expected);
    }

    /**
     * Тестируем метод delete, удаляем вторую запись item1,
     * ожидаем массив {item, item2}.
     */
    @Test
    public void delete() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name2");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1);
        Item[] expected = {item, item2};
        assertArrayEquals(tracker.findAll(), expected);
    }

    /**
     * Тестируем метод findByName, ищем заявки с одинаковыми именами и возвращаем
     * массив с найденными заявками, либо массив 0(NULL_ITEM_ARRAY)
     * длинны если заявок не найдено.
     */
    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item[] expected = {item, item2};
        assertArrayEquals(tracker.findByName("name"), expected);
    }

    /**
     * Тестируем метод findById, ищем заявку с одинаковым id,
     * либо EMPTY_ITEM если заявоки не найдено.
     */
    @Test
    public void findById() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        Item item1 = new Item();
        Item item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item expected = item1;
        assertThat(tracker.findById(item1.getId()), is(expected));
    }
}
