package user_management;

import java.util.Scanner;
import static utilities.Styling.*;

public class UserMenu {
    private User loggedInUser;
    private Scanner sc = new Scanner(System.in);
    private double amountPayroll; // Declare class-level variables for deposit amounts.
    private double amountSavings; // Declare class-level variables for deposit amounts.

    public UserMenu(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public void showUserMenu() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n" + MAGENTA + "Welcome, User! Select an option:" + RESET);
            System.out.println("1. View Payroll a/c balance.");
            System.out.println("2. View Savings a/c balance.");
            System.out.println("3. Deposit to Payroll a/c.");
            System.out.println("4. Deposit to Savings a/c.");
            System.out.println("5. Logout");

            String selection = sc.nextLine();
            switch (selection) {
                case "1":
                    loggedInUser.viewPayrollBalance();
                    break;
                case "2":
                    loggedInUser.viewSavingsBalance();
                    break;
                case "3":
                    System.out.println("Enter amount to deposit to Payroll a/c:");
                    amountPayroll = Double.parseDouble(sc.nextLine());
                    loggedInUser.depositToPayrollAccount(amountPayroll);
                    break;
                case "4":
                    System.out.println("Enter amount to deposit to Savings a/c:");
                    amountSavings = Double.parseDouble(sc.nextLine());
                    loggedInUser.depositToSavingsAccount(amountSavings);
                    break;
                case "5":
                    loggedIn = false;
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
