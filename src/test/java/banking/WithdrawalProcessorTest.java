package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WithdrawalProcessorTest {

    WithdrawalProcessor withdrawalProcessor;
    CreateProcessor createProcessor;
    DepositProcessor depositProcessor;

    Bank bank;
    String id = "12345678";
    double amount = 100;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        withdrawalProcessor = new WithdrawalProcessor(bank);
        createProcessor = new CreateProcessor(bank);
        depositProcessor = new DepositProcessor(bank);

    }

    @Test
    void process_withdrawal_savings_command() {
        createProcessor.createProcess("create savings 12345678 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        withdrawalProcessor.withdrawalProcess("withdrawal 12345678 400");
        assertEquals(amount, bank.getAccount(id).getBalance());
    }

    @Test
    void process_withdrawal_checking_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        withdrawalProcessor.withdrawalProcess("withdrawal 12345678 400");
        assertEquals(amount, bank.getAccount(id).getBalance());
    }
}