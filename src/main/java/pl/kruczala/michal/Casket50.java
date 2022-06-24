package pl.kruczala.michal;

public class Casket50 {

    int numberOf50BanknotesInCasket = 120;

    public int casketPayOut50(int nextRestOfRequestedSumInMain) {
        int usedNumberOf50BanknotesToPayOut = 0;

        if (nextRestOfRequestedSumInMain == 60 || nextRestOfRequestedSumInMain == 80) {
            return 0;
        } else {

            while (nextRestOfRequestedSumInMain >= 50 && numberOf50BanknotesInCasket >= 0) {
                nextRestOfRequestedSumInMain = nextRestOfRequestedSumInMain - 50;
                numberOf50BanknotesInCasket = numberOf50BanknotesInCasket - 1;
                usedNumberOf50BanknotesToPayOut = usedNumberOf50BanknotesToPayOut + 1;

            }
            return usedNumberOf50BanknotesToPayOut;
        }
    }

}