package ru.job4j.array;
/**
 *Class RotateArray demonstrates the turn of array clockwise.
 *@author Prokopov Artem
 *@since 17.03.2017
 *@version 1.0
 */
public class RotateArray {
    /**
     *Sort the sort method of the array.
     *@param array - passed the array for rotation.
     *@return the rotated  array.
     */
    public int[][] rotate(int[][] array) {
		int lengthArray = array.length;
		int[][] tempArray = new int[lengthArray][lengthArray];
		for (int i = 0; i < lengthArray; i++) {
			for (int j = 0; j < lengthArray; j++) {
				tempArray[j][lengthArray - 1 - i] = array[i][j];
			}
		}
		return tempArray;
    }
}
