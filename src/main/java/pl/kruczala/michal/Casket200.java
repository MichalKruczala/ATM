package pl.kruczala.michal;

public class Casket200 extends CashMachine {

    Casket200 casket200 = new Casket200();


    int requestedSum = casket200.getRequestedSum();
    int accountBalance = casket200.getAccountBalance();
    int numberOf200BanknotesInCasket = 50;
    int usedNumberOf200BanknotesToPayOut = 0;
    int restOfRequestedSum;


    public Casket200(){
        do {
            usedNumberOf200BanknotesToPayOut = usedNumberOf200BanknotesToPayOut + 1;
            accountBalance = accountBalance - 200;
            requestedSum = requestedSum - 200;
            numberOf200BanknotesInCasket = numberOf200BanknotesInCasket - 1;



        } while (requestedSum >= 200 && numberOf200BanknotesInCasket >= 0);
    }


}
