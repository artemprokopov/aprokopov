package ru.job4j.max;
/**
 *Max class implements a method that returns the maximum of the two number.
 *@author Prokopov Artem
 *@since 14.03.2017
 *@version 1.0
 */
public class Max {
     /**
     *This method max returns the maximum of the two numbers.
     *@param first - the first number of the operation
     *@param second - the second number of the operation
     *@return the maximum number
     */
    public int max(int first, int second) {
	return first > second ? first : second;
    }
	/**
     *This method max returns the maximum of the three numbers.
     *@param first - the first number of the operation.
     *@param second - the second number of the operation.
	 *@param third - the third number of the operetion.
     *@return the maximum number.
     */
	public int max(int first, int second, int third) {
		return max(max(first, second), max(second, third));
	}
}
