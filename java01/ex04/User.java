import java.lang.Integer;
import java.util.UUID;



public class User {
    final private Integer id;
    private String name;
    private double balance = 0;
    TransactionsList userTransactions;

    public User( String name, double balance) {
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        if (balance > 0 )
            this.balance = balance;
    }

    Integer getIdentifier() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    double getBalance() {
        return this.balance;
    }
    void setBalance(double amount) {
        this.balance += amount;
    }

    TransactionsList getTransactions() {
        return this.userTransactions;
    }
} 