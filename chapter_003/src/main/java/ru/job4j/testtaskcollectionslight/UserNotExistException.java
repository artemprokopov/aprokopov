package ru.job4j.testtaskcollectionslight;

/**
 * The   class is created when the method can not deleted user from storage list.
 * @author Artem Prokopov
 * @since 19/09/2017
 * @version 1.0
 */
public class UserNotExistException extends RuntimeException {
    /**
     * Constructor.
     * @param s string message for identification Exception.9
     */
    public UserNotExistException(String s) {
        super(s);
    }
}
