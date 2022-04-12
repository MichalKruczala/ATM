package com.company;

import com.company.users.User;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello in ATM online bank");
        System.out.println("-----Podaj Login i hasło-----");

        User Jarek = new User("jareczek123", "ciastkonakielny");
        User Grzes = new User("grzesiek123", "brakciasta");
        User Michal = new User("michal123", "tylkodance");
        ArrayList<User> bankUsers = new ArrayList<User>();
        bankUsers.add(Jarek);
        bankUsers.add(Grzes);
        bankUsers.add(Michal);

        while (true) {
            if(!TryAuthenticate(bankUsers)){
                System.out.println("podano zły login lub hasło");
                continue;
            }

            int accountbalance = 50000;
            System.out.print("how much money would you get?: ");

            int sum = scanner.nextInt();

            if (sum > 0) {
                if (sum % 100 == 0 && sum <= accountbalance && sum > 0) {
                    System.out.println("Gratuluję wypłata poszła pomyślnie");
                    accountbalance = accountbalance - sum;
                    System.out.println("-----zostało ci -----" + (accountbalance + " zł"));
                } else {
                    System.out.println("Nie Mozna wypłacić : podany zły nominał lub brak wystarczających środków na koncie");
                }


            } else {
                System.out.println("podano ujemną kwotę");
            }


            System.out.print("how much money would you get?: ");

            sum = scanner.nextInt();

            if (sum > 0) {
                if (sum % 100 == 0 && sum <= accountbalance && sum > 0) {
                    System.out.println("Gratuluję wypłata poszła pomyślnie");
                    accountbalance = accountbalance - sum;
                    System.out.println("-----zostało ci -----" + (accountbalance + " zł"));
                } else {
                    System.out.println("Nie Mozna wypłacić : podany zły nominał lub brak wystarczających środków na koncie");
                }


            } else {
                System.out.println("podano ujemną kwotę");

            }
        }
    }

    public static boolean TryAuthenticate(ArrayList<User> usersInSystem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("podaj login: ");
        String loginGiven = scanner.next();
        System.out.print("podaj hasło: ");
        String passwordGiven = scanner.next();
        for (User e : usersInSystem) {
            if (e.login.equals(loginGiven) && e.password.equals(passwordGiven)) {
                return true;
            }
        }

        return false;
    }
}
