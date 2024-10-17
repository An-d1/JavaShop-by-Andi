import java.util.UUID;

public class Account {

    private UUID id;
    private String name;
    private String lastName;
    public double accountBalance;
    public Account(UUID id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.accountBalance = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful, new balance " + accountBalance + "€");
        } else {
            System.out.println("Deposited amount must be greater than 0!");
        }
    }

}
