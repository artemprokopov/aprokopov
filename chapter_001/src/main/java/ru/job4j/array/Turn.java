package ru.job4j.array;
/**
 *Class Turn demonstrates the rotation of the array in the opposite direction.
 *@author Prokopov Artem
 *@since 17.03.2017
 *@version 1.0
 */
public class Turn {
    /**
     *Back the method reverses the array.
     *@param array - the array passed to the method to rotate in a reverse order.
     *@return deployed in the back of the array.
     */
    public int[] back(int[] array) {
		for (int i = 0; i < array.length / 2; i++) {
			array[i] = array[array.length - i - 1] + array[i];
			array[array.length - i - 1] = array[i] - array[array.length - i - 1];
			array[i] = array[i] - array[array.length - i - 1];
		}
		return array;
    }
}
