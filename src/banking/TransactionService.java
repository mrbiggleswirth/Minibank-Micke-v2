// missing-recipient-fix branch

package banking;

import user_management.User;
import user_management.UserManager;

import java.util.Scanner;
import static utilities.Styling.*;


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

    // Constructor to accept UserManager instance.
    public TransactionService(UserManager userManager) {
        this.userManager = userManager;
    }

    // Method to handle transferring funds.
    public void transferFunds(User sender) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n" + MAGENTA + "Transfer Funds" + RESET);

        try {
            // Choose account to transfer FROM.
            System.out.println("Choose account to transfer FROM:");
            System.out.println("1. Payroll a/c");
            System.out.println("2. Savings a/c");
            String fromAccountChoice = sc.nextLine();

            double fromBalance = fromAccountChoice.equals("1") ?
                sender.getPayrollBalance() : sender.getSavingsBalance();

            if (fromBalance <= 0) {
                System.out.println(RED + "Insufficient funds!" + RESET);
                return;
            }

// _____________________________________________________________________________

            // Enter amount to transfer.
            System.out.println("Enter amount to transfer:");
            double transferAmount = Double.parseDouble(sc.nextLine());

            if (transferAmount <= 0 || transferAmount > fromBalance) {
                System.out.println(RED + "Invalid amount. Transaction aborted." + RESET);
                return;
            }

// _____________________________________________________________________________

            // Enter recipient's person number.
            System.out.println("Enter recipient's person number:");
            long recipientPersonNumber = Long.parseLong(sc.nextLine());

            // FIX: Find recipient **by person number only** (PIN should not matter).
            User recipient = null;
            for (User user : userManager.getUsers()) {
                if (user.getPersonNumber() == recipientPersonNumber) {
                    recipient = user;
                    break;
                }
            }

            if (recipient == null) {
                System.out.println(RED + "Recipient not found. Transaction aborted." + RESET);
                return;
            }

            /*
            User recipient = userManager.findUser(recipientPersonNumber, 0);
            if (recipient == null) {
                System.out.println(RED + "Recipient not found. Transaction aborted." + RESET);
                return; // Stop further execution.
            }
            */

// _____________________________________________________________________________

            // Choose recipient account.
            System.out.println("Choose recipient's account:");
            System.out.println("1. Payroll a/c");
            System.out.println("2. Savings a/c");
            String toAccountChoice = sc.nextLine();

// _____________________________________________________________________________

            // Perform the transfer.
            if (fromAccountChoice.equals("1")) {
                sender.depositToPayroll(-transferAmount);
            } else {
                sender.depositToSavings(-transferAmount);
            }

            if (toAccountChoice.equals("1")) {
                recipient.depositToPayroll(transferAmount);
            } else {
                recipient.depositToSavings(transferAmount);
            }

            System.out.println(GREEN + "Transaction successful!" + RESET);
            System.out.println("Transferred " + BRIGHT_YELLOW + transferAmount + RESET +
                " from " + sender.getPersonNumber() + " to " + recipient.getPersonNumber());

// _____________________________________________________________________________

        } catch (NumberFormatException e) {
            System.out.println(RED + "Invalid input. Transaction aborted." + RESET);
        }
    }
}
