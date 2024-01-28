package banking;

public class DepositValid extends CommandValidator {

    public DepositValid(Bank bank) {
        super(bank);
    }

    private static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean valid(String command) {

        String[] parts = command.split(" ");
        if (parts.length == 3) {
            String accountID = parts[1];
            String depositAmount = parts[2];

            if (accountID.length() != 8 || !isNumeric(accountID)) {
                return false;
            }
            if (!isNumeric(depositAmount)) {
                return false;
            }


            if (bank.getAccounts().get(accountID) != null) {
                try {
                    double amount = Double.parseDouble(depositAmount);
                    Account account = bank.getAccounts().get(accountID);
                    if (amount > account.maxDepositAmount() || amount < 0) {
                        return false;
                    }
                    if (account.isCD) {
                        return false;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }
        return true;
    }
}
