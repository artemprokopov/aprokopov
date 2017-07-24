package ru.job4j.accapplications;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Группа тестов консольного ввода и вывода.
 * @author Prokopov Artem
 * @since 05.07.2017
 * @version 1.0
 */
public class StubInputTest {
    /**
     * Создаем локальное хранилище для выполнения тестов.
     */
    private Tracker tracker = new Tracker();
    /**
     * Создаем поток для перехвата и проверки консольного вывода.
     */
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    /**
     * Перехватываем консольный вывод.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outputStream));
    }

    /**
     * После тестов возвращаем консольный вывод к значению по умолчанию.
     */
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }
    /**
     * Тест выбор пункта меню "0. Add new Item", проверяем значени введеного поля заявки name.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemZeroAddItemTestNameItemAndExit() throws IOException {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Add Item success!")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "0. Add new Item", проверяем значени введеного поля заявки desc.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemZeroAddItemTestDescItemAndExit() throws IOException {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getDesc(), is("test desk"));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Add Item success!")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "0. Add new Item", проверяем значени введеного поля заявки coments.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemZeroAddItemTestCommentsItemAndExit() throws IOException {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getComments()[0], is("test comment"));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Add Item success!")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "1. Show all items", проверяем проверяем консольный вывод.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemOneAddItemTestShowAllItemAndExit() throws IOException {
        Input input = new StubInput(1, 6, "");
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        tracker.add(item);
        Item item1 = new Item();
        item1.setName("test name1");
        item1.setDesc("test desk1");
        item1.addComments("test comment1");
        tracker.add(item1);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(),  is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(tracker.findAll()[0].getName())
                        .append(System.lineSeparator())
                        .append("Desc: ")
                        .append(tracker.findAll()[0].getDesc())
                        .append(System.lineSeparator())
                        .append("Comments: ")
                        .append(System.lineSeparator())
                        .append(tracker.findAll()[0].getComments()[0])
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[1].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[1].getCreated())))
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(tracker.findAll()[1].getName())
                        .append(System.lineSeparator())
                        .append("Desc: ")
                        .append(tracker.findAll()[1].getDesc())
                        .append(System.lineSeparator())
                        .append("Comments: ")
                        .append(System.lineSeparator())
                        .append(tracker.findAll()[1].getComments()[0])
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "2. Edit item", проверяем редактируемую заявку, проверяем консольный вывод.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemTwoAddItemTestEditItemAndExit() throws IOException {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(2, 6, item.getId(), "test name1", "test desk1", "test comment1");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append("test name")
                        .append(System.lineSeparator())
                        .append("Desc: ")
                        .append("test desk")
                        .append(System.lineSeparator())
                        .append("Comments: ")
                        .append(System.lineSeparator())
                        .append(tracker.findAll()[0].getComments()[0])
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
        assertThat(tracker.findAll()[0].getId(), is(item.getId()));
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
        assertThat(tracker.findAll()[0].getDesc(), is("test desk1"));
        assertThat(tracker.findAll()[0].getComments(), is(new String[]{"test comment", "test comment1"}));

    }

    /**
     * Тест выбор пункта меню "3. Delete item", проверяем удаление заявки, проверяем консольный вывод.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemThreeAddItemTestDeleteItemAndExit() throws IOException {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(3, 6, item.getId());
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll(), is(Tracker.NULL_ITEM_ARRAY));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Item removed!")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "4. Find item by Id", проверяем нахождение заявки по Id, проверяем консольный вывод.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemThreeNotFindItemTestDeleteItemAndExit() throws IOException {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(3, 6, " ");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Item not found!")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     * Тест выбор пункта меню "4. Find item by Id", проверяем нахождение заявки по Id, проверяем консольный вывод.
     * @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemFourAddItemTestFindByIdItemAndExit() throws IOException {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(4, 6, item.getId());
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(tracker.findAll()[0].getName())
                        .append(System.lineSeparator())
                        .append("Desc: ")
                        .append(tracker.findAll()[0].getDesc())
                        .append(System.lineSeparator())
                        .append("Comments: ")
                        .append(System.lineSeparator())
                        .append(tracker.findAll()[0].getComments()[0])
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }

    /**
     *  Тест выбор пункта меню "5. Find items by name", проверяем нахождение заявки по Id, проверяем консольный вывод.
     *  @throws IOException если происходит ошибка ввода вывода.
     */
    @Test
    public void selectMenuItemFiveAddItemTestFindByNameItemAndExit() throws IOException {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(5, 6, "test name");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(outputStream.toString(), is(
                new StringBuilder("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("Id: ")
                        .append(tracker.findAll()[0].getId())
                        .append(System.lineSeparator())
                        .append("Data: ")
                        .append(new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated())))
                        .append(System.lineSeparator())
                        .append("Name: ")
                        .append(tracker.findAll()[0].getName())
                        .append(System.lineSeparator())
                        .append("Desc: ")
                        .append(tracker.findAll()[0].getDesc())
                        .append(System.lineSeparator())
                        .append("Comments: ")
                        .append(System.lineSeparator())
                        .append(tracker.findAll()[0].getComments()[0])
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("***************************************************************")
                        .append(System.lineSeparator())
                        .append("0. Add new Item")
                        .append(System.lineSeparator())
                        .append("1. Show all items")
                        .append(System.lineSeparator())
                        .append("2. Edit item")
                        .append(System.lineSeparator())
                        .append("3. Delete item")
                        .append(System.lineSeparator())
                        .append("4. Find item by Id")
                        .append(System.lineSeparator())
                        .append("5. Find items by name")
                        .append(System.lineSeparator())
                        .append("6. Exit Program")
                        .append(System.lineSeparator())
                        .toString()));
    }
}