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
     *The field lengthFirstSideTriangl stores  the length first side of the triangle.
     */
    private double lengthFirstSideTriangle;
     /**
     *The field lengthSecondSideTriangl stores  the length second side of the triangle.
     */
    private double lengthSecondSideTriangle;
     /**
     *The field lengthSecondSideTriangl stores  the length third side of the triangle.
     */
    private double lengthThirdSideTriangle;
     /**
     *The field halfPerimeter stores  the length semi-perimeter of the triangle.
     */
    private double halfPerimeter;
     /**
     *If a triangle exists holds true.
     */
    private boolean triangleExist;
    /**
     *Calculates the length of sides of the triangle.
     *@param firstPoint - the first point of the side triangle
     *@param secondPoint - the second point of the side triangle
     *@return the length of a side of the triangle.
     */
    private  double lengthSideTriangle(Point firstPoint, Point secondPoint) {
	return Math.sqrt(Math.pow(firstPoint.getX() - secondPoint.getX(), 2)
			 + Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
    }
    /**
     *Calculates the semi-perimeter of the triangle.
     *@param aLength length first side triangle.
     *@param bLength length second side triangle.
     *@param cLength length third side triangle.
     *@return the length of the semi-perimeter of the triangle.
     */
    private double calculateHalfPerimeter(double aLength, double bLength, double cLength) {
	return (aLength + bLength + cLength) / 2;
    }
    /**
     *Check for existence of the triangle.
     *@param aLength length first side triangle.
     *@param bLength length second side triangle.
     *@param cLength length third side triangle.
     *@return true, if triangle exist.
     */
    private boolean checkTriangleExist(double aLength, double bLength, double cLength) {
	return aLength < bLength +  cLength && bLength < aLength + cLength && cLength < aLength + bLength;
    }
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
	this.lengthFirstSideTriangle = this.lengthSideTriangle(this.aPoint, this.bPoint);
	this.lengthSecondSideTriangle = this.lengthSideTriangle(this.bPoint, this.cPoint);
	this.lengthThirdSideTriangle = this.lengthSideTriangle(this.cPoint, this.aPoint);
	this.halfPerimeter = this.calculateHalfPerimeter(this.lengthFirstSideTriangle, this.lengthSecondSideTriangle, this.lengthThirdSideTriangle);
	this.triangleExist = this.checkTriangleExist(this.lengthFirstSideTriangle, this.lengthSecondSideTriangle, this.lengthThirdSideTriangle);
    }
    /**
     *Method calculates the area of a trangle.
     *For calculation area use Heron's formula.
     *@return - the area triangle, if triangle does not exist then return -1.
     */
    public double area() {
	double areaTriangle = 0;
	if (triangleExist) {
	    areaTriangle = Math.sqrt(this.halfPerimeter * (this.halfPerimeter - this.lengthFirstSideTriangle)
				     * (this.halfPerimeter - this.lengthSecondSideTriangle)
				     * (this.halfPerimeter - this.lengthThirdSideTriangle));
	} else {
	    areaTriangle = -1;
	}
	return areaTriangle;
    }
}
