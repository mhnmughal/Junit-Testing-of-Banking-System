package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PassTimeValidTest {
    PassTimeValid passTimeValid;
    Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        passTimeValid = new PassTimeValid(bank);
    }

    @Test
    void valid_command() {
        boolean actual = passTimeValid.valid("pass 3");
        assertTrue(actual);
    }

    @Test
    void invalid_command_missing_month() {
        boolean actual = passTimeValid.valid("pass");
        assertFalse(actual);
    }

    @Test
    void invalid_command_zero_month() {
        boolean actual = passTimeValid.valid("pass 0");
        assertFalse(actual);
    }

    @Test
    void invalid_command_more_than_sixty_month() {
        boolean actual = passTimeValid.valid("pass 61");
        assertFalse(actual);
    }


    @Test
    void invalid_command_negative_month() {
        boolean actual = passTimeValid.valid("pass -3");
        assertFalse(actual);
    }

}


