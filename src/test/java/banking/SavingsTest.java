package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SavingsTest {
    static final double APR = 7;
    String ID = "12345678";
    Savings savings;

    @BeforeEach
    void setUp() {
        savings = new Savings(ID, APR);
    }

    @Test
    void savings_balance() {
        assertEquals(0, savings.getBalance());
    }

    @Test
    void savings_APR() {
        assertEquals(APR, savings.getAccountApr());
    }

    @Test
    void savings_depositing() {
        savings.deposit(500);
        assertEquals(500, savings.getBalance());
    }

    @Test
    void savings_depositing_twice() {
        savings.deposit(500);
        savings.deposit(700);
        assertEquals(1200, savings.getBalance());
    }

    @Test
    void savings_withdrawing() {
        savings.deposit(500);
        savings.withdraw(200);
        assertEquals(300, savings.getBalance());
    }

    @Test
    void savings_withdrawing_twice() {
        savings.deposit(700);
        savings.withdraw(200);
        savings.withdraw(400);
        assertEquals(100, savings.getBalance());
    }

    @Test
    void savings_withdrawing_more_than_balance() {
        savings.deposit(100);
        savings.withdraw(200);
        assertEquals(0, savings.getBalance());
    }

    @Test
    void savings_can_not_withdrawal_twice_in_one_month() {
        savings.deposit(700);
        savings.withdraw(200);
        assertFalse(savings.withdrawIsValid());
        assertEquals(0, savings.withdrawalTimesLeft);
    }

}
