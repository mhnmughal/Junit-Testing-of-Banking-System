package banking;

public class TransferProcessor extends CommandProcessor {
    public TransferProcessor(Bank bank) {
        super(bank);
    }

    public void transferProcess(String command) {
        String[] parts = command.split(" ");
        String firstAccountID = parts[1];
        String secondAccountID = parts[2];
        double transferAmount = Double.parseDouble(parts[3]);
        bank.transfer(firstAccountID, secondAccountID, transferAmount);
    }
}
