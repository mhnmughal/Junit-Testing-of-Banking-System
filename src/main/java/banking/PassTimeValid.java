package banking;

public class PassTimeValid extends CommandValidator {
    public PassTimeValid(Bank bank) {
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
        if (parts.length == 2) {
            String month = parts[1];
            if (!isNumeric(month)) {
                return false;
            }
            int monthPass = Integer.parseInt(parts[1]);
            if (monthPass < 1 || monthPass > 60) {
                return false;
            }
            return true;

        } else {
            return false;
        }
    }
}
