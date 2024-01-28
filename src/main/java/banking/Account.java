package banking;

import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public int withdrawalTimesLeft;
    public boolean isCD;

    protected String myAccountID;
    protected double accountApr;
    protected double balance = 0;
    protected String accountType;

    ArrayList<String> allAccountLogs = new ArrayList<>();

    public Account(String id, double apr) {
        this.myAccountID = id;
        this.accountApr = apr;
    }

    public Account(String ID, double apr, double amount) {
        this.myAccountID = ID;
        this.accountApr = apr;
        this.balance = amount;
    }

    public abstract int maxDepositAmount();

    public abstract int maxWithdrawalAmount();

    public abstract void calculateApr();

    public abstract void passTimeToken();

    public List<String> getAllAccountLogs() {
        return allAccountLogs;
    }

    public abstract boolean withdrawIsValid();

    public String getMyAccountID() {
        return myAccountID;
    }

    public double getAccountApr() {
        return accountApr;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            balance = 0;
        }
    }
}
