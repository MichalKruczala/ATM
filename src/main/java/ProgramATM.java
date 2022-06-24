import pl.kruczala.michal.*;
import java.util.ArrayList;
import java.util.List;
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

                    ArrayList<PayOutResult> payOutResult1 = cashMachine.payOut(moneyQuantity);
                    // cashMachine.setRequestedSum(requestedSum); // to requested sum to nie requested sum z sash machine pajacu
                    System.out.println("-----Successfully pay out " + moneyQuantity+ "------");

                    ArrayList<PayOutResult> payOutResult = CasketShit(moneyQuantity);
                    for (PayOutResult e : payOutResult) {
                        System.out.println(e.toString());
                    }
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

    private static ArrayList<PayOutResult> CasketShit(int requestedSum) throws ApplicationException {
        Casket casket200 = new Casket(200);
        int a = casket200.getBanknotes(requestedSum);

        int restOfRequestedSumInMain = requestedSum - 200 * a;
        Casket casket100 = new Casket(100);
        int b = casket100.getBanknotes(restOfRequestedSumInMain);

        Casket casket50 = new Casket(50);
        int nextRestOfRequestedSumInMain = restOfRequestedSumInMain - 100 * b;
        int c = casket50.getBanknotes(nextRestOfRequestedSumInMain);

        int nextNextRestOfRequestedSumInMain = nextRestOfRequestedSumInMain - 50 * c;
        Casket casket20 = new Casket(20);
        int d = casket20.getBanknotes(nextNextRestOfRequestedSumInMain);
        ArrayList<PayOutResult> banknotesUsed = new ArrayList<>();
        banknotesUsed.add(new PayOutResult(200, a));
        banknotesUsed.add(new PayOutResult(100, b));
        banknotesUsed.add(new PayOutResult(50, c));
        banknotesUsed.add(new PayOutResult(20, d));

        return banknotesUsed;
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



