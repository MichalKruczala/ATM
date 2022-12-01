package pl.kruczala.michal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CashMachine {
    @Autowired
    private Bank bank;
  private final ArrayList<Casket> caskets = new ArrayList<>();

    public CashMachine() {
        caskets.add(new Casket(200));
        caskets.add(new Casket(100));
        caskets.add(new Casket(50));
        caskets.add(new Casket(20));
    }

    public int getAccountBalance() {

        int sum = 0;
        for (Casket casket : caskets) {
            sum = sum + casket.getCasketBalance();
        }

        return sum;
    }

    public boolean canPayOut(int requestedSum) {
        int currentSun = requestedSum;
        for (Casket casket : this.caskets) {
            int howMuchMoneyCanGet = casket.howMuchMoneyCanGet(currentSun);
            currentSun = currentSun - howMuchMoneyCanGet;
        }
        return currentSun == 0;
    }

    public ArrayList<PayOutResult> payOut(Quantum requestedSum) throws Exception {

        ArrayList<PayOutResult> result = new ArrayList<>();

        int currentSun = requestedSum.toInt();


        bank.calculate(currentSun, caskets);


        for (Casket casket : this.caskets) {
            int banknotes = casket.getBanknotes(currentSun);
            currentSun = currentSun - casket.resolveForBanknotes(banknotes);
            result.add(new PayOutResult(casket.nominal, banknotes));
        }
        return result;
    }

}
