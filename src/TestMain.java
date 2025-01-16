public class TestMain {
    public static void main(String[] args) {
        // Test creating users.
        User user1 = new User(101, 1234);
        User user2 = new User(102, 5678);
        User user3 = new User(6012310001L, 1234);
        User user4 = new User(7012310002L, 5678);

        // Check generated account numbers.
        System.out.println("\nUser 1 Payroll Account: " + user1.getPayrollAccount());
        System.out.println("User 1 Savings Account: " + user1.getSavingsAccount());
        System.out.println("\nUser 2 Payroll Account: " + user2.getPayrollAccount());
        System.out.println("User 2 Savings Account: " + user2.getSavingsAccount());
        //System.out.println("\nUser 3 Payroll Account: " + user3.getPayrollAccount());
        //System.out.println("User 3 Savings Account: " + user3.getSavingsAccount());
        //System.out.println("\nUser 4 Payroll Account: " + user4.getPayrollAccount());
        //System.out.println("User 4 Savings Account: " + user4.getSavingsAccount());

        // Validate account increments.
        assert user1.getPayrollAccount() + 1 == user2.getPayrollAccount();
        assert user1.getSavingsAccount() + 1 == user2.getSavingsAccount();

// _____________________________________________________________________________

        // Simulate login
        if (user1.getPersonNumber() == 101 && user1.getPinCode() == 1234) {
            System.out.println("\nUser 1 logged in successfully!");
        } else {
            System.out.println("\nLogin failed for User 1.");
        }

        if (user2.getPersonNumber() == 102 && user2.getPinCode() == 5678) {
            System.out.println("User 2 logged in successfully!");
        } else {
            System.out.println("\nLogin failed for User 2.");
        }


        if (user3.getPersonNumber() == 6012310001L && user2.getPinCode() == 9999) {
            System.out.println("User 3 logged in successfully!");
        } else {
            System.out.println("\nLogin failed for User 3.");
        }

// _____________________________________________________________________________

        // Test deposit and balance checks
        user1.depositToPayroll(500);
        user1.depositToSavings(1000);
        System.out.println("\nUser 1 Payroll Balance: " + user1.getPayrollBalance());  // Expected 1500.
        System.out.println("User 1 Savings Balance: " + user1.getSavingsBalance());  // Expected 2000.

        user2.depositToPayroll(300);
        user2.depositToSavings(700);
        System.out.println("\nUser 2 Payroll Balance: " + user2.getPayrollBalance());  // Expected 1300.
        System.out.println("User 2 Savings Balance: " + user2.getSavingsBalance());  // Expected 1700.

// _____________________________________________________________________________



    }
}
