public class Program {

    public static void main(String[] args) {
        // Test User Initialization
        User user1 = new User( "Alice", 100.0);
        System.out.println(user1.getIdentifier());
        if (user1.getIdentifier() == 1 && user1.getName().equals("Alice") && user1.getBalance() == 100.0) {
            System.out.println("Test User Initialization: PASSED");
        } else {
            System.out.println("Test User Initialization: FAILED");
        }

        // Test Credit Transaction
        User user2 = new User( "Bob", 50.0);
        System.out.println(user2.getIdentifier());
        Transaction creditTransaction = new Transaction(user2, user1, Transaction.TransactionCategory.CREDIT, 20);
        
        if (user1.getBalance() == 120.0 && user2.getBalance() == 50.0) {
            System.out.println("Test Credit Transaction: PASSED");
        } else {
            System.out.println("Test Credit Transaction: FAILED");
        }

        // Test Debit Transaction with Sufficient Balance
        Transaction debitTransaction = new Transaction(user1, user2, Transaction.TransactionCategory.DEBIT, -30);
        
        if (user1.getBalance() == 90.0 && user2.getBalance() == 80.0) {
            System.out.println("Test Debit Transaction with Sufficient Balance: PASSED");
        } else {
            System.out.println("Test Debit Transaction with Sufficient Balance: FAILED");
        }

        // Test Debit Transaction with Insufficient Balance
        try {
            Transaction failedTransaction = new Transaction(user2, user1, Transaction.TransactionCategory.DEBIT, -100);
            System.out.println("Test Debit Transaction with Insufficient Balance: FAILED (No Exception Thrown)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test Debit Transaction with Insufficient Balance: PASSED");
        }

        // Additional Test Cases

        // Test User Initialization with Negative Balance
        try {
            User invalidUser = new User( "Charlie", -10.0);
            System.out.println("Test User Initialization with Negative Balance: FAILED (No Exception Thrown)");
        } catch (IllegalArgumentException e) {
            System.out.println("Test User Initialization with Negative Balance: PASSED");
        }

        // Test Invalid Transaction Category

        // Test Zero Amount Transaction
        double initialBalanceUser1 = user1.getBalance();
        double initialBalanceUser2 = user2.getBalance();

        Transaction zeroAmountTransaction = new Transaction(user1, user2, Transaction.TransactionCategory.CREDIT, 0);
        
        if (user1.getBalance() == initialBalanceUser1 && user2.getBalance() == initialBalanceUser2) {
            System.out.println("Test Zero Amount Transaction: PASSED");
        } else {
            System.out.println("Test Zero Amount Transaction: FAILED");
        }
    }
}
