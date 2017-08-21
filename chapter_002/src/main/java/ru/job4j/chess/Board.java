package ru.job4j.chess;

import java.util.Arrays;
/**
 * Класс шахматной доски.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class Board {
    /**
     * Массив фигур рассположенных на шахматной доске.
     */
    private Figure[] figures = new Figure[0];

    /**
     * Метод движения фигуры по доске.
     * @param source клетка доски откуда совершается ход.
     * @param dist клетка доски на которую соершается ход.
     * @return в случае успеха возвращает true, в противном случае false.
     * @throws ImpossibleMoveException генерируется при невозможности фигурой совершить ход,
     *                                  так как это противоречит правилам хода шахматной фигуры.
     * @throws OccupiedWayException генерируется, если на пути фигуры стоит другая фигура.
     * @throws FigureNotFoundException генерируется в случа если в клетке source нет фигуры.
     */
    boolean move(Cell source, Cell dist) throws ImpossibleMoveException,
                                                OccupiedWayException,
                                                FigureNotFoundException {
        boolean result = false;
        // номер выбранной фигуры из массива figures, по умолчанию 0;
        int selFigure = 0;

        //проверяем существует ли фигура на заданной клетке source
        for (int i = 0; i < figures.length && !result; i++) {
            result = figures[i].isOnCell(source);
                selFigure = i;
        }

        //если фигуры нет кидаем исключение FigureNotFoundException
        if (!result) {
            throw new FigureNotFoundException("The figure is not found in the cell!");
        }

        //Получаем путь фгуры и проверяем если на пути у насдругие фигуры
        //если есть кидае исклчение OccupiedWayException.
        // Если фигура по правилам шахмат не может пойти на клетку dist
        //то метод way кидает исключение ImpossibleMoveException.
        for (Cell cl: figures[selFigure].way(dist)) {
            for (Figure f: figures) {
                if (f.isOnCell(cl)) {
                    throw new OccupiedWayException("Way busy!");
                }
            }
        }
        //если все прошло удачно, то перемещаем фигуру на клетку.
        if (result) {
            figures[selFigure] = figures[selFigure].clone(dist);
        }
        return result;
    }

    /**
     * Получаем фигуру из массива {@link Board#figures}по номеру, больше нужно для тестов.
     * @param i номер(индекс массива) фигуры.
     * @return фигуру.
     */
    public Figure getFigures(int i) {
        if (i >= 0 && i < figures.length) {
            return figures[i];
        }
        throw new IllegalArgumentException("Invalid argument!");
    }

    /**
     * Добавляет новую фигуру в массив {@link Board#figures}.
     * @param f фигура объект наследовавший абстрактный класс {@link Figure}.
     */
    public void addFigure(Figure f) {
        figures = Arrays.copyOf(figures, figures.length + 1);
        figures[figures.length - 1] = f;
    }
}
