package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckingTest {
    static final double APR = 7;
    String ID = "12345678";
    Checking checking;

    @BeforeEach
    void setUp() {
        checking = new Checking(ID, APR);
    }

    @Test
    void checking_balance() {
        assertEquals(0, checking.getBalance());
    }

    @Test
    void checking_APR() {
        assertEquals(APR, checking.getAccountApr());
    }

    @Test
    void checking_depositing() {
        checking.deposit(500);
        assertEquals(500, checking.getBalance());
    }

    @Test
    void checking_depositing_twice() {
        checking.deposit(500);
        checking.deposit(700);
        assertEquals(1200, checking.getBalance());
    }

    @Test
    void checking_withdrawing() {
        checking.deposit(500);
        checking.withdraw(200);
        assertEquals(300, checking.getBalance());
    }

    @Test
    void checking_withdrawing_twice() {
        checking.deposit(700);
        checking.withdraw(200);
        checking.withdraw(400);
        assertEquals(100, checking.getBalance());
    }

    @Test
    void checking_withdrawing_more_than_balance() {
        checking.deposit(100);
        checking.withdraw(200);
        assertEquals(0, checking.getBalance());
    }
}
