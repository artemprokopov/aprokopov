package ru.job4j.loop;
/**
 *The class Counter shows the work loop .
 *@author Prokopov Artem
 *@since 15.03.2017
 *@version 1.0
 */
public class Counter {
     /**
     *Calculates the sum of even numbers.
     *@param start - the first number in the range.
     *@param finish - the last number in the range.
     *@return the sum of even numbers.
     */
    public int add(int start, int finish) {
	int sumEvenNumber = 0;
	for (int i = start; i <= finish; i++) {
	    if (i % 2 == 0) {
		sumEvenNumber = sumEvenNumber + i;
	    }
	}
	return sumEvenNumber;
    }
}
