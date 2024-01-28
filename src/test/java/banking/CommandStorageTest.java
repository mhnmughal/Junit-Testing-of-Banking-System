package banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandStorageTest {
    CommandStorage commandStorage;

    @BeforeEach
    void setUp() {
        commandStorage = new CommandStorage();
    }


    @Test
    void add_into_the_list() {
        commandStorage.addInvalidCommands("create savings 12345678");
        assertEquals(1, commandStorage.getInvalidCommands().size());
    }

    @Test
    void add_two_into_the_list() {
        commandStorage.addInvalidCommands("create savings 12345678");
        commandStorage.addInvalidCommands("savings 12345678 0.2");
        assertEquals(2, commandStorage.getInvalidCommands().size());
    }

    @Test
    void list_is_empty_when_created() {
        assertEquals(0, commandStorage.getInvalidCommands().size());
    }
}
