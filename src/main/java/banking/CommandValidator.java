package banking;

public class CommandValidator {

    protected Bank bank;

    public CommandValidator(Bank bank) {
        this.bank = bank;
    }

    public boolean validate(String command) {
        CreateValid createValid = new CreateValid(bank);
        DepositValid depositValid = new DepositValid(bank);
        WithdrawalValid withdrawalValid = new WithdrawalValid(bank);
        TransferValid transferValid = new TransferValid(bank);
        PassTimeValid passTimeValid = new PassTimeValid(bank);

        String[] parts = command.split(" ");

        if (parts[0].equalsIgnoreCase("create")) {
            return createValid.valid(command);
        } else if (parts[0].equalsIgnoreCase("deposit")) {
            return depositValid.valid(command);
        } else if (parts[0].equalsIgnoreCase("withdrawal")) {
            return withdrawalValid.valid(command);
        } else if (parts[0].equalsIgnoreCase("transfer")) {
            return transferValid.valid(command);
        } else if (parts[0].equalsIgnoreCase("pass")) {
            return passTimeValid.valid(command);
        } else {
            return false;
        }

    }

}
