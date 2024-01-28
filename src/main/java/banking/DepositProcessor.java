package banking;

public class DepositProcessor extends CommandProcessor {

    public DepositProcessor(Bank bank) {
        super(bank);
    }

    public void depositProcess(String command) {
        String[] parts = command.split(" ");
        String accountID = parts[1];
        double depositAmount = Double.parseDouble(parts[2]);
        bank.deposit(accountID, depositAmount);
        //bank.getAccount(accountID).storeTransction(command);
    }
}
