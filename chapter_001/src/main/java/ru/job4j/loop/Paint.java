package ru.job4j.loop;
/**
 *The class Paint draws a pyramid with the symbols ^ and gaps.
 *@author Prokopov Artem
 *@since 15.03.2017
 *@version 1.0
 */
public class Paint {
    /**
     *Draws a pitamid with the symbol "^" and gaps.
     *@param h - the height of the pyramide.
     *@return line of the pyramide.
     */
    public String piramid(int h) {
	StringBuilder stringBuilder = new StringBuilder();
	for (int i = 0; i < h; i++) {
	    for (int j = 0; j < h - i - 1; j++) {
		stringBuilder.append("%2$s");
	    }
	    for (int k = 0; k < 2 * i + 1; k++) {
		stringBuilder.append("%2$s");
	    }
	    for (int s = 0; s < h - i - 1; s++) {
		stringBuilder.append("%1$s");
	    }
	    stringBuilder("\n");
	}
	return String.format(stringBuilder.toString(). " ", "^"); 
    }
