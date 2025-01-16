public class User {
    private static int nextPayrollAccountNumber = 10; // Start from 10.
    private static int nextSavingsAccountNumber = 10; // Start from 10.

    private long personNumber;
    private int pinCode;
    private int payrollAccount;
    private int savingsAccount;
    private double payrollBalance = 1000;  // Initialize balance to 1000.
    private double savingsBalance = 1000;  // Initialize balance to 1000.

    // Constructor
    public User(long personNumber, int pinCode) {
        this.personNumber = personNumber;
        this.pinCode = pinCode;
        this.payrollAccount = generatePayrollAccount();
        this.savingsAccount = generateSavingsAccount();
    }

// _____________________________________________________________________________
// Bank accounts management

    // Generate a unique payroll account number.
    private static int generatePayrollAccount() {
        return nextPayrollAccountNumber++;
    }

    // Generate a unique savings account number.
    private static int generateSavingsAccount() {
        return nextSavingsAccountNumber++;
    }

    public void depositToPayroll(double amount) {
        payrollBalance += amount;
    }

    public void depositToSavings(double amount) {
        savingsBalance += amount;
    }

// _____________________________________________________________________________
// Getters

    public int getPayrollAccount() {
        return payrollAccount;
    }

    public int getSavingsAccount() {
        return savingsAccount;
    }

    public double getPayrollBalance() {
        return payrollBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public long getPersonNumber() {
        return personNumber;
    }

    public int getPinCode() {
        return pinCode;
    }

// _____________________________________________________________________________

}
