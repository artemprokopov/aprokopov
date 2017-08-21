package ru.job4j.chess;
/**
 * Абстрактный класс шахматных фигур.
 * @author Artem Prokopov
 * @since 26.08.2017
 * @version 1.0
 */
public abstract class Figure {
    /**
     * Поле позиции фигуры на шахматной доске.
     */
    private final Cell position;

    /**
     * Конструктор.
     *
     * @param initPosition позиция фигуры на шахматной доске.
     */
    public Figure(Cell initPosition) {
        this.position = initPosition;
    }

    /**
     * Абстрактный медод формирующий путь фигуры по шахмтной доске.
     *
     * @param dist конечная клетка хода фигуры.
     * @return массив клеток шахматной доски по которым совершает ход шахматная фигура.
     * @throws ImpossibleMoveException генерируется если ход невозможно совершить, так как он протеворечит
     *                                 правилам шахмат.
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Метод создания фигуры на клетке окончания хода.
     *
     * @param cl клетка на которую переместиласть фигура.
     * @return эеземпляр объекта Figure с новым положением заданным cl.
     */
    public abstract Figure clone(Cell cl);

    /**
     * Возвращает разность, между текущем положением фигуры и клеткой хода,
     * горизонтальных координат клеток шахматной доски.
     * @param cl клетка куда предполагается совершить ход.
     * @return разность горизонтальных координат текущего положения и клеткой
     * на которую предполагается совершить ход.
     */
    int differenceHorizontalCoordinate(Cell cl) {
        return position.differenceHorizontalCoordinate(cl);
    }

    /**
     * Возвращает разность, между текущем положением фигуры и клеткой хода,
     * вертикальных координат клеток шахматной доски.
     * @param cl клетка куда предполагается совершить ход.
     * @return разность вертикальных координат текущего положения и клеткой
     * на которую предполагается совершить ход.
     */
    public int differenceVerticalCoordinate(Cell cl) {
        return position.differenceVerticalCoordinate(cl);
    }

    /**
     * Возвращает следующую клетку шахматной доски определяемую направлением
     * horizontalGradient и verticalGradient{@link Gradient}.
     *
     * @param horizontalGradient направление движения по горизонтали.
     * @param verticalGradient   направления движения по вертикали.
     * @return новая клетка определяемая направлением движения.
     */
    public Cell nextCell(Gradient horizontalGradient, Gradient verticalGradient) {
        return position.nextCell(horizontalGradient, verticalGradient);
    }

    /**
     * Проверяет существует ли по заданнаму направления клетка шахматной доски
     * (тоесть смотрим не достигли мы края доски).
     * @param horizontalGradient направление движения по горизонтали.
     * @param verticalGradient   направления движения по вертикали.
     * @return true, если клетка существует, в противном случае false.
     */
    public boolean hasNextCell(Gradient horizontalGradient, Gradient verticalGradient) {
        return position.hasNextCell(horizontalGradient, verticalGradient);
    }

    /**
     * Проверка занимает ли фигура переданную клетку шахмтной доски.
     * @param cl тестируемая клетка.
     * @return true  если занимает, в противном случае false.
     */
    public boolean isOnCell(Cell cl) {
        return position.equals(cl);
    }

    /**
     * Переопределяем equals.
     * @param o сравниваемый объект.
     * @return true если объекты равны.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Figure figure = (Figure) o;

        return position.equals(figure.position);
    }

    /**
     * Переопределяем hashCode.
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return position.hashCode();
    }
}

