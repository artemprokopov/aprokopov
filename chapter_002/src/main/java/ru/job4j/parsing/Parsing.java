package ru.job4j.parsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parsing {


    /**
     *
     * @param date
     * @return
     */
    public boolean checkDateOffer(String date) {
        //Добавил не объявленную переменную
        long lastStart = 0;
        boolean result = false;
        SimpleDateFormat formatForDate = new SimpleDateFormat("dd MM yy, hh:mm");
        StringBuffer formatDate = new StringBuffer(date);
        Calendar calendar = Calendar.getInstance();

        if (formatDate.indexOf("сегодня") != -1) {
            formatDate.replace(formatDate.indexOf("сегодня"),
                    formatDate.indexOf(","),
                    String.format("%s %s %s",
                            calendar.get(Calendar.DAY_OF_MONTH),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.YEAR)));
        } else if (formatDate.indexOf("вчера") != -1) {
            calendar.add(Calendar.DATE, -1);
            formatDate.replace(formatDate.indexOf("вчера"),
                    formatDate.indexOf(","),
                    String.format("%s %s %s",
                            calendar.get(Calendar.DAY_OF_MONTH),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.YEAR)));
        } else {
            if (formatDate.indexOf("янв") != -1) {
                formatDate.replace(formatDate.indexOf("янв"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("янв")), "1");
            } else if (formatDate.indexOf("фев") != -1) {
                formatDate.replace(formatDate.indexOf("фев"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("фев")), "2");
            } else if (formatDate.indexOf("мар") != -1) {
                formatDate.replace(formatDate.indexOf("мар"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("мар")), "3");
            } else if (formatDate.indexOf("апр") != -1) {
                formatDate.replace(formatDate.indexOf("апр"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("апр")), "4");
            } else if (formatDate.indexOf("май") != -1) {
                formatDate.replace(formatDate.indexOf("май"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("май")), "5");
            } else if (formatDate.indexOf("июн") != -1) {
                formatDate.replace(formatDate.indexOf("июн"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("июн")), "6");
            } else if (formatDate.indexOf("июл") != -1) {
                formatDate.replace(formatDate.indexOf("июл"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("июл")), "7");
            } else if (formatDate.indexOf("авг") != -1) {
                formatDate.replace(formatDate.indexOf("авг"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("авг")), "8");
            } else if (formatDate.indexOf("сен") != -1) {
                formatDate.replace(formatDate.indexOf("сен"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("сен")), "9");
            } else if (formatDate.indexOf("окт") != -1) {
                formatDate.replace(formatDate.indexOf("окт"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("окт")), "10");
            } else if (formatDate.indexOf("ноя") != -1) {
                formatDate.replace(formatDate.indexOf("ноя"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("ноя")), "11");
            } else if (formatDate.indexOf("дек") != -1) {
                formatDate.replace(formatDate.indexOf("дек"),
                        formatDate.indexOf(" ",
                                formatDate.indexOf("дек")), "12");
            }
        }
        try {
            long dateOffer = formatForDate.parse(formatDate.toString()).getTime();
            long startYear = formatForDate.parse(String.format("%s %s %s, 00:00", "01", "01", calendar.get(Calendar.YEAR))).getTime();
            if ((lastStart == 0 && startYear < dateOffer) || (lastStart > 0 && dateOffer > lastStart)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    private final Calendar calendar = Calendar.getInstance();
    private final String dateStrToday;
    private final String dateStrYesterday;

    {
        dateStrToday = String.format("%s %s %s",
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DATE, -1);
        dateStrYesterday = String.format("%s %s %s",
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR));
    }

    private final HashMap<String, String> stringMap = new HashMap<>();
    {
        stringMap.put("янв", " 1 ");
        stringMap.put("фев", " 2 ");
        stringMap.put("мар", " 3 ");
        stringMap.put("апр", " 4 ");
        stringMap.put("май", " 5 ");
        stringMap.put("июн", " 6 ");
        stringMap.put("июл", " 7 ");
        stringMap.put("авг", " 8 ");
        stringMap.put("сен", " 9 ");
        stringMap.put("окт", " 10 ");
        stringMap.put("ноя", " 11 ");
        stringMap.put("дек", " 12 ");
        stringMap.put("сегодня", dateStrToday);
        stringMap.put("вчера", dateStrYesterday);
    }

    public boolean checkDateOfferNew(String date) {

        long lastStart = 0;
        boolean result = false;
        SimpleDateFormat formatForDate = new SimpleDateFormat("dd MM yy, hh:mm");
        StringBuilder formatDate = new StringBuilder();


        String[] stringSplit = date.trim().split("[,\\s]+");
        if (stringMap.containsKey(stringSplit[0])) {
            formatDate.append(stringMap.get(stringSplit[0]))
                    .append(", ")
                    .append(stringSplit[1]);
        } else {
            formatDate.append(stringSplit[0])
                    .append(stringMap.get(stringSplit[1]))
                    .append(stringSplit[2])
                    .append(", ")
                    .append(stringSplit[3]);
        }
        try {
            long dateOffer = formatForDate.parse(formatDate.toString()).getTime();
            long startYear = formatForDate.parse(String.format("%s %s %s, 00:00", "01", "01", calendar.get(Calendar.YEAR))).getTime();
            result = lastStart >= 0 && dateOffer > startYear;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;

    }
}
