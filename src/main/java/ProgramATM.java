import pl.kruczala.michal.Authenticator;
import pl.kruczala.michal.CashMachine;
import pl.kruczala.michal.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ProgramATM {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello in ATM online bank");
        System.out.print("podaj login: ");
        String loginGiven = scanner.next();
        System.out.print("podaj hasło: ");
        String passwordGiven = scanner.next();
        Authenticator authenticator = new Authenticator();
        if(!authenticator.tryAunthenticate(new User(loginGiven,passwordGiven))){
            System.out.println("Wrong credentials");
            return;
        }
        System.out.println("Hello inside ATM bank");
        CashMachine cashMachine = new CashMachine();
        System.out.print("how much money would you get?: ");
        int moneyQuantity = scanner.nextInt();
        int requestedSum = cashMachine.payOut(moneyQuantity);
        System.out.println("Successfully pay out " + requestedSum);
        System.out.println("Amount  of money on your account " + cashMachine.getAccountBalance());


    }




    }

