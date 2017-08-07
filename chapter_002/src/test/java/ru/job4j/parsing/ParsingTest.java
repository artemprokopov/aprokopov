package ru.job4j.parsing;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ParsingTest {

   @Test
    public  void checkDateOfferTestWhenString() {
       Calendar calendar = Calendar.getInstance();
        StringBuffer date = new StringBuffer("сегодня, 11:11");
        new Parsing().checkDateOffer(date);
        assertEquals(date.toString(), new StringBuilder(String.format("%s %s %s",
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR))).append(", 11:11").toString());
    }
}