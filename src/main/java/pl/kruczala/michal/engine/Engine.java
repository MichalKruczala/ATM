package pl.kruczala.michal.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kruczala.michal.*;
import pl.kruczala.michal.authenticator.Authenticator;
import pl.kruczala.michal.gui.GUI;
import pl.kruczala.michal.prividers.OptionsProvider;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class Engine {
    @Autowired
    CashMachine cashMachine;
    @Autowired
    GUI gui;
    @Autowired
    Authenticator authenticator;
    @Autowired
    OptionsProvider optionsProvider;
    @Autowired
    Quantum quantum;

    public void start() {
        try {
            while (authenticator.tryAuthenticate()) {
                gui.printHello();
                do {
                    gui.askUserRorQuantity();
                    int moneyQuantity = optionsProvider.readInt();
                    quantum.setRequestedSum(moneyQuantity);

                    //  Quantum quantum = new Quantum(moneyQuantity);
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
    private boolean canRepeatView() throws IOException {
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




