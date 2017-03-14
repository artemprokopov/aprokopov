package ru.job4j.condition;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
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
    /**
     *Test for method "lengthSide".
     *Tested the result of the  method "lengthSide"  by two Point(x,y): aPoint(0,0), bPoint(4, 0).
     *The exepted result is 4.
     */
    @Test
    public void whenLengthSideFirstPointZeroAndZeroSecondPointFourAndZeroThenFour() {
        Point aPoint = new Point(0, 0);
	Point bPoint = new Point(4, 0);
	double result = Triangle.lengthSide(aPoint, bPoint);
        double expected = 4D;
	assertThat(result, closeTo(expected, 0.01));
    }
    /**
     *Test for method "lengthSide".
     *Tested the result of the  method "lengthSide"  by two Point(x,y): aPoint(0,0), bPoint(0, 5).
     *The exepted result is 54.
     */
    @Test
    public void whenLengthSideFirstPointZeroAndZeroSecondPointZeroAndFiveThenFive() {
        Point aPoint = new Point(0, 0);
	Point bPoint = new Point(0, 5);
	double result = Triangle.lengthSide(aPoint, bPoint);
        double expected = 5D;
	assertThat(result, closeTo(expected, 0.01));
    }
    /**
     *Test for method "lengthSide".
     *Tested the result of the  method "lengthSide"  by two Point(x,y): aPoint(1, 1), bPoint(4, 4).
     *The exepted result is Math.sqrt(18).
     */
    @Test
    public void whenLengthSideFirstPointOneAndOneSecondPointFourAndFourThenSqrtEighteen() {
        Point aPoint = new Point(1, 1);
	Point bPoint = new Point(4, 4);
	double result = Triangle.lengthSide(aPoint, bPoint);
        double expected = Math.sqrt(18);
	assertThat(result, closeTo(expected, 0.01));
    }
     /**
     *Test for method "perimeter".
     *Tested the result of the  method "perimeter" for the triangle by three Point(x,y): aPoint(0,0), bPoint(1,1), cPoint(1,0).
     *The exepted result is Math.sqrt(2) + 2.0.
     */
    @Test
    public void whenPerimeterThenSqrtTwoPlusTwo() {
        Point aPoint = new Point(0, 0);
	Point bPoint = new Point(1, 1);
	Point cPoint = new Point(1, 0);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        double result = triangle.perimeter();
        double expected = Math.sqrt(2) + 2D;
	assertThat(result, closeTo(expected, 0.01));
    }
    /**
     *Test for method "checkTriangleExist".
     *Tested the result of the  method "checkTriangleExist" for the triangle by three Point(x,y): aPoint(0,0), bPoint(1,1), cPoint(1,0).
     *The exepted result is true.
     */
    @Test
    public void whenCheckTriangleExistThenTrue() {
        Point aPoint = new Point(0, 0);
	Point bPoint = new Point(1, 1);
	Point cPoint = new Point(1, 0);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        boolean result = triangle.checkTriangleExist();
        boolean expected = true;
	assertThat(result, is(expected));
    }
    /**
     *Test for method "checkTriangleExist".
     *Tested the result of the  method "checkTriangleExist"  for the triangle by three Point(x,y): aPoint(1,0), bPoint(0, 0), cPoint(2, 0).
     *Triangle does not exist.
     *The exepted result is false.
     */
    @Test
    public void whenCheckTriangleExistThenFalse() {
        Point aPoint = new Point(1, 0);
	Point bPoint = new Point(0, 0);
	Point cPoint = new Point(2, 0);
	Triangle triangle = new Triangle(aPoint, bPoint, cPoint);
        boolean result = triangle.checkTriangleExist();
        boolean expected = false;
	assertThat(result, is(expected));
    }
}
