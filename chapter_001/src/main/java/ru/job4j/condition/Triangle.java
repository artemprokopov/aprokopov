package ru.job4j.condition;

/**
 *Class Triangle creates the triangle from tree point.
 *@author Prokopov Artem
 *@since 12.03.2017
 *@version 1.0
 */
public class Triangle {
    /**
     *The field aPoint stores  the first point "A" the triangle.
     */
    private Point aPoint;
    /**
     *The field bPoint stores  the second point "B" the triangle.
     */
    private Point bPoint;
    /**
     *The field cPoint stores  the third point "C" the triangle.
     */
    private Point cPoint;
	 /**
     *Constructor will create object Triangle(ABC) by points a, b, c.
     *@param a - the first the triangle point, stored in the aPoint class field.
     *@param b - the second triangle point, stored in the bPoint class field.
     *@param c - the third triangle point, stored in the cPoint class field
     */
    public Triangle(Point a, Point b, Point c) {
	this.aPoint = a;
	this.bPoint = b;
	this.cPoint = c;
    }
    /**
     *Calculates the length of sides of the triangle.
     *@param firstPoint - the first point of the side triangle
     *@param secondPoint - the second point of the side triangle
     *@return the length of a side of the triangle.
     */
    public static double lengthSide(Point firstPoint, Point secondPoint) {
	return Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2)
			+ Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
    }
    /**
     *Calculates the perimeter of the triangle.
     *@return the length of the perimeter of the triangle.
     */
    public double perimeter() {
	return Triangle.lengthSide(this.aPoint, this.bPoint)
	    + Triangle.lengthSide(this.bPoint, this.cPoint)
	    + Triangle.lengthSide(this.cPoint, this.aPoint);
    }
    /**
     *Check for existence of the triangle.
     *@return true, if triangle exist.
     */
    public boolean checkTriangleExist() {
	double lengtABSide = Triangle.lengthSide(this.aPoint, this.bPoint);
	double lengtBCSide = Triangle.lengthSide(this.bPoint, this.cPoint);
	double lengtCASide = Triangle.lengthSide(this.cPoint, this.aPoint);
	return lengtABSide < lengtBCSide +  lengtCASide
		&& lengtBCSide < lengtABSide + lengtCASide
		&& lengtCASide < lengtABSide + lengtBCSide;
    }
    /**
     *Method calculates the area of a trangle.
     *For calculation area use Heron's formula.
     *@return - the area triangle, if triangle does not exist then return -1.
     */
    public double area() {
	double areaTriangle = 0;
	double lengtABSide = Triangle.lengthSide(this.aPoint, this.bPoint);
	double lengtBCSide = Triangle.lengthSide(this.bPoint, this.cPoint);
	double lengtCASide = Triangle.lengthSide(this.cPoint, this.aPoint);
	double halfPerimeter = perimeter() / 2;
	if (checkTriangleExist()) {
	    areaTriangle = Math.sqrt(halfPerimeter * (halfPerimeter - lengtABSide)
				    * (halfPerimeter - lengtBCSide)
				    * (halfPerimeter - lengtCASide));
	} else {
	    areaTriangle = -1;
	}
	return areaTriangle;
    }
}
