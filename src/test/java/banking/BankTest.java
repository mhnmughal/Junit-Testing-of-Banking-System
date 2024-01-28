package banking;
import banking.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    public static final String myAccountID = "12345678";
    public static final double accountApr = 0.5;
    public static final double balance = 200;
    Bank bank;
    Account myAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        myAccount = new Checking(myAccountID, accountApr);
        bank.addAccount(myAccountID, myAccount);
    }

    @AfterEach
    void tearDown() {
        bank = null;
        myAccount = null;
    }

    @Test
    void bank_has_no_account() {
        assertFalse(bank.getAccounts().isEmpty());
    }

    @Test
    void add_account_to_bank() {
        assertEquals(myAccountID, bank.getAccounts().get(myAccountID).getMyAccountID());
    }

    @Test
    void add_two_account_to_bank() {
        Account myAccount2 = new Savings("87654321", 0.45);
        bank.addAccount("87654321", myAccount2);
        assertEquals(myAccountID, bank.getAccounts().get(myAccountID).getMyAccountID());
        assertEquals("87654321", bank.getAccounts().get("87654321").getMyAccountID());
    }

    @Test
    void retrieve_account_from_bank() {
        assertEquals(myAccountID, bank.getAccounts().get(myAccountID).getMyAccountID());
    }

    @Test
    void deposit_by_id() {
        bank.deposit(myAccountID, balance);
        Account actual = bank.getAccounts().get(myAccountID);
        assertEquals(balance, actual.getBalance());
    }

    @Test
    void withdraw_by_id() {
        bank.deposit(myAccountID, balance);
        bank.withdraw(myAccountID, 100);
        Account actual = bank.getAccounts().get(myAccountID);
        assertEquals(100, actual.getBalance());
    }

    @Test
    void deposit_twice_by_id() {
        bank.deposit(myAccountID, balance);
        bank.deposit(myAccountID, balance);
        Account actual = bank.getAccounts().get(myAccountID);
        assertEquals(2 * balance, actual.getBalance());
    }

    @Test
    void withdraw_twice_by_id() {
        bank.deposit(myAccountID, balance);
        bank.withdraw(myAccountID, 100);
        bank.withdraw(myAccountID, 100);
        Account actual = bank.getAccounts().get(myAccountID);
        assertEquals(0, actual.getBalance());
    }
}
