package banking;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bank {
    private double accountApr;
    private double balance;
    private Map<String, Account> allAccounts;

    public Bank() {
        this.allAccounts = new HashMap<>();
    }

    public Account getAccount(String id) {
        return allAccounts.get(id);
    }

    public Map<String, Account> getAccounts() {
        return allAccounts;
    }

    public void addAccount(String myAccountID, Account account) {
        allAccounts.put(myAccountID, account);
    }

    public void deposit(String myAccountID, double balance) {
        allAccounts.get(myAccountID).deposit(balance);
    }

    public void withdraw(String myAccountID, double balance) {
        allAccounts.get(myAccountID).withdraw(balance);
    }

    public void transfer(String firstAccountID, String secondAccountID, double transferAmount) {
        if (getAccounts().get(firstAccountID).getBalance() < transferAmount) {
            double accountBalance = getAccounts().get(firstAccountID).getBalance();
            deposit(secondAccountID, accountBalance);
        } else {
            deposit(secondAccountID, transferAmount);
        }
        withdraw(firstAccountID, transferAmount);
    }


    public void passTime(double monthPass) {
        for (int i = 0; i < monthPass; i++) {
            Iterator<String> iterator = allAccounts.keySet().iterator();
            String ID;
            for (int j = 0; j < allAccounts.size(); j++) {
                if (iterator.hasNext()) {
                    ID = iterator.next();
                    balance = allAccounts.get(ID).getBalance();
                    if (balance == 0) {
                        allAccounts.remove(ID);
                    } else {
                        getAccount(ID).passTimeToken();
                    }
                }
            }
        }
    }

}
