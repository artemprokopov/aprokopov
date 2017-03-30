package ru.job4j.test;

/**
 *Class ContainsString checks whether a string is a substring of the given string.
 *@author Prokopov Artem(mailto:art1828@mail.ru)
 *@since 30.03.2017
 *@version 1.0
 */
public class ContainsString {
    /**
     *Method the checks whether a string is a substring of the given string.
     *@param origin - the given string.
     *@param sub - check the substring.
     *@return returns true if the passed string is a substring of the specified string, else returns a false.
     */
    public boolean contains(String origin, String sub) {
	boolean result = false;
	char[] originCharArray = origin.toCharArray();
	char[] subCharArray = sub.toCharArray();
	for (int i = 0; (i < originCharArray.length) && (i + subCharArray.length <= originCharArray.length) && !result; i++) {
	    if (subCharArray[0] == originCharArray[i]) {
		result = true;
		for (int j = 1; (j < subCharArray.length) && result; j++) {
		    if (subCharArray[j] == originCharArray[i + j]) {
			result = true;
		    } else {
			result = false;
		    }
		}
	    }
	}
	return result;
    }
}
