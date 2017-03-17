package ru.job4j.array;
/**
 *Class Turn demonstrates the array sorting method Bubble.
 *@author Prokopov Artem
 *@since 17.03.2017
 *@version 1.0
 */
public class BubbleSort {
    /**
     *Sort the sort method of the array.
     *@param array - passed the array to sort.
     *@return deployed in the back of the array.
     */
    public int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[i]) {
				array[i] = array[j] + array[i];
				array[j] = array[i] - array[j];
				array[i] = array[i] - array[j];
				}
			}
		}
		return array;
    }
}