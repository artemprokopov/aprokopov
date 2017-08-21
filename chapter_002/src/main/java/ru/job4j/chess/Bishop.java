package ru.job4j.chess;

import java.util.Arrays;

/**
 * Class Bishop(describes a chess piece), extends the abstract class Figure.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class Bishop extends Figure {
    /**
     *The constructor for class initialization
     *that causes the constructor abstract super class Figure.
     * @param initPosition the parameter defines the start
     *                     position{@link Cell} of chess figure on a chess Board.
     */
    public Bishop(Cell initPosition) {
        super(initPosition);
    }

    /**
     * Returns the path of a chess piece to the desired cells.
     * @param dist cell end the way chess figure
     * @return the array of cells the path of figure on the chess Board
     * @throws ImpossibleMoveException in case of failure figure to go to the specified cell.
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int count = 0;
        Cell nextCellPosition;
        Cell[] result = new Cell[0];
        int difHorizontal = differenceHorizontalCoordinate(dist);
        int difVertical = differenceVerticalCoordinate(dist);
        if (Math.abs(difHorizontal) != Math.abs(difVertical)) {
            throw new ImpossibleMoveException("Figure can't go for this cell!");
        }
        Gradient horGradient = Gradient.getTypeGradient(-difHorizontal);
        Gradient verGradient = Gradient.getTypeGradient(-difVertical);
        nextCellPosition = this.nextCell(Gradient.ZERO, Gradient.ZERO);
        while (this.hasNextCell(horGradient, verGradient) & !nextCellPosition.equals(dist)) {
            nextCellPosition = nextCellPosition.nextCell(horGradient, verGradient);
            result = Arrays.copyOf(result, ++count);
            result[count - 1] = nextCellPosition;
        }
        return result;
    }

    /**
     * Clones figure on a given cell.
     * @param cl the specified cell
     * @return object instance of the Bishop with the specified new provision cl.
     */
    public Figure clone(Cell cl) {
        return new Bishop(cl);
    }
}
