package ru.job4j.loop;
/**
 *The class Factorial calculates factorial.
 *@author Prokopov Artem
 *@since 15.03.2017
 *@version 1.0
 */
public class Factorial {
    /**
     *Calculates the factorial of a number n.
     *@param n - the number to calculate the factorial.
     *@return the factorial number, or 0 if n is negative.
     */
	public int calc(int n) {
		int factorial = 0;
		if (n == 0 || n == 1) {
            factorial = 1;
        } else if (n > 0) {
			factorial = n;
			for (int i = n - 1; i > 0; i--) {
				factorial = factorial * i;
			}
		}
        return factorial;
	 }
}
