package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositProcessorTest {
    DepositProcessor depositProcessor;
    CreateProcessor createProcessor;
    Bank bank;
    String id = "12345678";
    double amount = 500;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        depositProcessor = new DepositProcessor(bank);
        createProcessor = new CreateProcessor(bank);

    }

    @Test
    void process_deposit_savings_command() {
        createProcessor.createProcess("create savings 12345678 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        assertEquals(amount, bank.getAccount(id).getBalance());
    }

    @Test
    void process_deposit_checking_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        assertEquals(amount, bank.getAccount(id).getBalance());
    }
}

