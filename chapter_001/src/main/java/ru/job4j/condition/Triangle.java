package ru.job4j.condition;

/**
 *Class Triangle creates the triangle from tree point.
 *@author Prokopov Artem
 *@since 12.03.2017
 *@version 1.0
 */
public class Triangle {
    /**
     *The field aPoint stores  the first point the triangle.
     */
    private Point aPoint;
    /**
     *The field bPoint stores  the second point the triangle.
     */
    private Point bPoint;
    /**
     *The field cPoint stores  the third point the triangle.
     */
    private Point cPoint;
    /**
     *Constructor will create object Triangle by points a, b, c.
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
     *Method calculates the area of a trangle.
     *For calculation area use Heron's formula.
     *@return - the area triangle, if triangle does not exist then return -1.
     */
    public double area() {
	double areaTriangle = 0;
	double lengthFirstSideTriangle = Math.sqrt(Math.pow(this.aPoint.getX() - this.bPoint.getX(), 2)
						   + Math.pow(this.aPoint.getY() - this.bPoint.getY(), 2));
	double lengthSecondSideTriangle = Math.sqrt(Math.pow(this.bPoint.getX() - this.cPoint.getX(), 2)
						    + Math.pow(this.bPoint.getY() - this.cPoint.getY(), 2));
	double lengthThirdSideTriangle = Math.sqrt(Math.pow(this.cPoint.getX() - this.aPoint.getX(), 2)
						   + Math.pow(this.cPoint.getY() - this.aPoint.getY(), 2));
	double halfPerimeter = (lengthFirstSideTriangle + lengthSecondSideTriangle + lengthThirdSideTriangle) / 2;
	if (lengthFirstSideTriangle < lengthSecondSideTriangle +  lengthThirdSideTriangle
	    && lengthSecondSideTriangle < lengthFirstSideTriangle + lengthThirdSideTriangle
	    && lengthThirdSideTriangle < lengthFirstSideTriangle + lengthSecondSideTriangle) {
	    areaTriangle = Math.sqrt(halfPerimeter
				     * (halfPerimeter - lengthFirstSideTriangle)
				     * (halfPerimeter - lengthSecondSideTriangle)
				     * (halfPerimeter - lengthThirdSideTriangle));
	} else {
	    areaTriangle = -1;
	}
	return areaTriangle;
    }
}
