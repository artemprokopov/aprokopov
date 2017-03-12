package ru.job4j.condition;
/**
 *Class Point implements point on the coordinate plane.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */
public class Point {
    /**
     *The field x stores the X coordinate point on the coordinate plane.
     */
    private int x;
    /**
     *The field y stores the Y coordinate point on the coordinate plane.
     */
    private int y;
    /**
     *Constructor will create object Point with coordinate x and y.
     *@param x - the first coordinate point, stored in the x field class.
     *@param y - the second coordinate point, stored in the y field class.
     */
    public  Point(int x, int y) {
	this.x = x;
	this.y = y;
    }
    /**
     *Getter for field x the class.
     *@return - the value of field x.
     */
    public int getX() {
	return this.x;
    }
    /**
     *Getter for field y the class.
     *@return - the value of field y.
     */
    public int getY() {
	return this.y;
    }
    /**
     *The method checks that the point lies on the graph of the function y(x) = a * x + b.
     *@param a - the first parameter of the function.
     *@param b - the second parametr of the function.
     *@return - true if point lies on the graph of the function, else return false.
     */
    public boolean is(int a, int b) {
	return this.y == a * this.x + b;
    }
}
