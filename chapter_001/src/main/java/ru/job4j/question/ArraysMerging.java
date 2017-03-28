package ru.job4j.question;

/**
 *Class ArrayMerging merges the arrays in one array.
 *@author Prokopov Artem
 *@since 28.03.2017
 *@version 1.0
 */
public class ArraysMerging {
    /**
     *The method merges arrays.
     *@param arrayOne - the first array to merge.
     *@param arrayTwo - the second array to merge
     *@return connected array.
     */
    public int[] merge(int[] arrayOne, int[] arrayTwo) {
	int[] mergeArray = new int[arrayOne.length + arrayTwo.length];
        int i = 0, j = 0;
        while (i + j < mergeArray.length) {
            if (i < arrayOne.length && j < arrayTwo.length) {
                if (arrayOne[i] < arrayTwo[j]) {
                    mergeArray[i + j] = arrayOne[i];
                    i++;
                } else  {
                    mergeArray[i + j] = arrayTwo[j];
                    j++;
                }
            }
            if (i == arrayOne.length && j < arrayTwo.length) {
		mergeArray[i + j] = arrayTwo[j];
		j++;
            }
            if (j == arrayTwo.length && i < arrayOne.length) {
		mergeArray[i + j] = arrayOne[i];
		i++;
            }
        }
	return mergeArray;
    }
}
