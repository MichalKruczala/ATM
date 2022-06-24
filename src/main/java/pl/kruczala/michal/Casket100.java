package pl.kruczala.michal;

public class Casket100 extends Casket200 {
    int numberOf100BanknotesInCasket = 200;

    public int casketPayOut100(int restOfRequestedSumInMain) {
        int usedNumberOf100BanknotesToPayOut = 0;

        while (restOfRequestedSumInMain >= 100 && numberOf100BanknotesInCasket >= 0) {

            restOfRequestedSumInMain = restOfRequestedSumInMain - 100;
            numberOf100BanknotesInCasket = numberOf100BanknotesInCasket - 1;
            usedNumberOf100BanknotesToPayOut = usedNumberOf100BanknotesToPayOut + 1;

        }
        return usedNumberOf100BanknotesToPayOut;
    }

}



