package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassTimeProcessorTest {
    PassTimeProcessor passTimeProcessor;
    CreateProcessor createProcessor;
    DepositProcessor depositProcessor;

    Bank bank;
    String id = "12345678";


    @BeforeEach
    void setUp() {
        bank = new Bank();
        passTimeProcessor = new PassTimeProcessor(bank);
        createProcessor = new CreateProcessor(bank);
        depositProcessor = new DepositProcessor(bank);
    }

    @Test
    void process_pass_one_month_with_more_than_hundred_balance_in_checking_command() {
        createProcessor.createProcess("create checking 12345678 3");
        depositProcessor.depositProcess("deposit 12345678 1000");
        passTimeProcessor.passTimeProcess("pass 1");
        assertEquals(1002.5, bank.getAccount(id).getBalance());
    }

    @Test
    void process_pass_one_month_with_more_than_hundred_balance_in_saving_command() {
        createProcessor.createProcess("create savings 12345678 3");
        depositProcessor.depositProcess("deposit 12345678 1000");
        passTimeProcessor.passTimeProcess("pass 1");
        assertEquals(1002.5, bank.getAccount(id).getBalance());
    }

    @Test
    void process_pass_one_month_with_more_than_hundred_balance_in_cd_command() {
        createProcessor.createProcess("create cd 23456789 2.1 2000");
        passTimeProcessor.passTimeProcess("pass 1");
        assertEquals(2014.0367928937578, bank.getAccount("23456789").getBalance());
    }

    @Test
    void process_pass_12_month_with_more_than_hundred_balance_in_cd_command() {
        createProcessor.createProcess("create cd 23456789 2.1 2000");
        passTimeProcessor.passTimeProcess("pass 12");
        assertEquals(2175.098098315957, bank.getAccount("23456789").getBalance());
    }

    @Test
    void process_pass_one_month_with_twenty_five_balance_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        depositProcessor.depositProcess("deposit 12345678 25");
        passTimeProcessor.passTimeProcess("pass 1");
        assertEquals(0, bank.getAccount(id).getBalance());
    }

    @Test
    void process_pass_one_month_with_zero_balance_command() {
        createProcessor.createProcess("create checking 12345678 0.2");
        passTimeProcessor.passTimeProcess("pass 1");
        assertEquals(null, bank.getAccount(id));
    }

}
