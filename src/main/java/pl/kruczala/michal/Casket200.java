package pl.kruczala.michal;

public class Casket200 extends CashMachine {

    int accountBalance = getAccountBalance();
    int numberOf200BanknotesInCasket = 50;
    int usedNumberOf200BanknotesToPayOut = 0;


    public int getUsedNumberOf200BanknotesToPayOut() {
        return usedNumberOf200BanknotesToPayOut;
    }

    public int casketPayOut200(int requestedSumInMain) {
        do {
           // accountBalance = accountBalance - 200;  account balance sprawdza mi metoda  PayOut z cashMachine
            requestedSumInMain = requestedSumInMain - 200;
            numberOf200BanknotesInCasket = numberOf200BanknotesInCasket - 1;
            usedNumberOf200BanknotesToPayOut = usedNumberOf200BanknotesToPayOut + 1;

        } while (requestedSumInMain >= 200 && numberOf200BanknotesInCasket >= 0);
        return usedNumberOf200BanknotesToPayOut;
    }

}

