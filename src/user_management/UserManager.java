package user_management;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    /**
     * ===== Business Logic, "User" Data Management =====
     *  - UserManager: Manages user data and handles user creation and look-up.
     */

    // List to store created users.
    private List<User> users = new ArrayList<>();

    // Method to create a new user and store it in the list.
    public User createUser(long personNumber, int pinCode) {
        User user = new User(personNumber, pinCode);
        users.add(user);
        return user;
    }

    // Method to retrieve the list of all users.
    public List<User> getUsers() {
        return users;
    }

// _____________________________________________________________________________

    // Method to find a user by their person number and PIN code (for login).
    public User findUser(long personNumber, int pinCode) {
        for (User user : users) {
            if (user.getPersonNumber() == personNumber && user.getPinCode() == pinCode) {
                return user;
            }
        }
        return null; // Return null if no matching user is found.
    }

// _____________________________________________________________________________



}
