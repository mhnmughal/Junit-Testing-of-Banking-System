package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CDTest {
    static final double APR = 7;
    String ID = "12345678";
    CD cd;

    @BeforeEach
    void setUp() {
        cd = new CD(ID, APR, 0);
    }

    @Test
    void cd_balance() {
        assertEquals(0, cd.getBalance());

    }

    @Test
    void cd_APR() {
        assertEquals(APR, cd.getAccountApr());
    }

    @Test
    void cd_depositing() {
        cd.deposit(500);
        assertEquals(500, cd.getBalance());
    }

    @Test
    void cd_depositing_twice() {
        cd.deposit(500);
        cd.deposit(700);
        assertEquals(1200, cd.getBalance());
    }

    @Test
    void cd_withdrawing() {
        cd.deposit(500);
        cd.withdraw(200);
        assertEquals(300, cd.getBalance());
    }

    @Test
    void cd_withdrawing_twice() {
        cd.deposit(700);
        cd.withdraw(200);
        cd.withdraw(400);
        assertEquals(100, cd.getBalance());
    }

    @Test
    void cd_withdrawing_more_than_balance() {
        cd.deposit(100);
        cd.withdraw(200);
        assertEquals(0, cd.getBalance());
    }
}
