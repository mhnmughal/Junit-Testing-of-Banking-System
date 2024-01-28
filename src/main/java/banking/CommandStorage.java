package banking;

import java.util.ArrayList;
import java.util.List;

public class CommandStorage {

    Bank bank;
    private List<String> validCommands;
    private List<String> invalidCommands;


    public CommandStorage() {
        invalidCommands = new ArrayList<>();
        validCommands = new ArrayList<>();
    }

    public void addInvalidCommands(String command) {
        invalidCommands.add(command);
    }

    public void addValidCommands(String command) {
        validCommands.add(command);
    }

    public List<String> getInvalidCommands() {
        return invalidCommands;
    }

    public List<String> getValidCommands() {
        return validCommands;
    }


}
