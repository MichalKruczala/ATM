package pl.kruczala.michal;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class CashMachineTests {
    @Test
    public void shouldPayOut() {
        CashMachine cashMachine = new CashMachine();
        try {
            int returnedCash = cashMachine.payOut(100);
            Assertions.assertEquals(100, returnedCash);
        } catch (Exception e) {
        }
    }

    @Test
    public void shouldPayOutTwice() {
        CashMachine cashMachine = new CashMachine();
        try {
            int returnedCash = cashMachine.payOut(100);
            returnedCash = cashMachine.payOut(100);

            Assertions.assertEquals(100, returnedCash);
        } catch (Exception e) {
        }
    }

    @Test
    public void shouldThrowExceptionWhenCashMachineIsEmpty() {
        CashMachine cashMachine = new CashMachine();
        try {
            cashMachine.payOut(30000);
            cashMachine.payOut(30000);
        } catch (Exception e) {
            return;
        }

        Assertions.fail("Exception has not been thrown");
    }

    @Test
    public void shouldNotPauOutNegativeValue() {
        CashMachine cashMachine = new CashMachine();
        try {
            cashMachine.payOut(-100);
        } catch (Exception e) {
            return;
        }
        Assertions.fail("Exception has not been thrown");

    }
}

