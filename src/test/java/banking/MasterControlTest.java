package  banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MasterControlTest {

    private MasterControl masterControl;
    private List<String> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>();
        Bank bank = new Bank();
        masterControl = new MasterControl(new CommandValidator(bank),
                new CommandProcessor(bank), new CommandStorage(), new Output());
    }


    @Test
    void typo_in_create_command_is_invalid() {
        input.add("create checking 12345678 1.0");

        List<String> actual = masterControl.start(input);

        assertEquals(1, actual.size());
        assertEquals("create checking 12345678 1.0", actual.get(0));
    }

    @Test
     void typo_in_deposit_command_is_invalid() {
        input.add("create checking 12345678 1.0");
        input.add("deposit 12345678 100");

        List<String> actual = masterControl.start(input);

        assertEquals(2, actual.size());
        assertEquals("create checking 12345678 1.0", actual.get(0));
        assertEquals("deposit 12345678 100", actual.get(1));
    }

    @Test
    void two_typo_command_both_invalid() {
        input.add("create checking 12345678 1.0");
        input.add("deposit 12345678 100");

        List<String> actual = masterControl.start(input);

        assertEquals(2, actual.size());
        assertEquals("create checking 12345678 1.0", actual.get(0));
        assertEquals("deposit 12345678 100", actual.get(1));
    }

    @Test
    void invalid_to_create_accounts_with_same_ID() {
        input.add("create checking 12345678 1.0");
        input.add("create checking 12345678 1.0");

        List<String> actual = masterControl.start(input);

        assertEquals(1, actual.size());
        assertEquals("create checking 12345678 1.0", actual.get(0));
    }

    @Test
    void sample_make_sure_this_passes_unchanged_or_you_will_fail() {
        input.add("Create savings 12345678 0.6");
        input.add("Deposit 12345678 700");
        input.add("Deposit 12345678 5000");
        input.add("creAte cHecKing 98765432 0.01");
        input.add("Deposit 98765432 300");
        input.add("Transfer 98765432 12345678 300");
        input.add("Pass 1");
        input.add("Create cd 23456789 1.2 2000");

        List<String> actual = masterControl.start(input);

        assertEquals( 7, actual.size());
        assertEquals("Create savings 12345678 0.6", actual.get(0));
        assertEquals("Deposit 12345678 700", actual.get(1));
        assertEquals("creAte cHecKing 98765432 0.01", actual.get(2));
        assertEquals("Deposit 98765432 300", actual.get(3));
        assertEquals("Transfer 98765432 12345678 300", actual.get(4));
        assertEquals("Pass 1", actual.get(5));
        assertEquals("Create cd 23456789 1.2 2000", actual.get(6));

    }
}
