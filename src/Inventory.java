import java.util.HashMap;

public class Inventory {

    HashMap<String, Integer> purchasedItems = new HashMap<>();

    public Inventory() {

    }

    public void checkInventory() {
        if (purchasedItems.isEmpty()) {
            System.out.println("You haven't purchased any items yet!");
        } else {
            System.out.println("Current items you have purchased:");
            for (String item : purchasedItems.keySet()) {
                System.out.println("-->" + item + ", quantity: " + purchasedItems.get(item) + "<--");
            }
        }
    }
}
