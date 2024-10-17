import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Account user01 = null;
        Inventory inventory01 = new Inventory();

        while(true) {
            System.out.println("1. Create an account");
            System.out.println("2. Deposit money into account: ");
            System.out.println("3. Shop online: ");
            System.out.println("4. Check inventory: ");
            System.out.println("5. Exit");
            System.out.println("Please chose an option: ");
            int option = scan.nextInt();
            switch (option) {
                case 1:
                    UUID id = UUID.randomUUID();
                    System.out.println("your id is: " + id + "\n Please insert your name: ");
                    String name = scan.next();
                    System.out.println("Please insert your last name: ");
                    String lastName = scan.next();
                    System.out.println("Account, created successfully: ");
                    user01 = new Account(id, name, lastName);
                    break;
                case 2:
                    if (user01 != null) {
                        System.out.println("Insert the initial amount you wish to deposit");
                        double depositAmount = scan.nextDouble();
                        user01.deposit(depositAmount);
                    } else {
                        System.out.println("No account found, please create an account first! ");
                    }
                    break;
                case 3:
                    if (user01 != null) {
                        Payment paymentHandle = new Payment();
                        int counter = 0;
                        while (counter == 0) {
                            System.out.println("== List of items, balance: " + user01.accountBalance);
                            System.out.println("1. White t-shirt -> 50€");
                            System.out.println("2. Sneakers -> 70€");
                            System.out.println("3. Blue jeans -> 35€");
                            System.out.println("4. Red dress -> 55€");
                            System.out.println("5. Yellow shirt -> 15€");
                            System.out.println("6. Black sweatpants -> 40€");
                            System.out.println("Choose a product: ");
                            int option1 = scan.nextInt();

                            switch (option1) {
                                case 1:
                                    paymentHandle.handlePayment("White t-shirt", 50, user01, inventory01);
                                    break;
                                case 2:
                                    paymentHandle.handlePayment("Sneakers", 70, user01, inventory01);
                                    break;
                                case 3:
                                    paymentHandle.handlePayment("Blue Jeans", 35, user01, inventory01);
                                    break;
                                case 4:
                                    paymentHandle.handlePayment("Red dress", 55, user01, inventory01);
                                    break;
                                case 5:
                                    paymentHandle.handlePayment("Yellow shirt", 15, user01, inventory01);
                                    break;
                                case 6:
                                    paymentHandle.handlePayment("Black sweatpants", 40, user01, inventory01);
                                    break;
                                default:
                                    System.out.println("Invalid choice.");
                                    break;
                            }
                            counter++; // Exit the loop after one purchase
                        }
                    } else {
                        System.out.println("No account found, please create an account first!");
                    }
                    break;

                case 4:
                    System.out.println(" ");
                    inventory01.checkInventory();
                    System.out.println(" ");
                    break;

                case 5:
                    System.out.println("Thank you for choosing us! ");
                    System.exit(0);
            }
        }

    }
}

