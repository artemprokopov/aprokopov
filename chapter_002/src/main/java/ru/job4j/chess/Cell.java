package ru.job4j.chess;

public class Cell {
    private final ColorCell colorCell;
    private final HorizontalCoordinate horizontalCoordinate;
    private final VerticalCoordinate verticalCoordinate;

    public Cell(HorizontalCoordinate initHorizontalCoordinate,
                VerticalCoordinate initVerticalCoordinate,
                ColorCell initColorCell) {
        this.colorCell = initColorCell;
        this.horizontalCoordinate = initHorizontalCoordinate;
        this.verticalCoordinate = initVerticalCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (colorCell != cell.colorCell) return false;
        if (horizontalCoordinate != cell.horizontalCoordinate) return false;
        return verticalCoordinate == cell.verticalCoordinate;
    }

    @Override
    public int hashCode() {
        int result = colorCell.hashCode();
        result = 31 * result + horizontalCoordinate.hashCode();
        result = 31 * result + verticalCoordinate.hashCode();
        return result;
    }
}
