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
    static AuthenticationService authenticationService = new AuthenticationService(userManager);
    static Styling st = new Styling();

    public static void main(String[] args) {
        boolean active = true;
        while (active) {
            System.out.println("\n" + st.MAGENTA + "Bank Application" + st.RESET);
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
                    // Delegate login to AuthenticationService.
                    authenticationService.login();
                    break;
                case "3":
                    active = false;
                    break;
            }
        }
    }
}
