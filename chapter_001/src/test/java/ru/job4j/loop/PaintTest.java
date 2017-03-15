package ru.job4j.loop;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Test Paint class.
* @author Artem Prokopov (mailto:art1828@mail.ru)
* @version $Id$
* @since 15.03.2017
* @version 1.0
*/
public class CalculateTest {
/**
*Test method piramid.
*Tested the result of the  method "piramide" n = 2.
*The exeptede result is " ^ \n^^^\n"
*/
    @Test
    public void whenPiramidTwoThenString() {
	Paint paint = new Paint();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	System.setOut(new PrintStream(out));
	paint.piramid(2);
	assertThat(out.toString(), is(String.format("%1$s%2$s%1$s\n
												 %2$s%2$s%2$s\n", 
												 " ", "^")));
    }
/**
*Test method piramid.
*Tested the result of the  method "piramide" n = 3.
*The exeptede result is "  ^  \n ^^^ \n^^^^^\n"
*/
    @Test
    public void whenPiramidTwoThenString() {
	Paint paint = new Paint();
	ByteArrayOutputStream out = new ByteArrayOutputStream();
	System.setOut(new PrintStream(out));
	paint.piramid(2);
	assertThat(out.toString(), is(String.format("%1$s%1$s%2$s%1$s%1$s\n
												 %1$s%2$s%2$s%2$s%1$s\n
												 %2$s%2$s%2$s%2$s%2$s\n", 
												 " ", "^")));
    }
}