package pl.kruczala.michal;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CashMachineTests {
//    @Test
//    public void shouldPayOut() throws Exception {
//        CashMachine cashMachine = new CashMachine();
//        int returnedCash = cashMachine.payOut(100);
//        Assertions.assertEquals(100, returnedCash);
//    }
//
//    @Test
//    public void shouldNotPayOutToMuch() throws Exception {
//        CashMachine cashMachine = new CashMachine();
//        int requestedCash = cashMachine.payOut(60000);
//        Assertions.assertEquals(0, requestedCash);
//    }
//
//    @Test
//    public void shouldPayOutTwice() throws Exception {
//        CashMachine cashMachine = new CashMachine();
//        int returnedCash = cashMachine.payOut(100);
//        int secondReturnedCash = cashMachine.payOut(100);
//        Assertions.assertEquals(100, returnedCash);
//        Assertions.assertEquals(100, secondReturnedCash);
//
//    }
//
//    @Test
//    void testExpectedException() {
//
//        ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
//            CashMachine cashMachine = new CashMachine();
//            cashMachine.payOut(30000);
//            cashMachine.payOut(30000);
//        });
//
//        Assertions.assertEquals("Requested sum is lower than your account balance", thrown.getMessage());
//    }
//
//    @Test
//    public void shouldNotPauOutNegativeValue() {
//        ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
//            CashMachine cashMachine = new CashMachine();
//            cashMachine.payOut(-100);
//
//        });
//
//        Assertions.assertEquals("Requested sum is negative or equal 0 ", thrown.getMessage());
//    }
//
//    @Test
//    public void shouldNotPayOutZero() {
//        CashMachine cashMachine = new CashMachine();
//        ApplicationException thrown = Assertions.assertThrows(ApplicationException.class, () -> {
//            int returnedCash = cashMachine.payOut(0);
//            Assertions.assertEquals(0, returnedCash);
//
//
//
//        });
//    }
}