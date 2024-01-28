package banking;

public class CreateValid extends CommandValidator {

    public CreateValid(Bank bank) {
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

        if (parts[1].equalsIgnoreCase("checking")) {

            if (parts.length != 4) {

                return false;
            }

            String accountID = parts[2];
            double accountApr = Double.parseDouble(parts[3]);

            if (accountID.length() != 8 || !isNumeric(accountID)) {
                return false;
            }

            try {
                if (accountApr < 0 || accountApr > 10) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

            if (bank.getAccounts().get(accountID) == null) {
                return true;
            } else {
                return false;
            }

        } else if (parts[1].equalsIgnoreCase("savings")) {
            if (parts.length != 4) {
                return false;
            }

            String accountID = parts[2];
            double accountApr = Double.parseDouble(parts[3]);

            if (accountID.length() != 8 || !isNumeric(accountID)) {
                return false;
            }

            try {
                if (accountApr < 0 || accountApr > 10) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

            if (bank.getAccounts().get(accountID) == null) {
                return true;
            } else {
                return false;
            }
        } else if (parts[1].equalsIgnoreCase("cd")) {
            if (parts.length != 5) {
                return false;
            }

            String accountID = parts[2];

            String accountApr = parts[3];

            String accountAmount = parts[4];

            if (accountID.length() != 8 || !isNumeric(accountID)) {
                return false;
            }

            if (!isNumeric(accountAmount)) {
                return false;
            }

            try {
                double apr = Double.parseDouble(accountApr);
                if (apr < 0 || apr > 10) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }


            try {
                double amount = Double.parseDouble(accountAmount);
                if (amount < 1000 || amount > 10000) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }

            if (bank.getAccounts().get(accountID) == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
