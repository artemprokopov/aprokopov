package ru.job4j.testtaskcollectionslight;

import java.util.Objects;

/**
 * Class {@link User} saves name and data passport client bank.
 * @author Artem Prokopov
 * @since 13/09/2017
 * @version 1.0
 */
public class User {
    /**
     * Field saves name client bank.
     */
    private final String name;
    /**
     * Field saves data passport client bank.
     */
    private final String passport;

    /**
     * Constructor.
     * @param initName initialize the field {@link User#name}.
     * @param initPassport  initialize the field passport {@link User#passport}.
     */
    public User(String initName, String initPassport) {
        this.name = initName;
        this.passport = initPassport;
    }

    /**
     * Overridable method equals.
     * @param o the object with which to compare.
     * @return true if objects equals and false if the objects not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (!name.equals(user.name)) {
            return false;
        }
        return passport.equals(user.passport);
    }

    /**
     * Overridable method hashcode.
     * @return hashcode for the object.
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + passport.hashCode();
        return result;
    }
}
