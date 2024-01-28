package banking;

public class WithdrawalValid extends CommandValidator {

    public WithdrawalValid(Bank bank) {
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
            String withdrawalAmount = parts[2];

            if (accountID.length() != 8 || !isNumeric(accountID)) {
                return false;
            }

            if (bank.getAccounts().get(accountID) != null) {

                double amount = Double.parseDouble(withdrawalAmount);
                Account account = bank.getAccounts().get(accountID);
                try {
                    if (account.isCD) {
                        if (bank.getAccounts().get(accountID).getBalance() != amount) {
                            return false;
                        }
                        if (!account.withdrawIsValid()) {
                            return false;
                        }

                    } else {
                        if (!isNumeric(withdrawalAmount)) {
                            return false;
                        }
                        if (amount > account.maxWithdrawalAmount() || amount < 0) {
                            return false;
                        }
                        if (!account.withdrawIsValid()) {
                            return false;
                        }
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
