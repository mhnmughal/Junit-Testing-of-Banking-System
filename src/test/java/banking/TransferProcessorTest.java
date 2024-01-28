package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransferProcessorTest {
    CreateProcessor createProcessor;
    DepositProcessor depositProcessor;
    TransferProcessor transferProcessor;

    Bank bank;
    String firstAccountID = "12345678";
    String secondAccountID = "23456789";
    double transferAmount = 100;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        createProcessor = new CreateProcessor(bank);
        depositProcessor = new DepositProcessor(bank);
        transferProcessor = new TransferProcessor(bank);

    }

    @Test
    void process_transfer_from_savings_to_savings_command() {
        createProcessor.createProcess("create savings 12345678 0.2");
        createProcessor.createProcess("create savings 23456789 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        transferProcessor.transferProcess("transfer 12345678 23456789 500");
        assertEquals(0, bank.getAccount(firstAccountID).getBalance());
        assertEquals(500, bank.getAccount(secondAccountID).getBalance());
    }

    @Test
    void process_transfer_from_checking_to_checking_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        createProcessor.createProcess("create checking 23456789 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        transferProcessor.transferProcess("transfer 12345678 23456789 500");
        assertEquals(0, bank.getAccount(firstAccountID).getBalance());
        assertEquals(500, bank.getAccount(secondAccountID).getBalance());
    }

    @Test
    void process_transfer_from_savings_to_checking_command() {
        createProcessor.createProcess("create savings 12345678 0.2");
        createProcessor.createProcess("create checking 23456789 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        transferProcessor.transferProcess("transfer 12345678 23456789 500");
        assertEquals(0, bank.getAccount(firstAccountID).getBalance());
        assertEquals(500, bank.getAccount(secondAccountID).getBalance());
    }

    @Test
    void process_transfer_from_checking_to_savings_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        createProcessor.createProcess("create savings 23456789 0.2");
        depositProcessor.depositProcess("deposit 12345678 500");
        transferProcessor.transferProcess("transfer 12345678 23456789 500");
        assertEquals(0, bank.getAccount(firstAccountID).getBalance());
        assertEquals(500, bank.getAccount(secondAccountID).getBalance());
    }
}