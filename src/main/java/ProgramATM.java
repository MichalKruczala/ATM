import pl.kruczala.michal.ApplicationException;
import pl.kruczala.michal.Authenticator;
import pl.kruczala.michal.CashMachine;
import pl.kruczala.michal.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramATM {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (tryAuthenticate(scanner)) {
                CashMachine cashMachine = new CashMachine();
                System.out.println("Hello inside ATM bank");

                do {
                    System.out.print("how much money would you get?: ");
                    int moneyQuantity = scanner.nextInt();
                    int requestedSum = cashMachine.payOut(moneyQuantity);
                    System.out.println("Successfully pay out " + requestedSum);
                    System.out.println("Amount  of money on your account " + cashMachine.getAccountBalance());
                }
                while (canRepeatView(scanner));
            }
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private static boolean tryAuthenticate(Scanner scanner) {
        System.out.println("Hello in ATM online bank");
        System.out.print("podaj login: ");
        String loginGiven = scanner.next();
        System.out.print("podaj hasło: ");
        String passwordGiven = scanner.next();
        Authenticator authenticator = new Authenticator();
        User user = authenticator.tryAunthenticate(loginGiven, passwordGiven);
        if (user == null) {
            System.out.println("------Wrong credentials------");
            return false;
        }
        return true;
    }

    private static boolean canRepeatView(Scanner scanner) {
        System.out.println("Would you pau out more? or exit ATM bank?");
        System.out.println("Insert 'c' to continue or 'e' to exit bank");
        switch (scanner.next()) {
            case "c":
                return true;
            case "e":
                return false;
            default:
                System.out.println("podano złą wartość");
                return canRepeatView(scanner);
        }
    }
}

