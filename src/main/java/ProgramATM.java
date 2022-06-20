import pl.kruczala.michal.*;

import java.util.Scanner;

public class ProgramATM {
    public static void main(String[] args) {


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


        try {
            Scanner scanner = new Scanner(System.in);
            if (tryAuthenticate(scanner)) {
                CashMachine cashMachine = new CashMachine();
                System.out.println(ANSI_GREEN + "Hello inside ATM bank");

                do {
                    System.out.print("how much money would you get?: ");
                    int moneyQuantity = scanner.nextInt();

                    int requestedSumInMain = cashMachine.payOut(moneyQuantity);
                    // cashMachine.setRequestedSum(requestedSumInMain); // to requested sum to nie requested sum z sash machine pajacu
                    System.out.println("-----Successfully pay out " + requestedSumInMain + "------");

                    CasketShit(requestedSumInMain);

                    System.out.println("Amount  of money on your account " + cashMachine.getAccountBalance());

                }
                while (canRepeatView(scanner));

            }
        } catch (ApplicationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(ANSI_YELLOW + ANSI_BLACK_BACKGROUND + "----Thank you for using our services----" + ANSI_RESET);
        }
    }

    private static void CasketShit(int requestedSumInMain) {
        Casket200 casket200 = new Casket200();
        System.out.print("200zł x ");
        int a = casket200.casketPayOut200(requestedSumInMain);
        System.out.println(a);
        int restOfRequestedSumInMain = requestedSumInMain - 200 * a;
        Casket100 casket100 = new Casket100();
        System.out.print("100zł x ");
        int b = casket100.casketPayOut100(restOfRequestedSumInMain);
        System.out.println(b);
        Casket50 casket50 = new Casket50();
        int nextRestOfRequestedSumInMain = restOfRequestedSumInMain - 100 * b;
        System.out.print("50zł x ");
        int c = casket50.casketPayOut50(nextRestOfRequestedSumInMain);
        System.out.println(c);
        int nextNextRestOfRequestedSumInMain = nextRestOfRequestedSumInMain - 50 * c;
        Casket20 casket20 = new Casket20();
        System.out.print("20zł x ");
        System.out.println(casket20.casketPayOut20(nextNextRestOfRequestedSumInMain));
    }


    private static boolean tryAuthenticate(Scanner scanner) {
        final String RED_UNDERLINED = "\033[4;31m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("Hello in ATM online bank");
        System.out.print("Insert login: ");
        String loginGiven = scanner.next();
        System.out.print("Insert password: ");
        String passwordGiven = scanner.next();
        Authenticator authenticator = new Authenticator();
        User user = authenticator.tryAunthenticate(loginGiven, passwordGiven);
        if (user == null) {
            System.out.println(ANSI_RED + RED_UNDERLINED + "------Wrong credentials------" + ANSI_RESET);
            return false;
        }
        return true;
    }

    private static boolean canRepeatView(Scanner scanner) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";

        System.out.println("Would you pau out more? or exit ATM bank?");
        System.out.print("Insert 'c' to continue ,or 'e' to exit bank:");
        switch (scanner.next()) {
            case "c":
                return true;
            case "e":
                return false;
            default:
                System.out.println(ANSI_RED + "Wrong type of data" + ANSI_RESET);
                return canRepeatView(scanner);
        }
    }


}

