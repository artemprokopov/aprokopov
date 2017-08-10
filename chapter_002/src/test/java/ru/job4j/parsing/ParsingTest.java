package ru.job4j.parsing;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ParsingTest {

    private String[] test;
    private String[] exepected;

    {
        test = new String[]{"21 янв 17, 11:11", "21 фев 17, 11:11", "21 мар 17, 11:11",
                "21 апр 17, 11:11", "21 май 17, 11:11", "21 июн 17, 11:11",
                "21 июл 17, 11:11", "21 авг 17, 11:11", "21 сен 17, 11:11",
                "21 окт 17, 11:11", "21 ноя 17, 11:11", "21 дек 17, 11:11"};
        exepected = new String[]{"21 1 17, 11:11", "21 2 17, 11:11", "21 3 17, 11:11",
                "21 4 17, 11:11", "21 5 17, 11:11", "21 6 17, 11:11",
                "21 7 17, 11:11", "21 8 17, 11:11", "21 9 17, 11:11",
                "21 10 17, 11:11", "21 11 17, 11:11", "21 12 17, 11:11"};
    }

   @Test
    public  void checkDateOfferTestWhenStringSegodnyaThenTrue() {
       Calendar calendar = Calendar.getInstance();
        String date = new String("сегодня, 11:11");
        boolean ex = new Parsing().checkDateOffer(date);
        assertEquals(true, ex);
    }

    @Test
    public  void checkDateOfferTestWhenStringVcheraThenTrue() {
        Calendar calendar = Calendar.getInstance();
        String date = new String("вчера, 11:11");
        boolean ex = new Parsing().checkDateOffer(date);

        assertEquals(true, ex);
    }

    @Test
    public  void checkDateOfferNewTestWhenStringDataThenTrue() {
        for (int i = 0; i < 12; i++) {
            String date = new String(test[i]);
            boolean ex = new Parsing().checkDateOffer(date);
            assertEquals(true, ex);
        }
    }

    @Test
    public  void checkDateOfferNewTestWhenStringSegodnyaThenTrue() {
        Calendar calendar = Calendar.getInstance();
        String date = new String(" сегодня , 11:11");
        boolean ex = new Parsing().checkDateOfferNew(date);
        assertEquals(true, ex);
    }

    @Test
    public  void checkDateOfferNewTestWhenStringVcheraThenTrue() {
        Calendar calendar = Calendar.getInstance();
        String date = new String("вчера, 11:11");
        boolean ex = new Parsing().checkDateOfferNew(date);
        calendar.add(Calendar.DATE, -1);
        assertEquals(true, ex);
    }

    @Test
    public  void checkDateOfferTestWhenStringDataThenTrue() {
        for (int i = 0; i < 12; i++) {
            String date = new String(test[i]);
            boolean ex = new Parsing().checkDateOfferNew(date);
            assertEquals(true, ex);
        }
    }
}