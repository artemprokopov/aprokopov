package ru.job4j.accapplications;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

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
    Item item;
    Item item1;
    Item item2;
    Tracker tracker = new Tracker();
    @Before
    public void createItem() {
        item = new Item();
        item1 = new Item();
        item2 = new Item();
        item.setName("name");
        item.setDesc("desc");
        item.setComments(new String[]{"111", "2222", "3333"});
        item1.setName("name1");
        item1.setDesc("desc1");
        item1.setComments(new String[]{"1111", "22222", "33333"});
        item2.setName("name");
        item2.setDesc("desc2");
        item2.setComments(new String[]{"11111", "222222", "333333"});
    }
    /**
     * Тестируем метод add и findAll, добавляем Item, ожидаем возвращение
     * массива Item.
     *
     */
    @Test
    public void addAndFindAllAddItemReturnTrue() {
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
        item = item1;
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
        tracker.add(item);
        tracker.add(item1);
        tracker.add(item2);
        Item expected = item1;
        assertThat(tracker.findById(item1.getId()), is(expected));
    }

    /**
     * Тест производитльности метода add, по сравнению с методом add ArrayList.
     * Выполняется по 10 прогонов, добавляем 100_000 заявок.
     */
    @Test
    @Ignore
    public void testSpeedAdd() {
        long[] timeArrayAddTracker = new long[10];
        long[] timeArrayListAdd = new long[10];
        long timeStart = 0;
        for (int i = 0; i < 10; i++) {
            Tracker tracker = new Tracker();
            timeStart = new Date().getTime();
            for (int j = 0; j < 10000 ; j++) {
                tracker.add(new Item());
            }
            timeArrayAddTracker[i] = new Date().getTime() - timeStart;
            System.out.println("ta: " + i);
        }
        for (int i = 0; i < 10; i++) {
            ArrayList<Item> itemArrayList = new ArrayList<>();
            timeStart = new Date().getTime();
            for (int j = 0; j < 10000 ; j++) {
                itemArrayList.add(new Item());
            }
            timeArrayListAdd[i] = new Date().getTime() - timeStart;
            System.out.println("aa: " + i);
        }
        for (int i = 0; i < 10; i++) {
            String st = "Tarcker add: "
                    + timeArrayAddTracker[i]
                    + " "
                    + "ArrayList add: "
                    + timeArrayListAdd[i]
                    + " "
                    + "subtraction Time Tracker Add - Time ArrayList add: "
                    + (timeArrayAddTracker[i] - timeArrayListAdd[i]);
            System.out.println(st);
        }
    }
}
