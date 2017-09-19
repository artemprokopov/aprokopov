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
    /**
     * Tests the sufficiency of the amount of money on translation.
     * @param testSum the amount of the transfer.
     */
    public boolean testsSufficiencyAmountMoneyTransfer (BigDecimal testSum) {
        testSum = testSum.setScale(2, BigDecimal.ROUND_HALF_UP);
        int compare = this.value.compareTo(testSum);
        return  compare >= 0;
    }

    /**
     *  Increases the account for the amount of money transferred.
     * @param depositMoney transferred money.
     * @return account with increased funds.
     */
    public Account depositMoneyToAccount (BigDecimal depositMoney) {
        depositMoney = depositMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
        return new Account(this.value.add(depositMoney), requisites);
    }
    /**
     *  Decreases the account for the amount of money transferred.
     * @param withdrawalMoney transferred money.
     * @return account with decreased funds.
     */
    public Account withdrawalMoneyAccount (BigDecimal withdrawalMoney) {
        withdrawalMoney = withdrawalMoney.setScale(2, BigDecimal.ROUND_HALF_UP);
        return new Account(this.value.subtract(withdrawalMoney), requisites);
    }
    /**
     * Overridable method equals.
     * @param o the object with which to compare.
     * @return true if objects equals and false if the objects not equals.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }


        Account account = (Account) o;
        return requisites.equals(account.requisites);
    }

    /**
     * Overridable method hashcode.
     * @return hashcode for the object.
     */
    @Override
    public int hashCode() {
        int result = 31 * requisites.hashCode();
        return result;
    }
}
