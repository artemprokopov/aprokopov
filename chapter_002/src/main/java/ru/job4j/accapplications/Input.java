package ru.job4j.accapplications;

/**
 * Created by Prokopov on 10.05.2017.
 */
public interface Input {
    /**
     *
     * @param question параметр запроса.
     * @return String
     */
    String ask(String question);
    int ask();
}
