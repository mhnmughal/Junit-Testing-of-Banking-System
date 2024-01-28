package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateProcessorTest {
    CreateProcessor createProcessor;
    Bank bank;
    String id = "12345678";
    double apr = 0.2;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        createProcessor = new CreateProcessor(bank);
    }

    @Test
    void process_create_savings_command() {
        createProcessor.createProcess("create savings 12345678 0.2");
        assertEquals(id, bank.getAccount(id).getMyAccountID());
        assertEquals(apr, bank.getAccount(id).getAccountApr());
    }

    @Test
    void process_create_checking_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        assertEquals(id, bank.getAccount(id).getMyAccountID());
        assertEquals(apr, bank.getAccount(id).getAccountApr());
    }

    @Test
    void process_create_cd_command() {
        createProcessor.createProcess("create cd 12345678 0.2 500");
        assertEquals(id, bank.getAccount(id).getMyAccountID());
        assertEquals(apr, bank.getAccount(id).getAccountApr());
    }

}
