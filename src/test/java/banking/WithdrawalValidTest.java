package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WithdrawalValidTest {
    WithdrawalValid withdrawalValid;
    PassTimeValid passTimeValid;
    Bank bank;
    Account savingsAccount;
    Account cdAccount;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        withdrawalValid = new WithdrawalValid(bank);
        passTimeValid = new PassTimeValid(bank);
        savingsAccount = new Savings("12345678", 0.2);
        bank.addAccount("12345678", savingsAccount);
        bank.deposit("12345678", 500);

        cdAccount = new CD("23456789", 2.1, 2000);
        bank.addAccount("23456789", cdAccount);
    }

    @Test
    void valid_command() {
        boolean actual = withdrawalValid.valid("withdrawal 12345678 300");
        assertTrue(actual);
    }

    @Test
    void invalid_command_missing_id() {
        boolean actual = withdrawalValid.valid("withdrawal 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_id() {
        boolean actual = withdrawalValid.valid("withdrawal one45678 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_9_digits_id() {
        boolean actual = withdrawalValid.valid("withdrawal 123456789 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_amount() {
        boolean actual = withdrawalValid.valid("withdrawal 12345678 -300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_over_savings_max_amount() {
        boolean actual = withdrawalValid.valid("withdrawal 12345678 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_withdrawal_twice_in_one_month_in_savings_account() {
        savingsAccount.withdraw(200);
        boolean actual = withdrawalValid.valid("withdrawal 12345678 200");
        assertFalse(actual);
    }

    @Test
    void valid_command_withdrawal_for_cd_account() {
        bank.passTime(12);
        boolean actual = withdrawalValid.valid("withdrawal 23456789 2175.098098315957");
        assertTrue(actual);
    }


    @Test
    void invalid_command_withdrawal_not_over_12_months_in_cd_account() {
        bank.passTime(1);
        boolean actual = withdrawalValid.valid("withdrawal 23456789 2014.0367928937578");
        assertFalse(actual);
    }

    @Test
    void invalid_command_withdrawal_less_than_the_balance_in_cd_account() {
        bank.passTime(12);
        boolean actual = withdrawalValid.valid("withdrawal 23456789 2000");
        assertFalse(actual);
    }

}
