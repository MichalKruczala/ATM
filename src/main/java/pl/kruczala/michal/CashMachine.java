package pl.kruczala.michal;

public class CashMachine {
    public int getAccountBalance() {
        return accountBalance;
    }

    private int accountBalance = 50000;

    public CashMachine() {
    }

    public int payOut(int requestedSum) throws Exception {
        if ((requestedSum <= 0)) {
            throw new Exception("Requested sum is negative or equal 0 ");
        }
        if (requestedSum <= accountBalance) {
            accountBalance = accountBalance - requestedSum;
            return requestedSum;
        } else {
            throw new Exception("Requested sum is lower than your accountballance");
        }


    }
}

