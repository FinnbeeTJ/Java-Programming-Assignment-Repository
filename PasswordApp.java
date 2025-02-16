// Part 2: Designing Your Own Custom Exceptions
// Name: Teddy Jones
// Course: COP3330.26824
// Date: February 09, 2025
// Program Objective: This program validates usernames and passwords based on custom rules.
// It uses custom exceptions to handle invalid input.
// Inputs: User provides username and password.
// Outputs: Program validates input and stores valid username/password pairs. Error messages for invalid inputs.
// Part 2: Designing Your Own Custom Exceptions

import java.util.Scanner;
import java.util.ArrayList;

// Custom Exception Class
// PasswordVerifyException: Custom exception class to represent password verification errors.
class PasswordVerifyException extends Exception {

// Constructor for PasswordVerifyException.
// @param message: The error message.
    public PasswordVerifyException(String message) {
        super(message);
    }
}

// Password Verification Class
// PasswordVerify: Class to represent a username and password and validate them.

class PasswordVerify {
    private String username;
    private String password;

//Constructor for PasswordVerify.
// @param username: The username.
// @param password: The password.
// @throws PasswordVerifyException: If the username or password is invalid.

    public PasswordVerify(String username, String password) throws PasswordVerifyException {
        this.username = username;
        this.password = password;

        // Validate the username.
        if (!isValidUsername(username)) {
            throw new PasswordVerifyException("Invalid username: Must be at least 6 characters and contain at least one digit.");
        }

        // Validate the password.
        if (!isValidPassword(password)) {
            throw new PasswordVerifyException("Invalid password: Must contain at least two uppercase letters and exactly 3 special characters (!, @, #, $, %).");
        }
    }
// isValidUsername: Checks if the username is valid.
// @param username: The username to check.
// @return: True if the username is valid, false otherwise.

    private boolean isValidUsername(String username) {
        if (username.length() < 6) {
            return false;
        }
        boolean hasDigit = false;
        for (char c : username.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
                break;
            }
        }
        return hasDigit;
    }

// isValidPassword: Checks if the password is valid.
// @param password: The password to check.
// @return: True if the password is valid, false otherwise.

    private boolean isValidPassword(String password) {
        int upperCount = 0;
        int specialCount = 0;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            } else if (c == '!' || c == '@' || c == '#' || c == '$' || c == '%') {
                specialCount++;
            }
        }
        return upperCount >= 2 && specialCount == 3;
    }

// toString: Returns a string representation of the PasswordVerify object.
// @return: A string representation of the PasswordVerify object.

    @Override
    public String toString() {
        return "Username: " + username + ", Password: " + password;
    }
}

// Main Application Class
public class PasswordApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<PasswordVerify> validUsers = new ArrayList<>();

        // Loop to get 4 valid user inputs.
        for (int i = 0; i < 4; i++) {
            // Display the password rules to the user.
            System.out.println("\n*Password Rules*");
            System.out.println("Username: Must be at least 6 characters and contain at least one digit.");
            System.out.println("Password: Must contain at least two uppercase letters and exactly 3 special characters (!, @, #, $, %).");

            // Prompt the user for a username.
            System.out.print("Enter username: ");
            String username = input.nextLine();

            // Prompt the user for a password.
            System.out.print("Enter password: ");
            String password = input.nextLine();

            // Try to create a PasswordVerify object.
            try {
                PasswordVerify user = new PasswordVerify(username, password);
                validUsers.add(user);
                System.out.println("User added successfully!");
            } catch (PasswordVerifyException e) {
                // Catch the PasswordVerifyException if the input is invalid.
                System.out.println("Error: " + e.getMessage());
                i--; // Decrement i to retry input for the same user
            }
        }

        // Print the valid users.
        System.out.println("\nValid Users:");
        for (PasswordVerify user : validUsers) {
            System.out.println(user);
        }
        input.close();
    }
}

}