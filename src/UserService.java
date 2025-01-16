import java.util.Scanner;

public class UserService {
    /**
     * UserService has the responsibility of handling the user creation logic.
     * It is responsible for gathering user input (person number & PIN).
     * It delegates the actual user creation to the UserManager.
     *
     * Pass the existing UserManager from Main to UserService instead of creating a new one.
     */

    private UserManager userManager;

    // Constructor to accept a UserManager instance.
    public UserService(UserManager userManager) {
        this.userManager = userManager;
    }

    public void createUser() {
        /**
         * TODO: Add more fields like name, adress here.
         */

        // Handle user input and delegate the creation to UserManager.
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter person number:");
        long personNumber = Long.parseLong(sc.nextLine());

        System.out.println("Enter PIN code:");
        int pinCode = Integer.parseInt(sc.nextLine());

        // Call the createUser method in UserManager.
        User user = userManager.createUser(personNumber, pinCode);
        System.out.println("User created!");
        System.out.println("Payroll Account: " + user.getPayrollAccount());
        System.out.println("Savings Account: " + user.getSavingsAccount());
    }

    /**
     * TODO: Add more user-related operations in the future
     * (updating user info, deleting users),
     * add those method to UserService without cluttering Main class.
     */
}
