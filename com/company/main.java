package com.company;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello in ATM online bank");
        int accountbalance = 50000;
        while (true) {
            System.out.print("how much money would you get?: ");

            Scanner payout = new Scanner(System.in);
            int sum = payout.nextInt();

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
}