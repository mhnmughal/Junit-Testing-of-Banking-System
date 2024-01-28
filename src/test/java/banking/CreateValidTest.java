package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateValidTest {
    CreateValid createValid;
    Bank bank;
    Account account;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        createValid = new CreateValid(bank);
        account = new Savings("12345678", 0.2);
    }

    @Test
    void valid_command_savings() {
        boolean actual = createValid.valid("create savings 12345678 0.2");
        assertTrue(actual);
    }

    @Test
    void valid_command_checking() {
        boolean actual = createValid.valid("create checking 12345678 0.2");
        assertTrue(actual);
    }

    @Test
    void valid_command_cd() {
        boolean actual = createValid.valid("create cd 12345678 0.2 2000");
        assertTrue(actual);
    }

    @Test
    void invalid_command_checking_account_exists() {
        bank.addAccount("12345678", account);
        boolean actual = createValid.valid("create checking 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_savings_account_exists() {
        bank.addAccount("12345678", account);
        boolean actual = createValid.valid("create savings 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_cd_account_exists() {
        bank.addAccount("12345678", account);
        boolean actual = createValid.valid("create cd 12345678 0.2 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_checking_apr_greater_than_ten() {
        boolean actual = createValid.valid("create checking 12345678 12");
        assertFalse(actual);
    }

    @Test
    void invalid_command_savings_apr_greater_than_ten() {
        boolean actual = createValid.valid("create savings 12345678 12");
        assertFalse(actual);
    }

    @Test
    void invalid_command_cd_apr_greater_than_ten() {
        boolean actual = createValid.valid("create cd 12345678 12 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_create_cd_negative_amount() {
        boolean actual = createValid.valid("create cd 12345678 0.2 -2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_create_cd_amount_less_than_minimum() {
        boolean actual = createValid.valid("create cd 12345678 0.2 500");
        assertFalse(actual);
    }

    @Test
    void invalid_command_create_cd_amount_greater_than_maximum() {
        boolean actual = createValid.valid("create cd 12345678 0.2 50000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_savings_apr() {
        boolean actual = createValid.valid("create savings 12345678 -0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_checking_apr() {
        boolean actual = createValid.valid("create checking 12345678 -0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_negative_cd_apr() {
        boolean actual = createValid.valid("create cd 12345678 -0.2 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_savings_id() {
        boolean actual = createValid.valid("create savings one45678 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_checking_id() {
        boolean actual = createValid.valid("create checking one45678 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_wrong_cd_id() {
        boolean actual = createValid.valid("create cd one45678 0.2 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_savings_id() {
        boolean actual = createValid.valid("create savings 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_checking_id() {
        boolean actual = createValid.valid("create checking 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_cd_id() {
        boolean actual = createValid.valid("create cd 0.2 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_savings_apr() {
        boolean actual = createValid.valid("create savings 12345678");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_checking_apr() {
        boolean actual = createValid.valid("create checking 12345678");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_cd_apr() {
        boolean actual = createValid.valid("create cd 12345678 2000");
        assertFalse(actual);
    }

    @Test
    void invalid_command_savings_9_digits_id() {
        boolean actual = createValid.valid("create savings 123456789 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_checking_9_digits_id() {
        boolean actual = createValid.valid("create checking 123456789 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_cd_9_digits_id() {
        boolean actual = createValid.valid("create cd 123456789 0.2 2000");
        assertFalse(actual);
    }

}
