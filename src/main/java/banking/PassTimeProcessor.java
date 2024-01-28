package banking;

public class PassTimeProcessor extends CommandProcessor {
    public PassTimeProcessor(Bank bank) {
        super(bank);
    }

    public void passTimeProcess(String command) {
        String[] parts = command.split(" ");
        int monthPass = Integer.parseInt(parts[1]);
        bank.passTime(monthPass);
    }
}