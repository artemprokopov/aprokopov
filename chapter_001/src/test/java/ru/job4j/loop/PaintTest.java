package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Paint class.
* @author Artem Prokopov (mailto:art1828@mail.ru)
* @version $Id$
* @since 15.03.2017
* @version 1.0
*/
public class PaintTest {
/**
*Test method piramid.
*Tested the result of the  method "piramide" n = 2.
*The exeptede result is " ^ \n
*						 ^^^\n"
*/
    @Test
    public void whenPiramidTwoThenString() {
	Paint paint = new Paint();
	String result = paint.piramid(2);
	assertThat(result, is(String.format("%1$s%2$s%1$s\n
										 %2$s%2$s%2$s\n", 
										" ", "^")));
    }
/**
*Test method piramid.
*Tested the result of the  method "piramide" n = 3.
*The exeptede result is "  ^  \n 
*						  ^^^ \n
*						 ^^^^^\n"
*/
    @Test
    public void whenPiramidTwoThenString() {
	Paint paint = new Paint();
	String result = paint.piramid(3);
	assertThat(result, is(String.format("%1$s%1$s%2$s%1$s%1$s\n
										 %1$s%2$s%2$s%2$s%1$s\n
										 %2$s%2$s%2$s%2$s%2$s\n", 
										 " ", "^")));
    }
}
