package ru.job4j.strategy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Группа тестов консольного  вывода изображения фигур методом {@link Paint#draw(Shape)}.
 * @author Prokopov Artem
 * @since 07.07.2017
 * @version 1.0
 */
public class PaintTest {
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
     * Проверяем вывод на консоль изображения  треугольника псевдографикой
     * при передаче методу draw() объекта Triangle.
     */
    @Test
    public void drawAddObjectTriangleThenOutConsoleTriangle() {
        String result = new StringBuilder().append("   #   \n")
                                           .append("  ###  \n")
                                           .append(" ##### \n")
                                           .append("#######").toString();
        new Paint().draw(new Triangle());
        assertThat(outputStream.toString(), is(result));
    }

    /**
     * Проверяем вывод на консоль изображения квадрата псевдографикой
     * при передаче методу draw() объекта Square.
     */
    @Test
    public void drawAddObjectSquareThenOutConsoleSquare() {
        String result = new StringBuilder().append("#######\n")
                                           .append("#######\n")
                                           .append("#######\n")
                                           .append("#######\n")
                                           .append("#######\n")
                                           .append("#######\n")
                                           .append("#######").toString();
        new Paint().draw(new Square());
        assertThat(outputStream.toString(), is(result));
    }

}