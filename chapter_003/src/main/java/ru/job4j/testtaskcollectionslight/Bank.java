package ru.job4j.testtaskcollectionslight;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


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
     * Add bank customer in {@link Bank#storageAccount}.
     * @param addUser add a bank customer in {@link Bank#storageAccount}.
     */
    public void addUser(final User addUser) {
        if (!storageAccount.containsKey(addUser)) {
            storageAccount.put(addUser, new LinkedList<>());
        }
    }
    /**
     *
     * Delete a bank customer in {@link Bank#storageAccount}.
     * @param deleteUser delete a bank customer in {@link Bank#storageAccount}.
     */
    public void deleteUser(final User deleteUser) {
        if (storageAccount.remove(deleteUser) == null) {
            throw new UserNotExistException("User not exist in storage!");
        }
    }
    /**
     * Add new account for bank {@link Bank#storageAccount}.
     * @param idUser identification key bank customer who needs to add the account.
     * @param addAccount add account.
     */
    public void addAccountToUser(final User idUser, final Account addAccount) {
        if (!storageAccount.containsKey(idUser)) {
            throw new UserNotExistException("Account can not add because user not exist in storage!");
        }
        if (!storageAccount.get(idUser).add(addAccount)) {
            throw new CanNotAddAccountException("Can not adds account to the list accounts the bank customer!");
        }
    }
    /**
     *  Delete  bank customer account {@link Bank#storageAccount}.
     * @param idUser identification key bank customer who needs to delete the account.
     * @param deleteAccount delete account.
     * @throws AccountNotExistException created when account is  not exist in {@link Bank#storageAccount} bank customers.
     */
    public void deleteAccountFromUser(final User idUser, final Account deleteAccount) throws AccountNotExistException {
        if (!storageAccount.containsKey(idUser)) {
            throw new UserNotExistException("User can not delete because not exist in storage!");
        }
        if (!storageAccount.get(idUser).remove(deleteAccount)) {
            throw new AccountNotExistException("Account not exist in the list accounts the bank customer!!!");
        }
    }

    /**
     * Get list accounts for bank customer.
     * @param idUser identification key bank customer for which to get the list of accounts.
     * @return list accounts bank customer.
     */
    public  List<Account> getUserAccounts(final User idUser) {
        final List<Account>  list = storageAccount.get(idUser);
        if (Objects.isNull(list)) {
            throw new UserNotExistException("User not exist in storage!");
        }
        return list;
    }

    /**
     * Transfers money bank customers with one account to other account.
     * @param srcUser The identity of the customer Bank account which the money is transferred.
     * @param srcAccount Account bank customer source money.
     * @param dstUser The identity of the customer Bank accounts which the money is transferred.
     * @param dstAccount Account bank customer recipients money.
     * @param amount Transfer amount.
     * @return True if the operation succeeded, otherwise returns false.
     */
    public boolean transferMoney(final User srcUser, final Account srcAccount,
                                 final User dstUser, final Account dstAccount, final BigDecimal amount) {
        final BigDecimal amountFormat = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
        final List<Account> scrUserListAccount;
        final List<Account> dstUserListAccount;
        boolean resultTransferOperation = false;

        if (storageAccount.containsKey(srcUser) && storageAccount.containsKey(dstUser)) {
            scrUserListAccount = this.getUserAccounts(srcUser);
            dstUserListAccount = this.getUserAccounts(dstUser);
            if (scrUserListAccount.contains(srcAccount) && dstUserListAccount.contains(dstAccount)) {
                int scrUserAccountIndex = scrUserListAccount.indexOf(srcAccount);
                int dstUserAccountIndex = dstUserListAccount.indexOf(dstAccount);
                if (scrUserListAccount.get(scrUserAccountIndex).testsSufficiencyAmountMoneyTransfer(amountFormat)) {
                    scrUserListAccount.set(scrUserAccountIndex,
                            scrUserListAccount.get(scrUserAccountIndex).withdrawalMoneyAccount(amountFormat));
                    dstUserListAccount.set(dstUserAccountIndex,
                            dstUserListAccount.get(dstUserAccountIndex).depositMoneyToAccount(amountFormat));
                    resultTransferOperation = true;
                }
            }
        }
        return resultTransferOperation;
    }
}
