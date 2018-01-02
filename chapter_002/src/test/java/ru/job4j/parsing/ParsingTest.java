package ru.job4j.parsing;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;
import static org.junit.Assert.assertEquals;

/**
 * Тесты для решения задачи предложенной Петром в HipChat.
 * @author Artem Prokopov
 * @since 11.08.2017
 * @version 1.0
 */
@Ignore
public class ParsingTest {
    /**
     * Масив задающий тестовые значения.
     */
    private String[] test;
    /**
     * Массив строк содержащий ожидаемые значения.
     */
    @SuppressWarnings("unused")
	private String[] exepected;

    /**
     * Блок инициализации массивов.
     */
    {
        test = new String[]{"21 янв 18, 11:11", "21 фев 18, 11:11", "21 мар 18, 11:11",
                "21 апр 18, 11:11", "21 май 18, 11:11", "21 июн 18, 11:11",
                "21 июл 18, 11:11", "21 авг 18, 11:11", "21 сен 18, 11:11",
                "21 окт 18, 11:11", "21 ноя 18, 11:11", "21 дек 18, 11:11"};
        exepected = new String[]{"21 1 18, 11:11", "21 2 18, 11:11", "21 3 18, 11:11",
                "21 4 18, 11:11", "21 5 18, 11:11", "21 6 18, 11:11",
                "21 7 18, 11:11", "21 8 18, 11:11", "21 9 18, 11:11",
                "21 10 18, 11:11", "21 11 18, 11:11", "21 12 18, 11:11"};
    }

    /**
     * Тест проверяет исходный метод {@link Parsing#checkDateOffer(String)} для значения "сегодня, 11:11".
     */
   @Test
    public  void checkDateOfferTestWhenStringSegodnyaThenTrue() {
        String date = new String("сегодня, 11:11");
        boolean ex = new Parsing().checkDateOffer(date);
        assertEquals(true, ex);
    }

    /**
     * Тест проверяет исходный метод {@link Parsing#checkDateOffer(String)} для значения "вчера, 11:11".
     */
    @Test
    public  void checkDateOfferTestWhenStringVcheraThenTrue() {
        String date = new String("вчера, 11:11");
        boolean ex = new Parsing().checkDateOffer(date);

        assertEquals(true, ex);
    }

    /**
     * Тест проверяет исходный метод {@link Parsing#checkDateOffer(String)} для значения
     * от "21 янв 17, 11:11" до "21 дек 17, 11:11".
     */
    @Test
    public  void checkDateOfferNewTestWhenStringDataThenTrue() {
        for (int i = 0; i < 12; i++) {
            String date = new String(test[i]);
            boolean ex = new Parsing().checkDateOffer(date);
            assertEquals(true, ex);
        }
    }

    /**
     * Тест проверяет новый метод {@link Parsing#checkDateOfferNew(String)} для значения "сегодня, 11:11".
     */
    @Test
    public  void checkDateOfferNewTestWhenStringSegodnyaThenTrue() {
        String date = new String("сегодня , 11:11");
        boolean ex = new Parsing().checkDateOfferNew(date);
        assertEquals(true, ex);
    }

    /**
     * Тест проверяет новый метод {@link Parsing#checkDateOfferNew(String)} для значения "вчера, 11:11".
     */
    @Test
    public  void checkDateOfferNewTestWhenStringVcheraThenTrue() {
        Calendar calendar = Calendar.getInstance();
        String date = new String("вчера, 11:11");
        boolean ex = new Parsing().checkDateOfferNew(date);
        calendar.add(Calendar.DATE, -1);
        assertEquals(true, ex);
    }

    /**
     * Тест проверяет новый метод {@link Parsing#checkDateOfferNew(String)} для значения
     * от "21 янв 17, 11:11" до "21 дек 17, 11:11".
     */
    @Test
    public  void checkDateOfferTestWhenStringDataThenTrue() {
        for (int i = 0; i < 12; i++) {
            String date = new String(test[i]);
            boolean ex = new Parsing().checkDateOfferNew(date);
            assertEquals(true, ex);
        }
    }
}