package ru.job4j.calculator;

/**
 *Calculator class is implements simple calculator.
 *@author Prokopov Artem
 *@since 10.03.2017
 *@version 1.0
 */

public class Calculator {
    /**
     *The field result stores the result of arithmetic operations.
     */
    private double result;
    /**
     *Method add performs the arithmetic addition operation.
     *@param first - the first number of the operation
     *@param second - the second number of the operation
     */
    public void add(double first, double second) {
	this.result = first + second;
    }
    /**
     *Method substruct performs the arithmetic operation of subtraction.
     *@param first - the first number of the operation
     *@param second - the second number of the operation
     */
    public void substruct(double first, double second) {
	this.result = first - second;
    }
    /**
     *Method div performs the arithmetic division operation.
     *@param first - the first number of the operation
     *@param second - the second number of the operation
     */
    public void div(double first, double second) {
	this.result = first / second;
    }
    /**
     *Method multiple performs the arithmetic operation of multiplication.
     *@param first - the first number of the operation
     *@param second - the second number of the operation
     */
    public void multiple(double first, double second) {
	this.result = first * second;
    }
    /**
     *Method getResult returns the value field class result.
     *@return result - field class stores the result of arithmetic operations.
     */
    public double getResult() {
        return this.result;
    }
}
