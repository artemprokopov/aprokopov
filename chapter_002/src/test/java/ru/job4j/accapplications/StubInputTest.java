package ru.job4j.accapplications;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
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
     */
    @Test
    public void selectMenuItemZeroAddItemTestNameItemAndExit() {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Add Item success!\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "0. Add new Item", проверяем значени введеного поля заявки desc.
     */
    @Test
    public void selectMenuItemZeroAddItemTestDescItemAndExit() {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getDesc(), is("test desk"));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Add Item success!\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "0. Add new Item", проверяем значени введеного поля заявки coments.
     */
    @Test
    public void selectMenuItemZeroAddItemTestCommentsItemAndExit() {
        Input input = new StubInput(0, 6, "test name", "test desk", "test comment");
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getComments()[0], is("test comment"));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Add Item success!\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "1. Show all items", проверяем проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemOneAddItemTestShowAllItemAndExit() {
        Input input = new StubInput(1, 6, "");
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(),  is("***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Name: " + tracker.findAll()[0].getName()
                + "\n"
                + "Desc: " + tracker.findAll()[0].getDesc()
                + "\n"
                + "Comments: \n"
                + tracker.findAll()[0].getComments()[0]
                + "\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "2. Edit item", проверяем редактируемую заявку, проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemTwoAddItemTestEditItemAndExit() {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(2, 6, item.getId(), "test name1", "test desk1", "test comment1");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Name: " + "test name"
                + "\n"
                + "Desc: " + "test desk"
                + "\n"
                + "Comments: \n"
                + tracker.findAll()[0].getComments()[0]
                + "\n"
                + "***************************************************************\n"
                + "***************************************************************\n"));
        assertThat(tracker.findAll()[0].getId(), is(item.getId()));
        assertThat(tracker.findAll()[0].getName(), is("test name1"));
        assertThat(tracker.findAll()[0].getDesc(), is("test desk1"));
        assertThat(tracker.findAll()[0].getComments(), is(new String[]{"test comment", "test comment1"}));

    }

    /**
     * Тест выбор пункта меню "3. Delete item", проверяем удаление заявки, проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemThreeAddItemTestDeleteItemAndExit() {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(3, 6, item.getId());
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll(), is(Tracker.NULL_ITEM_ARRAY));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "Item removed!"
                + "\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "4. Find item by Id", проверяем нахождение заявки по Id, проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemThreeNotFindItemTestDeleteItemAndExit() {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(3, 6, " ");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "Item not found!"
                + "\n"
                + "***************************************************************\n"));
    }

    /**
     * Тест выбор пункта меню "4. Find item by Id", проверяем нахождение заявки по Id, проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemFourAddItemTestFindByIdItemAndExit() {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(4, 6, item.getId());
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0], is(item));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Name: " + tracker.findAll()[0].getName()
                + "\n"
                + "Desc: " + tracker.findAll()[0].getDesc()
                + "\n"
                + "Comments: \n"
                + tracker.findAll()[0].getComments()[0]
                + "\n"
                + "***************************************************************\n"
                + "***************************************************************\n"));
    }

    /**
     *  Тест выбор пункта меню "5. Find items by name", проверяем нахождение заявки по Id, проверяем консольный вывод.
     */
    @Test
    public void selectMenuItemFiveAddItemTestFindByNameItemAndExit() {
        Item item = new Item();
        item.setName("test name");
        item.setDesc("test desk");
        item.addComments("test comment");
        Input input = new StubInput(5, 6, "test name");
        tracker.add(item);
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(outputStream.toString(), is("***************************************************************\n"
                + "***************************************************************\n"
                + "Id: " + tracker.findAll()[0].getId()
                + "\n"
                + "Data: "
                + new SimpleDateFormat().format(new Date(tracker.findAll()[0].getCreated()))
                + "\n"
                + "Name: " + tracker.findAll()[0].getName()
                + "\n"
                + "Desc: " + tracker.findAll()[0].getDesc()
                + "\n"
                + "Comments: \n"
                + tracker.findAll()[0].getComments()[0]
                + "\n"
                + "***************************************************************\n"
                + "***************************************************************\n"));
    }
}