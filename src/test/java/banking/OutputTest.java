package banking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputTest {
    private Output output;

    @BeforeEach
    public void setUp() {
        output = new Output();
    }

    @Test
    public void testAddOutput() {
        output.addOutput("create account");
        output.addOutput("Deposit 12345678 700");
        output.addOutput("Transfer 98765432 12345678 300");

        List<String> outputList = output.getOutputList();
        assertEquals(3, outputList.size());
        assertEquals("create account", outputList.get(0));
        assertEquals("Deposit 12345678 700", outputList.get(1));
        assertEquals("Transfer 98765432 12345678 300", outputList.get(2));
    }
}
