import java.util.Scanner;

public class Main {
    /**
     * The Main class delegates the task of user creation to UserService.
     * This makes it less cluttered and focuses more on managing the app's flow.
     * Such as displaying menus and handling user choices.
     */


    static Scanner sc = new Scanner(System.in);
    static UserManager userManager = new UserManager(); // Shared instance.
    static UserService userService = new UserService(userManager); // Pass it here.

    public static void main(String[] args) {
        boolean active = true;
        while (active) {
            System.out.println("\nBank Application");
            System.out.println("1. Create user with Savings & Payroll accounts.");
            System.out.println("2. Log in");
            System.out.println("3. Exit");

            String selection = sc.nextLine();
            switch (selection) {
                case "1":
                    // Delegate user creation to UserService.
                    userService.createUser();
                    break;
                case "2":
                    login();
                    break;
                case "3":
                    active = false;
                    break;
            }
        }
    }

// _____________________________________________________________________________

    static void login() {
        int attempts = 0; // Track the number of login attempts.
        final int MAX_ATTEMPTS = 3; // Maximum allowed attempts.

        while (attempts < MAX_ATTEMPTS) {
            System.out.println("Enter person number:");
            long personNumber = Long.parseLong(sc.nextLine());

            System.out.println("Enter PIN code:");
            int pinCode = Integer.parseInt(sc.nextLine());

            User user = userManager.findUser(personNumber, pinCode);
            if (user != null) {
                System.out.println("Logged in successfully!");
                System.out.println("Payroll Account: " + user.getPayrollAccount());
                System.out.println("Savings Account: " + user.getSavingsAccount());
                return; // Exit the login method on successful login.
            }

            attempts++; // Increment attempt counter.
            System.out.println("Invalid person number or PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));

            if (attempts >= MAX_ATTEMPTS) {
                System.out.println("Maximum login attempts reached. Exiting program.");
                System.exit(0); // Exit the program after 3 failed attempts.
            }
        } // while loop
    } // login method

// _____________________________________________________________________________

}
