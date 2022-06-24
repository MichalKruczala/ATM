package pl.kruczala.michal;

import java.util.ArrayList;

public class CashMachine {
    ArrayList<Casket> caskets = new ArrayList<>();

    public CashMachine() {
        caskets.add(new Casket(200));
        caskets.add(new Casket(100));
        caskets.add(new Casket(50));
        caskets.add(new Casket(20));
    }

    public int getAccountBalance(){

        int sum = 0;
        for (Casket casket:caskets) {
            sum = sum + casket.getCasketBalance();
        }

        return sum;
    }
    public boolean canPayOut(int requestedSum){
        int currentSun = requestedSum;
        for (Casket casket: this.caskets) {
            int howMuchMoneyCanGet = casket.howMuchMoneyCanGet(currentSun);
            currentSun = currentSun - howMuchMoneyCanGet;
        }
        return currentSun == 0;
    }
    public ArrayList<PayOutResult> payOut(int requestedSum) throws Exception {
        if ((requestedSum <= 0)) {
            throw new ApplicationException("Requested sum is negative or equal 0 ");
        }
        if (!canPayOut(requestedSum)) {
            throw new ApplicationException("Can't pay out demanded amount of money, available banknotes: 200/100/50/20");
        }
        ArrayList<PayOutResult> result = new ArrayList<>();

        int currentSun = requestedSum;
        for (Casket casket: this.caskets) {
            int howMuchMoneyCanGet = casket.getBanknotes(currentSun);
            currentSun = currentSun - howMuchMoneyCanGet;
            result.add(new PayOutResult(casket.nominal,howMuchMoneyCanGet));
        }
        return result;
    }
}
