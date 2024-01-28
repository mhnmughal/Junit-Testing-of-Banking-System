package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandValidatorTest {
    CommandValidator commandValidator;
    Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        commandValidator = new CommandValidator(bank);
    }


    @Test
    void valid_command() {
        boolean actual = commandValidator.validate("create savings 12345678 0.2");
        assertTrue(actual);
    }

    @Test
    void invalid_command_missing_account_type() {
        boolean actual = commandValidator.validate("create 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_id() {
        boolean actual = commandValidator.validate("create savings 0.2");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_apr() {
        boolean actual = commandValidator.validate("create savings 12345678");
        assertFalse(actual);
    }

    @Test
    void invalid_command_missing_cd_amount() {
        boolean actual = commandValidator.validate("create cd 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void valid_command_wrong_word_create() {
        boolean actual = commandValidator.validate("reate savings 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void valid_command_wrong_word_account_type() {
        boolean actual = commandValidator.validate("create sssavings 12345678 0.2");
        assertFalse(actual);
    }

    @Test
    void valid_command_wrong_word_account_id() {
        boolean actual = commandValidator.validate("create savings #$%^5678 0.2");
        assertFalse(actual);
    }

    @Test
    void valid_command_wrong_word_account_apr() {
        boolean actual = commandValidator.validate("create cd 12345678 wqw 2000");
        assertFalse(actual);
    }

    @Test
    void valid_command_wrong_word_account_amount() {
        boolean actual = commandValidator.validate("create cd 12345678 0.2 20twoZero");
        assertFalse(actual);
    }

}
