package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;
/**
 *Tests for Triangle class.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */
public class TriangleTest {
    /**
     *Test for method "area".
     *Tested the result of the  method "area" for the triangle by three Point(x,y): aPoint(2,2), bPoint(1,1), cPoint(3,1).
     *The exepted result is 1.0.
     */
    @Test
    public void whenAreaThenOne() {
        Point aPoint = new Point(2, 2);
	Point bPoint = new Point(1, 1);
	Point cPoint = new Point(3, 1);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        double result = triangle.area();
        double expected = 1D;
	assertThat(result, closeTo(expected, 0.01));
    }
    /**
     *Test for method "area".
     *Tested the result of the  method "area"  for the triangle by three Point(x,y): aPoint(1,2), bPoint(0, 0), cPoint(2, 0).
     *The exepted result is 2.0.
     */
    @Test
    public void whenAreaThenTwo() {
        Point aPoint = new Point(1, 2);
	Point bPoint = new Point(0, 0);
	Point cPoint = new Point(2, 0);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        double result = triangle.area();
        double expected = 2D;
	assertThat(result, closeTo(expected, 0.01));
    }
     /**
     *Test for method "area".
     *Tested the result of the  method "area"  for the triangle by three Point(x,y): aPoint(1,0), bPoint(0, 0), cPoint(2, 0).
     *Triangle does not exist.
     *The exepted result is -1.
     */
    @Test
    public void whenAreaThenMinusOne() {
        Point aPoint = new Point(1, 0);
	Point bPoint = new Point(0, 0);
	Point cPoint = new Point(2, 0);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        double result = triangle.area();
        double expected = -1D;
	assertThat(result, closeTo(expected, 0.01));
    }
}
