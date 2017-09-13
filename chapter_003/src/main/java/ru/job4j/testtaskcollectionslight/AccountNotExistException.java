package ru.job4j.testtaskcollectionslight;

/**
 * Class exception AccountNotExistException.
 * Exception generates when account not exist in list accounts bank customers.
 * @author Artem Prokopov
 * @since 13/09/2017
 * @version 1.0
 */

public class AccountNotExistException extends RuntimeException {
    /**
     * Constructor.
     * @param stringException string message for identification Exception.
     */
    public AccountNotExistException(String stringException) {
        super(stringException);
    }
}
