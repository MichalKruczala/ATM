package pl.kruczala.michal;

public class Casket20 {
    int usedNumberOf20BanknotesToPayOut = -1;
    int numberOf20BanknotesInCasket = 200;

    public int casketPayOut20(int nextNextRestOfRequestedSumInMain) {
        nextNextRestOfRequestedSumInMain = nextNextRestOfRequestedSumInMain + 20;

        do {

            nextNextRestOfRequestedSumInMain = nextNextRestOfRequestedSumInMain - 20;
            numberOf20BanknotesInCasket = numberOf20BanknotesInCasket - 1;
            usedNumberOf20BanknotesToPayOut = usedNumberOf20BanknotesToPayOut + 1;

        } while (nextNextRestOfRequestedSumInMain >= 20 && numberOf20BanknotesInCasket >= 0);
        return usedNumberOf20BanknotesToPayOut;
    }
}
