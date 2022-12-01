package pl.kruczala.michal;

public class Casket {
    public final int nominal;
    int numberOfBanknotesInCasket = 100;

    public Casket(int nominal) {
        this.nominal = nominal;
    }
    public int getCasketBalance(){
        return this.nominal * this.numberOfBanknotesInCasket;
    }
    public int howManyBanknotesCanGet(int requestedSum){
        int usedNumberOfBanknotesToPayOut = 0;
        while (requestedSum >= nominal && this.numberOfBanknotesInCasket >= 0) {
            requestedSum = requestedSum - nominal;
            usedNumberOfBanknotesToPayOut = usedNumberOfBanknotesToPayOut + 1;
        }
        return usedNumberOfBanknotesToPayOut;
    }
    public int getBanknotes(int requestedSum) {
        int banknotes = howManyBanknotesCanGet(requestedSum);
        this.numberOfBanknotesInCasket = this.numberOfBanknotesInCasket - banknotes;
        return banknotes;

    }
    public int howMuchMoneyCanGet(int requestedSum){
        return howManyBanknotesCanGet(requestedSum)*nominal;
    }
    public int resolveForBanknotes(int count){
        return count*nominal;
    }

}
