import user_management.User;
import user_management.UserManager;
import java.util.Scanner;
import static utilities.Styling.*;

public class AuthNService {
    /**
     * Is responsible for all login-related logic.
     */

    private UserManager userManager;

    public AuthNService(UserManager userManager) {
        this.userManager = userManager;
    }

    public User login() {
        int attempts = 0; // Track the number of login attempts.
        final int MAX_ATTEMPTS = 3; // Maximum allowed attempts.
        Scanner sc = new Scanner(System.in);

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter person number:");
            long personNumber = Long.parseLong(sc.nextLine());

            System.out.println("Enter PIN code:");
            int pinCode = Integer.parseInt(sc.nextLine());

            User user = userManager.findUser(personNumber, pinCode);
            if (user != null) {
                System.out.println("Logged in successfully!");

                System.out.println("Payroll a/c no: " + user.getPayrollAccount() +
                    " , Balance: " + BRIGHT_YELLOW + user.getPayrollBalance() + RESET);

                System.out.println("Savings a/c no: " + user.getSavingsAccount() +
                    " , Balance: " + BRIGHT_YELLOW + user.getSavingsBalance() + RESET);
                return user; // Return the logged-in user.
            }

            attempts++; // Increment attempt counter.
            System.out.println("Invalid person number or PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));

            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Maximum login attempts reached. Exiting program.");
                System.exit(0); // Exit after 3 failed attempts.
            }
        }
        return null; // In case the user fails to log in.
    }
}
