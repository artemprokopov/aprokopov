package ru.job4j.accapplications;

import java.io.IOException;

public class ValidateInput extends ConsoleInput {
    @Override
    public String ask(String str) {
        String result = "";
        try {
           result = super.ask(str);
        } catch (IOException ioe) {
            System.out.println("Input error!!! Enter the correct data.!!!");
        }
        return result;
    }

    @Override
    public int ask(String str, int rangeMin, int rangeMax) throws IOException {
        int result = -1;
        try {
            result = super.ask(str, rangeMin, rangeMax);
            if (result < rangeMin || result > rangeMax) {
                throw new MenuOutException("Input error!!! Enter validate number of  item menu!!!");
            }
        } catch (IOException ioe) {
            System.out.println("Input error!!!");
        }
        return result;
    }
}
