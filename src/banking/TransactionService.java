package banking;

import user_management.User;
import user_management.UserManager;
import static utilities.Styling.*;
import java.util.Scanner;

public class TransactionService {
    /**
     * Clean Code:
     * The 'UserMenu' class now focuses on user interaction,
     * while 'TransactionService' handles transactions.
     *
     * Scalability:
     * Adding future features like 'transaction logs' or
     * advanced 'validation' becomes easier.
     *
     * Testability:
     * You can now write 'unite tests' for 'TransactionService' independently.
     *
     */

    private UserManager userManager;

    // Constructor
    public TransactionService(UserManager userManager) {
        this.userManager = userManager;
    }

    public void transferFunds(User loggedInUser) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n" + MAGENTA + "Transfer Funds" + RESET);

        // Choose account to transfer FROM.
        System.out.println("Choose account to transfer FROM:");
        System.out.println("1. Payroll a/c");
        System.out.println("2. Savings a/c");
        String fromAccountChoice = sc.nextLine();

        double fromBalance = fromAccountChoice.equals("1") ?
                             loggedInUser.getPayrollBalance() : loggedInUser.getSavingsBalance();

        if (fromBalance <= 0) {
            System.out.println(RED + "Insufficient funds!" + RESET);
            return;
        }

// _____________________________________________________________________________

        // Enter the amount to transfer.
        System.out.println("Enter amount to transfer:");
        double transferAmount = Double.parseDouble(sc.nextLine());

        if (transferAmount <= 0 || transferAmount > fromBalance) {
            System.out.println(RED + "Invalid amount. Transaction aborted." + RESET);
            return;
        }

// _____________________________________________________________________________

        // Choose the recipient.
        System.out.println("Enter recipient's person number:");
        long recipientPersonNumber = Long.parseLong(sc.nextLine());

        // Pin is irrelevant for finding users.
        User recipient = userManager.findUser(recipientPersonNumber, 0);
        if (recipient == null) {
            System.out.println(RED + "Recipient not found. Transaction aborted." + RESET);
            return; // Stop further execution.
        }

// _____________________________________________________________________________

        // Choose recipient account.
        System.out.println("Choose recipient's account:");
        System.out.println("1. Payroll a/c");
        System.out.println("2. Savings a/c");
        String toAccountChoice = sc.nextLine();

// _____________________________________________________________________________

        // Perform the transfer.
        if (fromAccountChoice.equals("1")) {
            loggedInUser.depositToPayroll(-transferAmount);
        } else {
            loggedInUser.depositToSavings(-transferAmount);
        }

        if (toAccountChoice.equals("1")) {
            recipient.depositToPayroll(transferAmount);
        } else {
            recipient.depositToSavings(transferAmount);
        }

        System.out.println(GREEN + "Transaction successful!" + RESET);
        System.out.println("Transferred " + transferAmount + " to " + recipientPersonNumber);

// _____________________________________________________________________________

    }

}
