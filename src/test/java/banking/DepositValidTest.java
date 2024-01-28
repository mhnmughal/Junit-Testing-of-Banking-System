package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DepositValidTest {
    DepositValid depositValid;
    Bank bank;
    Account account;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        depositValid = new DepositValid(bank);
        account = new Savings("12345678", 0.2);
        bank.addAccount("12345678", account);
    }

    @Test
    void valid_command() {

        boolean actual = depositValid.valid("deposit 12345678 300");
        assertTrue(actual);
    }

    @Test
    void invalid_command_missing_id() {
        boolean actual = depositValid.valid("deposit 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_id() {
        boolean actual = depositValid.valid("deposit one45678 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_9_digits_id() {
        boolean actual = depositValid.valid("deposit 123456789 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_amount() {
        boolean actual = depositValid.valid("deposit 12345678 -300");
        assertFalse(actual);
    }


}
