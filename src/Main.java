import banking.TransactionService;
import user_management.User;
import user_management.UserManager;
import user_management.UserService;
import user_management.UserMenu;
import java.util.Scanner;
import static utilities.Styling.*;

public class Main {
    /**
     * ===== Summary =====
     *
     * - AuthNService: Handles user login and authentication (AuthN).
     *         - User: Represents user data and behavior (a/c details, balance).
     *  - UserManager: Manages user data and handles user creation and look-up.
     *  - UserService: Manages user creation and logic related to user setup.
     *     - UserMenu: Displays user-specific menu options & handles user interactions.
     *
     * - TransactionService: Manages all transaction-related operations.
     *            - Styling: Provides styling and color codes for Terminal output.
     *
     * ___________________________________________________________________________________
     *
     * The Main class delegates tasks like user creation, login, and transactions
     * to appropriate services, focusing solely on managing the application flow.
     *
     * Shared State:
     * 'UserManager' holds the list of users. By passing the same instance to services,
     * all classes access and modify the same data consistently.
     */

    static Scanner sc = new Scanner(System.in);
    static UserManager userManager = new UserManager(); // Shared instance.
    static UserService userService = new UserService(userManager); // Pass it here.
    static AuthNService authNService = new AuthNService(userManager);
    static TransactionService transactionService = new TransactionService(userManager);

    public static void main(String[] args) {
        boolean active = true;
        while (active) {
            System.out.println("\n" + MAGENTA + "Bank Application" + RESET);
            System.out.println("1. Create user with Savings & Payroll accounts.");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            String selection = sc.nextLine();
            switch (selection) {
                case "1":
                    // Delegate user creation to 'UserService'.
                    userService.createUser();
                    break;
                case "2":
                    // Delegate login to 'AuthNService'.
                    User loggedInUser = authNService.login();
                    if (loggedInUser != null) {
                        UserMenu userMenu = new UserMenu(loggedInUser, transactionService); // Pass logged-in user to 'UserMenu'.
                        userMenu.showUserMenu(); // Show the user menu after successful login.
                    }
                    break;
                case "3":
                    active = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }
}
