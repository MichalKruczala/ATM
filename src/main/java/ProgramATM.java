import pl.kruczala.michal.*;
import pl.kruczala.michal.authenticator.Authenticator;
import pl.kruczala.michal.gui.GUI;

import java.io.IOException;
import java.util.ArrayList;

public class ProgramATM {
    public static void main(String[] args) {

        CashMachine cashMachine = new CashMachine();
        GUI gui = new GUI();
        Authenticator authenticator = new Authenticator();
        OptionsProvider optionsProvider = new OptionsProvider();

        try {
            while (authenticator.tryAuthenticate()) {
                gui.printHello();
                do {
                    gui.askUserRorQuantity();
                    int moneyQuantity = optionsProvider.readInt();
                    Quantum quantum = new Quantum(moneyQuantity);

                    ArrayList<PayOutResult> payOutResult1 = cashMachine.payOut(quantum);
                    for (PayOutResult e : payOutResult1) {
                        System.out.println(e.toString());
                    }
                    gui.showAccountBalance();
                }
                while (canRepeatView());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            gui.printEND();
        }
    }

    private static boolean canRepeatView() throws IOException {
        OptionsProvider optionsProvider = new OptionsProvider();
        GUI gui = new GUI();
        gui.printContinueOrExit();
        switch (optionsProvider.readChar()) {
            case 'c':
                return true;
            case 'e':
                return false;
            default:
                gui.printWrongData();
                return canRepeatView();
        }
    }


}




