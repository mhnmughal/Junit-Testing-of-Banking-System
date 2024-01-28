package banking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    static final double APR = 7;
    Account mySavingsAccount;
    Account myCheckingAccount;
    Account myCDAccount;
    String ID = "12345678";

    @BeforeEach
    void setUp() {
        myCheckingAccount = new Checking(ID, APR);
        mySavingsAccount = new Savings(ID, APR);
        myCDAccount = new CD(ID, APR, 100);
    }

    @Test
    void checking_depositing() {
        myCheckingAccount.deposit(500);
        assertEquals(500, myCheckingAccount.getBalance());
    }

    // Add more test cases for different scenarios

    @Test
    void check_checking_APR() {
        assertEquals(APR, myCheckingAccount.getAccountApr());
    }

    @Test
    void check_savings_APR() {
        assertEquals(APR, mySavingsAccount.getAccountApr());
    }

    @Test
    void check_cd_APR() {
        assertEquals(APR, myCDAccount.getAccountApr());
    }
}
