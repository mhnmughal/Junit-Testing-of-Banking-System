package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandProcessorTest {
    CommandProcessor commandProcessor;
    Bank bank;
    String id = "12345678";
    double amount = 500;
    double apr = 0.2;

    @BeforeEach
    void setUp() {
        bank = new Bank();
        commandProcessor = new CommandProcessor(bank);
    }

    @Test
    void process_create_command() {
        commandProcessor.commandProcess("create savings 12345678 0.2");
        assertEquals(id, bank.getAccount(id).getMyAccountID());
        assertEquals(apr, bank.getAccount(id).getAccountApr());
    }

    @Test
    void process_deposit_command() {
        commandProcessor.commandProcess("create savings 12345678 0.2");
        commandProcessor.commandProcess("deposit 12345678 500");
        assertEquals(amount, bank.getAccount(id).getBalance());

    }


}
