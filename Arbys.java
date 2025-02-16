import java.util.Scanner;

//Teddy Jones COP3330 CRN 26824 10 Jan 2025
//This code is for the purpose of creating a class for Arby's restaurant.

public class Arbys {

    // Fields
    private int curlyFryOrders;
    private static final double roastBeefPrice = 5.99; // Static price
    private static final double curlyFryPrice = 2.99;  // Static price
    private static final double jamochaShakePrice = 3.49; // Static price
    private String horseySauceType;

    // Getters and Setters
    public int getCurlyFryOrders() {
        return curlyFryOrders;
    }

    public void setCurlyFryOrders(int curlyFryOrders) {
        if (curlyFryOrders >= 0) {
            this.curlyFryOrders = curlyFryOrders;
        } else {
            System.out.println("Invalid input: Curly fry orders cannot be negative.");
        }
    }

    public String getHorseySauceType() {
        return horseySauceType;
    }

    public void setHorseySauceType(String horseySauceType) {
        if (horseySauceType != null && !horseySauceType.isEmpty()) {
            this.horseySauceType = horseySauceType;
        } else {
            System.out.println("Invalid input: Horsey sauce type cannot be null or empty.");
        }
    }

    // Custom Method
    public void weHaveTheMeats() {
        System.out.println("Arby's: We Have the Meats!");
    }

    // Constructor
    public Arbys(int curlyFryOrders, String horseySauceType) {
        this.curlyFryOrders = curlyFryOrders;
        this.horseySauceType = horseySauceType;
    }

    // Overloaded Constructor (sets fields to zero or null)
    public Arbys() {
        this.curlyFryOrders = 0;
        this.horseySauceType = null;
    }

    // Print Method (updated to include prices)
    public void printDetails() {
        System.out.println("Arby's Details:");
        System.out.println("Curly Fry Orders: " + curlyFryOrders);
        System.out.println("Roast Beef Price: $" + roastBeefPrice);
        System.out.println("Curly Fry Price: $" + curlyFryPrice);
        System.out.println("Jamocha Shake Price: $" + jamochaShakePrice);
        System.out.println("Horsey Sauce Type: " + horseySauceType);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of curly fry orders: ");
        int curlyFryOrders = scanner.nextInt();

        System.out.print("Enter the number of roast beef sandwiches: ");
        int roastBeefOrders = scanner.nextInt();

        System.out.print("Enter the number of Jamocha shakes: ");
        int jamochaShakeOrders = scanner.nextInt();

        scanner.nextLine(); // Consume newline

        System.out.print("Enter the type of horsey sauce: ");
        String horseySauceType = scanner.nextLine();

        Arbys arbys1 = new Arbys(curlyFryOrders, horseySauceType);

        // Calculate the total cost (using static prices)
        double totalCost = curlyFryOrders * curlyFryPrice +
                roastBeefOrders * roastBeefPrice +
                jamochaShakeOrders * jamochaShakePrice;

        // Format the total cost to 2 decimal places
        String formattedTotalCost = String.format("%.2f", totalCost);
        arbys1.printDetails();
        System.out.println("Your total is: $" + formattedTotalCost);
        arbys1.weHaveTheMeats();
    }
}