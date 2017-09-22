package ru.job4j.testtaskcollectionslight;

import org.junit.After;
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

    private Bank bank = new Bank();
    private User user;
    private Account account;
    private User user1;
    private Account account1;

    @Before
    public void setUp() {
        user = new User("AAA", "A1");
        account = new Account(new BigDecimal(1000), new BigInteger("111111"));
        user1 = new User("BBB", "B1");
        account1 = new Account(new BigDecimal(100), new BigInteger("222222"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addUserTest() {
        bank.addUser(user);
        List<Account> expected = new LinkedList<>();
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    @Test(expected = UserNotExistException.class)
    public void deleteUserTest() {
        bank.addUser(user);
        bank.deleteUser(user);
        bank.getUserAccounts(user);
    }

    @Test(expected = UserNotExistException.class)
    public void deleteUserUserNotExistExceptionTest() {
        bank.addUser(user);
        bank.deleteUser(user1);
    }

    @Test
    public void addAccountToUserTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        List<Account> expected = new LinkedList<>();
        expected.add(account);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    @Test
    public void deleteAccountFromUserTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        List<Account> expected = new LinkedList<>();
        bank.deleteAccountFromUser(user, account);
        List<Account> result = bank.getUserAccounts(user);
        assertThat(result, is(expected));
    }

    @Test(expected = AccountNotExistException.class)
    public void deleteAccountFromUserAccountNotExistExceptionTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.deleteAccountFromUser(user, account1);
    }

    @Test
    public void getUserAccountUserTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        List<Account> expected = new LinkedList<>();
        expected.add(account1);
        List<Account> result = bank.getUserAccounts(user1);
        assertThat(result, is(expected));
    }

    @Test(expected = UserNotExistException.class)
    public void getUserAccountUserNotExistExceptionTest() {
        bank.addUser(user);
        bank.addAccountToUser(user, account);
        bank.getUserAccounts(user1);
    }

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

    @Test
    public void transferMoneyFalseNotEnoughMoneyInAccountTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user, account, user1, account1, new BigDecimal("10000"))));
    }

    @Test
    public void transferMoneyFalseNoSourceUserTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(new User("1", "1"),
                account, user1, account1, new BigDecimal("11"))));
    }

    @Test
    public void transferMoneyFalseNoDestinationUserTest() {
        bank.addUser(user);
        bank.addUser(user1);
        bank.addAccountToUser(user, account);
        bank.addAccountToUser(user1, account1);
        assertThat(false, is(bank.transferMoney(user,
                account, new User("2", "2"), account1, new BigDecimal("22"))));
    }

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