// Part 1: Throwing and Catching a Basic Exception
// Name: Teddy Jones
// Course: COP3330.26824
// Date: February 9, 2025
// Program Objective: This program takes two integers as input from the user and performs division.
// It handles the ArithmeticException that occurs when dividing by zero.
// Inputs: Two integers from the user.
// Outputs: The result of the division or an error message if division by zero is attempted.

import java.util.Scanner;

public class Division { // Class name changed to Division

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num1 = 0; // Initialize num1
        int num2 = 0; // Initialize num2
        boolean validInput = false; // Flag to control the loop

        while (!validInput) { // Loop until valid input is received
            System.out.print("Enter the first integer: ");
            if (input.hasNextInt()) { // Check if input is an integer
                num1 = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Clear the invalid input
                continue; // Go to the next iteration of the loop
            }

            System.out.print("Enter the second integer: ");
            if (input.hasNextInt()) { // Check if input is an integer
                num2 = input.nextInt();
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                input.next(); // Clear the invalid input
                continue; // Go to the next iteration of the loop
            }


            if (num2 == 0) {
                System.out.println("Please Enter A Valid Number. You cannot divide by Zero");
            } else {
                try {
                    double result = (double) num1 / num2;
                    System.out.printf("%d / %d = %.2f\n", num1, num2, result);
                    validInput = true; // Set flag to true to exit the loop
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
        input.close();

    }
}