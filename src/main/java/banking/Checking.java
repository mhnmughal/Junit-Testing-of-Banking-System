package banking;

public class Checking extends Account {
    public Checking(String id, double apr) {
        super(id, apr);
        isCD = false;
        super.accountType = "checking";
    }

    @Override
    public boolean withdrawIsValid() {
        return true;
    }

    @Override
    public int maxDepositAmount() {
        return 1000;
    }

    @Override
    public int maxWithdrawalAmount() {
        return 400;
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
    }

}
