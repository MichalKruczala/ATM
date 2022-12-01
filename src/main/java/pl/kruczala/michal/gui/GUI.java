package pl.kruczala.michal.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kruczala.michal.CashMachine;

@Component
public class GUI {
    @Autowired
    CashMachine cashMachine;

    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLACK_BACKGROUND = "\u001B[40m";


    public void printHello() {
        System.out.println(ANSI_GREEN + "Hello inside ATM bank");
    }

    public void askUserRorQuantity() {
        System.out.print("how much money would you get?: ");
    }

    public void showAccountBalance() {
        System.out.println("Amount  of money on your account " + cashMachine.getAccountBalance());
    }

    public void printEND() {
        System.out.println(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "----Thank you for using our services----" + ANSI_RESET);
    }

    public void printContinueOrExit() {
        System.out.println("Would you pau out more? or exit ATM bank?");
        System.out.print("Insert 'c' to continue ,or 'e' to exit bank:");
    }

    public void printWrongData() {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "Wrong type of data" + ANSI_RESET);
    }

    public void printWrongCredentials() {
        final String RED_UNDERLINED = "\033[4;31m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + RED_UNDERLINED + "------Wrong credentials------" + ANSI_RESET);
    }
}
