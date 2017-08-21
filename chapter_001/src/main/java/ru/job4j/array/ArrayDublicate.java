package ru.job4j.array;

import java.util.Arrays;
/**
 *Class ArrayDublicate deletes duplicate elements from an array.
 *@author Prokopov Artem
 *@since 20.03.2017
 *@version 1.0
 */
public class ArrayDublicate {
    /**
     *Method the deletes duplicate elements from an array.
     *@param array - the array to remove duplicate elements.
     *@return an array of remote replays.
     */
    public String[] remove(String[] array) {
	int count = 0;
	for (int i = 0; i < array.length - count; i++) {
	    for (int j = i + 1; j < array.length - count; j++) {
		if (array[j].equals(array[i])) {
		    array[j] = array[array.length - 1 - count];
		    count++;
		    j--;
		}
	    }
	}
	return Arrays.copyOf(array, array.length - count);
    }
}
