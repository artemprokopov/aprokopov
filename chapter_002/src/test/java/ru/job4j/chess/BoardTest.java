package ru.job4j.chess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for class Board.
 * @author Artem Prokopov
 * @since 22.08.2017
 * @version 1.0
 */
public class BoardTest {

    /**
     * Тестируем метод добавление фигуры{@link Board#addFigure(Figure)}, добавляем три штуки.
     */
    @Test
    public void addFigure() {
        Figure figure = new Bishop(new Cell(HorizontalCoordinate.c, VerticalCoordinate.SEVEN));
        Board board = new Board();
        board.addFigure(figure);
        board.addFigure(figure);
        board.addFigure(figure);
        assertEquals(figure, board.getFigures(0));
        assertEquals(figure, board.getFigures(1));
        assertEquals(figure, board.getFigures(2));
    }

    /**
     *Тестируем метод{@link Board#move(Cell, Cell)}, начальная позиция a1,
     * конечная позиция f6.
     */
    @Test
    public void moveWhenSourceA1FigureThenMoveF6() {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.f, VerticalCoordinate.SIX);
        Figure figure = new Bishop(source);
        Board board = new Board();
        board.addFigure(figure);
        boolean ex = board.move(source, dist);
        assertEquals(ex, true);
        assertEquals(board.getFigures(0), new Bishop(dist));
    }

    /**
     *Тестируем метод{@link Board#move(Cell, Cell)}, начальная позиция a1 не фигуры,
     * конечная позиция f6.
     */
    @Test(expected = FigureNotFoundException.class)
    public void moveWhenSourceA1FigureMoveF6ThenFigureNotFoundException() {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.f, VerticalCoordinate.SIX);
        Board board = new Board();
        board.move(source, dist);
    }

    /**
     *Тестируем метод{@link Board#move(Cell, Cell)}, начальная позиция a1,
     * конечная позиция g5.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void moveWhenSourceA1FigureThenMoveG5() {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.ONE);
        Cell dist = new Cell(HorizontalCoordinate.g, VerticalCoordinate.FIVE);
        Figure figure = new Bishop(source);
        Board board = new Board();
        board.addFigure(figure);
        boolean ex = board.move(source, dist);
        assertEquals(ex, true);
    }


    /**
     *Тестируем метод{@link Board#move(Cell, Cell)}, начальная позиция a1,
     * на пути стоит фигура на d4, конечная позиция f6.
     */
    @Test(expected =  OccupiedWayException.class)
    public void moveWhenSourceA1FigureMoveF6OccupiedWayException() {
        Cell source = new Cell(HorizontalCoordinate.a, VerticalCoordinate.ONE);
        Cell figOnWay = new Cell(HorizontalCoordinate.d, VerticalCoordinate.FOUR);
        Cell dist = new Cell(HorizontalCoordinate.f, VerticalCoordinate.SIX);
        Figure figure = new Bishop(source);
        Figure figure1 = new Bishop(figOnWay);
        Board board = new Board();
        board.addFigure(figure);
        board.addFigure(figure1);
        board.move(source, dist);
    }

}