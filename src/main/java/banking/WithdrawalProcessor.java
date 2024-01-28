package banking;

public class WithdrawalProcessor extends CommandProcessor {

    public WithdrawalProcessor(Bank bank) {
        super(bank);
    }

    public void withdrawalProcess(String command) {
        String[] parts = command.split(" ");
        String accountID = parts[1];
        double withdrawalAmount = Double.parseDouble(parts[2]);
        bank.withdraw(accountID, withdrawalAmount);
    }
}