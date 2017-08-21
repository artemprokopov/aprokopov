package ru.job4j.chess;

public abstract class Figure {
    final Cell position;

    public Figure(Cell initPosition) {
        this.position = initPosition;
    }

    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;
}
