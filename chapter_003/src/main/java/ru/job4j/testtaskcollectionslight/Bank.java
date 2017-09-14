package ru.job4j.testtaskcollectionslight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for operations on a bank account.
 * @author Artem Prokopov
 * @since 13/09/2017
 * @version 1.0
 */

public class Bank {
    /**
     * Field saves  bank clients account.
     */
    private final Map<User, List<Account>> storageAccount = new HashMap<>();

    /**
     * Add bank customer in {@link Bank#storageAccount}
     * @param addUser add a bank customer in {@link Bank#storageAccount}.
     */
    public void addUser(User addUser) {

    }
    /**
     * Delete a bank customer in {@link Bank#storageAccount}
     * @param deleteUser delete a bank customer in {@link Bank#storageAccount}.
     */
    public void deleteUser(User deleteUser) {

    }

    /**
     * Add new account for bank {@link Bank#storageAccount}.
     * @param idUser identification key bank customer who needs to add the account.
     * @param addAccount add account.
     */
    public void addAccountToUser(User idUser, Account addAccount) {

    }

    /**
     *  Delete  bank customer account {@link Bank#storageAccount}.
     * @param idUser identification key bank customer who needs to delete the account.
     * @param deleteAccount delete account.
     */
    public void deleteAccountFromUser(User idUser, Account deleteAccount) throws AccountNotExistException {
            if (!storageAccount.get(idUser).remove(deleteAccount)) {
                throw new AccountNotExistException("Account not exist in the list accounts the bank customer!!!");
            }
    }

    /**
     * Get list accounts for bank customer.
     * @param idUser identification key bank customer for which to get the list of accounts.
     * @return list accounts bank customer.
     */
    public List<Account> getUserAccounts (User idUser) {
        return storageAccount.get(idUser);
    }

    /**
     *git pul
     * @param srcUser
     * @param srcAccount
     * @param dstUser
     * @param dstAccount
     * @param amount
     * @return
     */
    public boolean transferMoney (User srcUser, Account srcAccount, User dstUser, Account dstAccount, BigDecimal amount) {
        amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        boolean resultTransferOperation = false;
        return resultTransferOperation;
    }
}
