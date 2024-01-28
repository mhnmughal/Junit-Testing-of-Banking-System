package banking;

public class CommandProcessor {
    protected Bank bank;

    public CommandProcessor(Bank bank) {
        this.bank = bank;
    }

    public void commandProcess(String command) {
        CreateProcessor createProcessor = new CreateProcessor(bank);
        DepositProcessor depositProcessor = new DepositProcessor(bank);
        WithdrawalProcessor withdrawalProcessor = new WithdrawalProcessor(bank);
        TransferProcessor transferProcessor = new TransferProcessor(bank);
        PassTimeProcessor passTimeProcessor = new PassTimeProcessor(bank);

        String[] parts = command.split(" ");

        if (parts[0].equalsIgnoreCase("create")) {
            createProcessor.createProcess(command);
        } else if (parts[0].equalsIgnoreCase("deposit")) {
            depositProcessor.depositProcess(command);
        } else if (parts[0].equalsIgnoreCase("withdrawal")) {
            withdrawalProcessor.withdrawalProcess(command);
        } else if (parts[0].equalsIgnoreCase("transfer")) {
            transferProcessor.transferProcess(command);
        } else if (parts[0].equalsIgnoreCase("pass")) {
            passTimeProcessor.passTimeProcess(command);
        }
    }
}
