package banking;

public class CreateProcessor extends CommandProcessor {

    public CreateProcessor(Bank bank) {
        super(bank);
    }

    public void createProcess(String command) {
        String[] parts = command.split(" ");

        if (parts[1].equalsIgnoreCase("checking")) {
            String accountID = parts[2];
            double accountApr = Double.parseDouble(parts[3]);

            Account account = new Checking(accountID, accountApr);
            bank.addAccount(accountID, account);

        } else if (parts[1].equalsIgnoreCase("savings")) {
            String accountID = parts[2];
            double accountApr = Double.parseDouble(parts[3]);

            Account account = new Savings(accountID, accountApr);
            bank.addAccount(accountID, account);
        } else if (parts[1].equalsIgnoreCase("cd")) {
            String accountID = parts[2];
            double accountApr = Double.parseDouble(parts[3]);
            double accountAmount = Double.parseDouble(parts[4]);
            Account account = new CD(accountID, accountApr, accountAmount);
            bank.addAccount(accountID, account);
        }
    }
}
