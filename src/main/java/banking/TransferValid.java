package banking;

public class TransferValid extends CommandValidator {

    public TransferValid(Bank bank) {
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
        if (parts.length == 4) {
            String firstAccountID = parts[1];
            String secondAccountID = parts[2];
            String transferAmount = parts[3];

            if (firstAccountID.length() != 8 || secondAccountID.length() != 8 || !isNumeric(firstAccountID) || !isNumeric(secondAccountID)) {
                return false;
            }
            if (!isNumeric(transferAmount)) {
                return false;
            }


            if (bank.getAccounts().get(firstAccountID) != null && bank.getAccounts().get(secondAccountID) != null) {
                try {
                    double amount = Double.parseDouble(transferAmount);
                    Account account1 = bank.getAccounts().get(firstAccountID);
                    Account account2 = bank.getAccounts().get(secondAccountID);
                    if (amount > account1.maxWithdrawalAmount() || amount > account2.maxDepositAmount() || amount < 0) {
                        return false;
                    }
                    if (account1.isCD || account2.isCD) {
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
