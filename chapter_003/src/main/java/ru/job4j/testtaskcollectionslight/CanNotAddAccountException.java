package ru.job4j.testtaskcollectionslight;

/**
 * The class Exception is created when the method can not add a account bank in the account list.
 * @author Artem Prokopov
 * @since 15/09/2017
 * @version 1.0
 */
public class CanNotAddAccountException extends RuntimeException {
    /**
     * Constructor.
     * @param s string message for identification Exception.9
     */
    public CanNotAddAccountException(String s) {
        super(s);
    }
}