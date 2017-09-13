package ru.job4j.testtaskcollectionslight;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Class {@link Account} saves amount of money and bank account details.
 * @author Arterm Prokopov
 * @since 13/09/2017
 * @version 1.0
 */
public class Account {
    /**
     * Field saves amount of money on the account.
     */
    private final BigDecimal value;

    /**
     * Field saves bank account details.
     */
    private final BigInteger requisites;

    /**
     * Constructor.
     * @param initValue initialize the field {@link Account#value}
     * @param initRequisites initialize the field {@link Account#requisites}
     */
    public Account(BigDecimal initValue, BigInteger initRequisites) {
        this.value = initValue.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.requisites = initRequisites;
    }
}
