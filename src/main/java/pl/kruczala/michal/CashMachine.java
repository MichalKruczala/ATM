package pl.kruczala.michal;

public class CashMachine {
    private int requestedSum;

    public int getAccountBalance() {
        return accountBalance;
    }



   // public int requestedSum;  //to requested sum to nie to z main..




    public int getRequestedSum() {
        return this.requestedSum;
    }

    public void setRequestedSum(int requestedSum) {
        this.requestedSum = requestedSum;

    }



    private int accountBalance = 50000;

    public CashMachine() {
    }

    public void setAccountBalance(int accountBalance) { //będziemy ustawiać ilość hajsu na koncie
        this.accountBalance = accountBalance;
    }

    public int payOut(int requestedSum) throws Exception {
        if ((requestedSum <= 0)) {
            throw new ApplicationException("Requested sum is negative or equal 0 ");
        }
        if (requestedSum % 200 != 0 && requestedSum % 100 != 0 && requestedSum % 50 != 0 && requestedSum % 20 != 0) {
            throw new ApplicationException("Can't pay out demanded amount of money, available banknotes: 200/100/50/20");
        }
        if (requestedSum <= accountBalance) {
            accountBalance = accountBalance - requestedSum;
            setRequestedSum(requestedSum);
            return requestedSum;
        } else {
            throw new ApplicationException("Requested sum is lower than your account balance");
        }
    }

}

//class PayoutResult {
//    public int successValue;
//    public String errorMessage;
//
//    private PayoutResult(int value, String errorMessage){
//        successValue = value;
//        this.errorMessage = errorMessage;
//    }
//
//    public static PayoutResult ForSuccess(int value){
//        return new PayoutResult(value, null);
//    }
//
//    public static PayoutResult ForError(String reason){
//        return new PayoutResult(-1, reason);
//    }
//
//    public boolean IsError(){
//        return this.errorMessage == null;
//    }
//}

