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
            throw new ApplicationException("Requested sum is negative or equal 0 ");
        }  if (requestedSum % 200 != 0 && requestedSum % 100 != 0 && requestedSum % 50 != 0 && requestedSum % 20 != 0) {
            throw new ApplicationException("Can't pay out demanded amount of money, available banknotes: 200/100/50/20");
        }
        if (requestedSum <= accountBalance) {
            accountBalance = accountBalance - requestedSum;

            return requestedSum;
        } else {
            throw new ApplicationException("Requested sum is lower than your account balance");
        }
    }


}

