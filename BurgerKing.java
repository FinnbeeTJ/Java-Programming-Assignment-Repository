import java.util.Scanner;
//Teddy Jones COP3330 CRN 26824 17 Jan 2025
//This program creates a class for Burger King

public class BurgerKing {

    //Fields
    private int whopperOrders;
    private static final double whopperPrice = 4.99; //Static Price
    private static final double friesPrice = 2.49; //Static Price
    private static final double milkshakePrice = 2.99; //Static Price
    private static String ketchupType;

    //Getters and Setters
    public int getWhopperOrders() {
        return whopperOrders;
    }
    public void setWhopperOrders(int whopperOrders) {
        if (whopperOrders >= 0) {
            this.whopperOrders = whopperOrders;
        } else {
            System.out.println("Invalid whopper order: Whopper order cannot be negative!");
        }
    }
    public String getKetchupType() {
        return ketchupType;
    }
    public void setKetchupType(String ketchupType) {
        if (ketchupType != null && !ketchupType.isEmpty()) {
            this.ketchupType =ketchupType;
        } else {
            System.out.println("Invalid ketchup type: Ketchup amount cannot be empty!");
        }
    }
    //Custom Method
    public void haveItYourWay () {
        System.out.println("Burger King:Have It Your Way!");
    }
    //Constructor
    public BurgerKing(int whopperOrders, String ketchupType) {
        this.whopperOrders = whopperOrders;
        this.ketchupType = ketchupType;
    }
    //Overloaded Constructor should set fields to null or zero
    public BurgerKing() {
        this.whopperOrders = 0;
        this.ketchupType = null;
    }
    //Printing methods (cost shown to customers)
    public void printDetails() {
        System.out.println("Burger King Details:" );
        System.out.println("Whopper Orders: " + whopperOrders);
        System.out.println("Whopper Price: $" + whopperPrice);
        System.out.println("Fries Price: $" + friesPrice);
        System.out.println("Milk Shake Price: $" + milkshakePrice);
        System.out.println("Ketchup Type: " + ketchupType);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Whopper orders: ");
        int whopperOrders = scanner.nextInt();

        System.out.print("Enter the number of fries orders: ");
        int friesOrders = scanner.nextInt();

        System.out.print("Enter the number of milkshakes: ");
        int milkshakeOrders = scanner.nextInt();

        scanner.nextLine(); // Consume newline

        System.out.print("Do you want Ketchup?"); // Corrected line
        String ketchupType = scanner.nextLine();

        BurgerKing bk = new BurgerKing(whopperOrders, ketchupType);

        //Calculating Total Cost
        double totalCost = whopperOrders*whopperPrice+friesOrders*friesPrice+milkshakeOrders*milkshakePrice;

        //Format Cost limit to two decimal places
        String formattedTotalCost = String.format("%.2f", totalCost);
        bk.printDetails();
        System.out.println("Your total cost is: " + formattedTotalCost);
        bk.haveItYourWay();
    }
}

