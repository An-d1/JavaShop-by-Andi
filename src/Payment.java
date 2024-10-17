import java.util.Scanner;

public class Payment {

    public int purchasedQuantity;
    Scanner scan = new Scanner(System.in);

    public void handlePayment(String itemName, double itemPrice, Account account, Inventory inventory) {

        System.out.println("Input the quantity");
        purchasedQuantity = scan.nextInt();
        double totalPrice = purchasedQuantity * itemPrice;

        if (totalPrice <= account.accountBalance) {
            account.accountBalance -= totalPrice;
            System.out.println("Transaction done successfully, new balance: " + account.accountBalance);

            // Check if item exists in inventory and update quantity
            if (inventory.purchasedItems.containsKey(itemName)) {
                // Update the existing quantity
                int currentQuantity = inventory.purchasedItems.get(itemName);
                inventory.purchasedItems.put(itemName, currentQuantity + purchasedQuantity);
            } else {
                // Add new item to inventory
                inventory.purchasedItems.put(itemName, purchasedQuantity);
            }

        } else {
            System.out.println("Insufficient funds, deposit at least: " + (totalPrice - account.accountBalance) + "€");
        }
    }
}
