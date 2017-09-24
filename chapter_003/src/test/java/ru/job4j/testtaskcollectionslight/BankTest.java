package ru.job4j.testtaskcollectionslight;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test for class Bank.
 * @author Artem Prokopov
 * @since 21/009/2017
 */

public class BankTest {
    /**
     *  Class field Bank for tests.
     */
    private Bank bank = new Bank();
    /**
     * Class field User for tests.
     */
    private User user;
    /**
     * Class field Account for tests.
     */
    private Account account;
    /**
     * Class field User for tests.
     */
    private User user1;
    /**
     * Class field Account for tests.
     */
    private Account account1;

    /**
     * Initialize class fields for tests.
     */
    @Before
    public void setUp() {
        user = new User("AAA", "A1");
        account = new Account(new BigDecimal(1000), new BigInteger("111111"));
        user1 = new User("BBB", "B1");
        account1 = new Account(new BigDecimal(100), new BigInteger("222222"));
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#addUser(User)}.
     */
    @Test
    public void addUserTest() {
        bank.addUser(user);
        List<Account> expected = new LinkedList<>();
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#deleteUser(User)}.
     * expected exception {@link ru.job4j.testtaskcollectionslight.UserNotExistException}
     */
    @Test(expected = UserNotExistException.class)
    public void deleteUserTest() {
        bank.addUser(user);
        bank.deleteUser(user);
        bank.getUserAccounts(user);
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#deleteUser(User)}.
     * expected exception {@link ru.job4j.testtaskcollectionslight.UserNotExistException}
     */
    @Test(expected = UserNotExistException.class)
    public void deleteUserUserNotExistExceptionTest() {
        bank.addUser(user);
        bank.deleteUser(user1);
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#addAccountToUser(User, Account)}.
     */
    @Test
    public void addAccountToUserTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        List<Account> expected = new LinkedList<>();
        expected.add(account);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#deleteAccountFromUser(User, Account)}.
     */
    @Test
    public void deleteAccountFromUserTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        List<Account> expected = new LinkedList<>();
        bank.deleteAccountFromUser(user, account);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#deleteAccountFromUser(User, Account)}.
     * expected exception {@link ru.job4j.testtaskcollectionslight.AccountNotExistException}
     */
    @Test(expected = AccountNotExistException.class)
    public void deleteAccountFromUserAccountNotExistExceptionTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.deleteAccountFromUser(user, account1);
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#getUserAccounts(User)}.
     */
    @Test
    public void getUserAccountTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        List<Account> expected = new LinkedList<>();
        expected.add(account1);
        List<Account> result = bank.getUserAccounts(user1);
        assertThat(result, is(expected));
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#getUserAccounts(User)}.
     * expected exception {@link ru.job4j.testtaskcollectionslight.UserNotExistException}
     */
    @Test(expected = UserNotExistException.class)
    public void getUserAccountUserNotExistExceptionTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.getUserAccounts(user1);
    }

    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 100 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end success
     */
    @Test
    public void transferMoneyTrueTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(true, is(bank.transferMoney(user, account, user1, account1, new BigDecimal("100"))));
        List<Account> result = bank.getUserAccounts(user);
        List<Account> result1 = bank.getUserAccounts(user1);
        Account expected = new Account(new BigDecimal(900), new BigInteger("111111"));
        Account expected1 = new Account(new BigDecimal(200), new BigInteger("222222"));
        assertEquals(true, result.get(0).equals(expected));
        assertEquals(true, result1.get(0).equals(expected1));
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 10000 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end fails, because in account {@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * not enough money for transfer.
     */
    @Test
    public void transferMoneyFalseNotEnoughMoneyInAccountTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user, account, user1, account1, new BigDecimal("10000"))));
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 10000 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end fails, because source user for transferring money  not exist in the storage account.
     */
    @Test
    public void transferMoneyFalseNoSourceUserTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(new User("1", "1"),
                account, user1, account1, new BigDecimal("11"))));
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 10000 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end fails, because destination user for transferring money  not exist in the storage account.
     */
    @Test
    public void transferMoneyFalseNoDestinationUserTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user,
                account, new User("2", "2"), account1, new BigDecimal("22"))));
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 10000 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end fails, because source user account  for transferring money  not exist in the storage account.
     */
    @Test
    public void transferMoneyFalseNoSourceAccountTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user,
                new Account(new BigDecimal("2"), new BigInteger("22")), user1, account1,
                new BigDecimal("11"))));
    }
    /**
     * Test method {@link ru.job4j.testtaskcollectionslight.Bank#transferMoney(User, Account, User, Account, java.math.BigDecimal)}.
     * Transfer amount 10000 moneys with user{@link ru.job4j.testtaskcollectionslight.BankTest#user} account{@link ru.job4j.testtaskcollectionslight.BankTest#account}
     * to user{@link ru.job4j.testtaskcollectionslight.BankTest#user1} account {@link ru.job4j.testtaskcollectionslight.BankTest#account1}.
     * Expected operation end fails, because destination user account  for transferring money  not exist in the storage account.
     */
    @Test
    public void transferMoneyFalseNoDestinationAccountTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user,
                account, user1, new Account(new BigDecimal("1"), new BigInteger("1")),
                new BigDecimal("11"))));
    }

}