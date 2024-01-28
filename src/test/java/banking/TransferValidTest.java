package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransferValidTest {
    TransferValid transferValid;
    Bank bank;
    Account account1;
    Account account2;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        transferValid = new TransferValid(bank);
        account1 = new Savings("12345678", 0.2);
        account2 = new Savings("23456789", 0.2);
        bank.addAccount("12345678", account1);
        bank.addAccount("23456789", account2);
        bank.deposit("12345678", 500);
    }

    @Test
    void valid_command() {
        boolean actual = transferValid.valid("transfer 12345678 23456789 300");
        assertTrue(actual);
    }

    @Test
    void invalid_command_missing_id() {
        boolean actual = transferValid.valid("transfer 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_first_id() {
        boolean actual = transferValid.valid("transfer one45678 12345678 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_second_id() {
        boolean actual = transferValid.valid("transfer 12345678 one45678 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_9_digits_id() {
        boolean actual = transferValid.valid("transfer 123456789 23456789 300");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_amount() {
        boolean actual = transferValid.valid("transfer 12345678 23456789 -300");
        assertFalse(actual);
    }

}

