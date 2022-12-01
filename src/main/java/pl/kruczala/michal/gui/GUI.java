package pl.kruczala.michal.gui;

import org.apache.commons.codec.digest.DigestUtils;
import pl.kruczala.michal.CashMachine;
import pl.kruczala.michal.OptionsProvider;

import java.io.IOException;
import java.util.Scanner;

public class GUI {
    CashMachine cashMachine = new CashMachine();
    Scanner scanner = new Scanner(System.in);
    OptionsProvider optionsProvider = new OptionsProvider();
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";
    final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    final String BLUE_UNDERLINED = "\033[4;34m";

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
