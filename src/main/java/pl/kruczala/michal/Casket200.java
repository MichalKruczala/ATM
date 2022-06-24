package pl.kruczala.michal;

public class Casket200 extends CashMachine {

    //int accountBalance = getAccountBalance();
    int numberOf200BanknotesInCasket = 100;
    int usedNumberOf200BanknotesToPayOut =-1;


    public int casketPayOut200(int requestedSumInMain) {

        requestedSumInMain = requestedSumInMain+ 200;

        do {
            requestedSumInMain = requestedSumInMain - 200;
            numberOf200BanknotesInCasket = numberOf200BanknotesInCasket - 1;
            usedNumberOf200BanknotesToPayOut = usedNumberOf200BanknotesToPayOut + 1;

        } while (requestedSumInMain >= 200 && numberOf200BanknotesInCasket >= 0);
        return usedNumberOf200BanknotesToPayOut;

    }

}
    