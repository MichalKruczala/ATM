package pl.kruczala.michal;

public class Casket100 extends Casket200 {
    int numberOf100BanknotesInCasket = 200;
    int usedNumberOf100BanknotesToPayOut = -1;


    public int casketPayOut100(int restOfRequestedSumInMain) {
        restOfRequestedSumInMain = restOfRequestedSumInMain + 100;

        do {

            restOfRequestedSumInMain = restOfRequestedSumInMain - 100;
            numberOf100BanknotesInCasket = numberOf100BanknotesInCasket - 1;
            usedNumberOf100BanknotesToPayOut = usedNumberOf100BanknotesToPayOut + 1;

        } while (restOfRequestedSumInMain >= 100 && numberOf100BanknotesInCasket >= 0);
        return usedNumberOf100BanknotesToPayOut;
    }

}

