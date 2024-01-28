package banking;

public class Savings extends Account {

    public Savings(String id, double apr) {
        super(id, apr);
        isCD = false;
        withdrawalTimesLeft = 1;
        super.accountType = "savings";
    }

    @Override
    public boolean withdrawIsValid() {
        if (withdrawalTimesLeft > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            balance = 0;
        }
        if (withdrawalTimesLeft == 1) {
            withdrawalTimesLeft -= 1;
        }

    }

    @Override
    public int maxDepositAmount() {
        return 2500;
    }

    @Override
    public int maxWithdrawalAmount() {
        return 1000;
    }

    @Override
    public void calculateApr() {
        double extraAmount = ((accountApr / 100) / 12) * balance;
        balance += extraAmount;
    }

    @Override
    public void passTimeToken() {
        if (balance < 100) {
            withdraw(25);
        } else {
            calculateApr();
        }
        if (withdrawalTimesLeft == 0) {
            withdrawalTimesLeft += 1;
        }
    }
}
