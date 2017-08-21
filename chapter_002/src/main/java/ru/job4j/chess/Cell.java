package ru.job4j.chess;
/**
 * Базовый класс клетки шахматной доски.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public class Cell {
    /**
     * Поле горизонтальной координаты {@link HorizontalCoordinate}.
     */
    private final HorizontalCoordinate horizontalCoordinate;
    /**
     * Поле вертикальной координаты {@link VerticalCoordinate}.
     */
    private final VerticalCoordinate verticalCoordinate;

    /**
     * Конструктор.
     * @param initHorizontalCoordinate горизонтальная координата.
     * @param initVerticalCoordinate вертикальнаякоордината.
     */
    public Cell(HorizontalCoordinate initHorizontalCoordinate,
                VerticalCoordinate initVerticalCoordinate) {
        this.horizontalCoordinate = initHorizontalCoordinate;
        this.verticalCoordinate = initVerticalCoordinate;
    }

    /**
     * Возвращает следующую клетку шахматной доски определяемую направлением
     * horizontalGradient и verticalGradient{@link Gradient}.
     * @param horizontalGradient направление движения по горизонтали.
     * @param verticalGradient   направления движения по вертикали.
     * @return новая клетка определяемая направлением движения.
     * @throws HorizontalCoordinateIllegalParametrsException генерируется при достижении
     *                                                          края доски по горизонтали.
     * @throws VerticalCoordinateIllegalParametersException генерируется при достижении
     *                                                          края доски по вертикали.
     */
    public Cell nextCell(Gradient horizontalGradient, Gradient verticalGradient)
        throws HorizontalCoordinateIllegalParametrsException, VerticalCoordinateIllegalParametersException {

        return new Cell(this.horizontalCoordinate.getNextType(horizontalGradient),
                this.verticalCoordinate.getNextType(verticalGradient));
    }


    /**
     * Проверяет существует ли по заданнаму направления клетка шахматной доски
     * (тоесть смотрим не достигли мы края доски).
     * @param horizontalGradient направление движения по горизонтали.
     * @param verticalGradient   направления движения по вертикали.
     * @return true, если клетка существует, в противном случае false.
     */
    public boolean hasNextCell(Gradient horizontalGradient, Gradient verticalGradient) {
       if (this.horizontalCoordinate.hasNext(horizontalGradient)
               && this.verticalCoordinate.hasNext(verticalGradient)) {

           return true;
       }

       return false;
    }

    /**
     * Возвращает разность, между текущем положением фигуры и клеткой хода,
     * горизонтальных координат клеток шахматной доски.
     * @param cl клетка куда предполагается совершить ход.
     * @return разность горизонтальных координат текущего положения и клеткой
     * на которую предполагается совершить ход.
     */
    public int differenceHorizontalCoordinate(Cell cl) {
        return this.horizontalCoordinate.getCount() - cl.horizontalCoordinate.getCount();
    }

    /**
     * Возвращает разность, между текущем положением фигуры и клеткой хода,
     * вертикальных координат клеток шахматной доски.
     * @param cl клетка куда предполагается совершить ход.
     * @return разность вертикальных координат текущего положения и клеткой
     * на которую предполагается совершить ход.
     */
    public int differenceVerticalCoordinate(Cell cl) {
        return  this.verticalCoordinate.getCount() - cl.verticalCoordinate.getCount();
    }

    /**
     * Перепределяем метод equals.
     * @param o объект сравнения.
     * @return если поля равны возвращаем true, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (horizontalCoordinate != cell.horizontalCoordinate) {
            return false;
        }
        return verticalCoordinate == cell.verticalCoordinate;
    }

    /**
     * Переопределяем метод hashCode.
     * @return hashCode.
     */
    @Override
    public int hashCode() {
        int result = horizontalCoordinate.hashCode();
        result = 31 * result + verticalCoordinate.hashCode();
        return result;
    }
}
