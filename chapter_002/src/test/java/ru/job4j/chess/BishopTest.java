package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Tests for class Bishop.
 * @author Artem Prokopov
 * @since 22.08.2017
 * @version 1.0
 */
public class BishopTest {
    /**
     *Тестируем метод {@link Bishop#way(Cell)} входные параметры начальное положение фигуры Bishop,
     * A1, ячейка куда двигается фигура f6.
     */
    @Test
    public void wayWhenFigureA1WayToF6()  {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.f, VerticalCoordinate.SIX);
        Bishop bishop = new Bishop(source);
        Cell[] expected = new Cell[]{new Cell(HorizontalCoordinate.b, VerticalCoordinate.TWO),
                new Cell(HorizontalCoordinate.c, VerticalCoordinate.THREE),
                new Cell(HorizontalCoordinate.d, VerticalCoordinate.FOUR),
                new Cell(HorizontalCoordinate.e, VerticalCoordinate.FIVE),
                new Cell(HorizontalCoordinate.f, VerticalCoordinate.SIX)};
        Cell[] cells = bishop.way(dist);
        assertArrayEquals(expected, cells);
    }

    /**
     *Тестируем метод {@link Bishop#way(Cell)} входные параметры начальное положение фигуры Bishop,
     * H7, ячейка куда двигается фигура B2.
     */
    @Test
    public void wayWhenFigureH7WayToC2()  {
        Cell source = new Cell(HorizontalCoordinate.h, VerticalCoordinate.SEVEN);
        Cell dist = new Cell(HorizontalCoordinate.c, VerticalCoordinate.TWO);
        Bishop bishop = new Bishop(source);
        Cell[] expected = new Cell[]{new Cell(HorizontalCoordinate.g, VerticalCoordinate.SIX),
                new Cell(HorizontalCoordinate.f, VerticalCoordinate.FIVE),
                new Cell(HorizontalCoordinate.e, VerticalCoordinate.FOUR),
                new Cell(HorizontalCoordinate.d, VerticalCoordinate.THREE),
                new Cell(HorizontalCoordinate.c, VerticalCoordinate.TWO)};
        Cell[] cells = bishop.way(dist);
        assertArrayEquals(expected, cells);
    }


    /**
     *Тестируем метод {@link Bishop#way(Cell)} входные параметры начальное положение фигуры Bishop,
     * A7, ячейка куда двигается фигура G1.
     */
    @Test
    public void wayWhenFigureA7WayToG1()  {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.SEVEN);
        Cell dist = new Cell(HorizontalCoordinate.g, VerticalCoordinate.ONE);
        Bishop bishop = new Bishop(source);
        Cell[] expected = new Cell[]{new Cell(HorizontalCoordinate.b, VerticalCoordinate.SIX),
                new Cell(HorizontalCoordinate.c, VerticalCoordinate.FIVE),
                new Cell(HorizontalCoordinate.d, VerticalCoordinate.FOUR),
                new Cell(HorizontalCoordinate.e, VerticalCoordinate.THREE),
                new Cell(HorizontalCoordinate.f, VerticalCoordinate.TWO),
                new Cell(HorizontalCoordinate.g, VerticalCoordinate.ONE)};
        Cell[] cells = bishop.way(dist);
        assertArrayEquals(expected, cells);
    }

    /**
     *Тестируем метод {@link Bishop#way(Cell)} входные параметры начальное положение фигуры Bishop,
     * F1, ячейка куда двигается фигура A6.
     */
    @Test
    public void wayWhenFigureF1WayToA6()  {
        Cell source = new Cell(HorizontalCoordinate.f, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.a, VerticalCoordinate.SIX);
        Bishop bishop = new Bishop(source);
        Cell[] expected = new Cell[]{new Cell(HorizontalCoordinate.e, VerticalCoordinate.TWO),
                new Cell(HorizontalCoordinate.d, VerticalCoordinate.THREE),
                new Cell(HorizontalCoordinate.c, VerticalCoordinate.FOUR),
                new Cell(HorizontalCoordinate.b, VerticalCoordinate.FIVE),
                new Cell(HorizontalCoordinate.a, VerticalCoordinate.SIX)};
        Cell[] cells = bishop.way(dist);
        assertArrayEquals(expected, cells);
    }

    /**
     *Тестируем метод {@link Bishop#way(Cell)} входные параметры начальное положение фигуры Bishop,
     * F1, ячейка куда двигается фигура D6. Ожидаем ImpossibleMoveException.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void wayWhenFigureF1WayToD6ThenImpossibleMoveException()  {
        Cell source = new Cell(HorizontalCoordinate.f, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.d, VerticalCoordinate.SIX);
        Bishop bishop = new Bishop(source);
        bishop.way(dist);
    }

    /**
     * Тестируем метод clone.
     * Входные даннные фигура Bishop на A6, новое положение D3.
     */
    @Test
    public void cloneTest()  {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.SIX);
        Cell dist = new Cell(HorizontalCoordinate.d, VerticalCoordinate.THREE);
        Figure figure = new Bishop(source);
        Figure figure1 = new Bishop(dist);
        assertEquals(figure.clone(dist), figure1);
    }

}