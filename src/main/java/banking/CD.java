package banking;

public class CD extends Account {
    int withdrawalMonthLest = 12;

    public CD(String id, double apr, double amount) {
        super(id, apr, amount);
        isCD = true;
        super.accountType = "cd";
    }


    @Override
    public boolean withdrawIsValid() {
        if (withdrawalMonthLest == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int maxDepositAmount() {
        return -1;
    }

    @Override
    public int maxWithdrawalAmount() {
        return -1;
    }

    @Override
    public void calculateApr() {
        double interest;
        for (int i = 0; i < 4; i++) {
            interest = ((accountApr / 100) / 12) * balance;
            balance += interest;
        }

    }

    @Override
    public void passTimeToken() {
        if (balance < 100) {
            withdraw(25);
        } else {
            calculateApr();
        }
        if (withdrawalMonthLest > 0) {
            withdrawalMonthLest -= 1;
        }
    }


}
