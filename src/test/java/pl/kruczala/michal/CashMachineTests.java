package pl.kruczala.michal;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void shouldNotPayOutToMuch() {
        CashMachine cashMachine = new CashMachine();
        int requestedCash = 0;
        try {
            requestedCash = cashMachine.payOut(60000);
        } catch (Exception e) {
        }

        Assertions.assertEquals(0, requestedCash);
    }

    @Test
    public void shouldPayOutTwice() {
        CashMachine cashMachine = new CashMachine();
        try {
            int returnedCash = cashMachine.payOut(100);
            int secondReturnedCash = cashMachine.payOut(100);

            Assertions.assertEquals(100, returnedCash);
            Assertions.assertEquals(100, secondReturnedCash);
        } catch (Exception e) {
        }
    }

    @Test
    void testExpectedException()  {

        ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
            CashMachine cashMachine = new CashMachine();
            cashMachine.payOut(30000);
            cashMachine.payOut(30000);
        });

        Assertions.assertEquals("Requested sum is lower than your account balance",thrown.getMessage());
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

    @Test
    public void shouldNotPayOutZero() {
        CashMachine cashMachine = new CashMachine();
        try {
            int returnedCash = cashMachine.payOut(0);
            Assertions.assertEquals(0, returnedCash);
        } catch (Exception e) {
        }
    }
}