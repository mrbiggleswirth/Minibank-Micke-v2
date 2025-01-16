public class TestMain2 {
    public static void main(String[] args) {
        // Step 1: Create an account with person number 991231009 and PIN code 9999.
        User user1 = new User(991231009, 9999);
        System.out.println("User created with Person Number: " + user1.getPersonNumber() + " and PIN Code: " + user1.getPinCode());

        // Step 2: Test 4 wrong login attempts with PIN code 0004.
        testLogin(user1, 991231009, 0004);  // First wrong attempt
        testLogin(user1, 991231009, 0004);  // Second wrong attempt
        testLogin(user1, 991231009, 0004);  // Third wrong attempt
        testLogin(user1, 991231009, 0004);  // Fourth wrong attempt (should exit)

        // Step 3: Test correct login with PIN code 9999.
        testLogin(user1, 991231009, 9999);  // Correct login
    }

    // Helper method to simulate login and print results.
    private static void testLogin(User user, long personNumber, int pinCode) {
        int maxAttempts = 3;
        int attempts = 0;

        while (attempts < maxAttempts) {
            if (user.getPersonNumber() == personNumber && user.getPinCode() == pinCode) {
                System.out.println("Login successful for Person Number: " + personNumber);
                return;
            } else {
                attempts++;
                System.out.println("Invalid login attempt " + attempts + " for Person Number: " + personNumber);
                if (attempts == maxAttempts) {
                    System.out.println("Too many wrong attempts. Program will exit.");
                    System.exit(0);  // Exits the program after 3 wrong attempts.
                }
            }
        }
    }
}
