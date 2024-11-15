
public class Program {

    public static void main(String[] args) {
        UsersArrayList hold = new UsersArrayList();
        for(int i = 0; i < 10; i++){
            hold.AddUser(new User("user "+ i, 300));
        }
        TransactionsList transactionsHold = new TransactionsLinkedList();
        for(int i = 0; i < 10; i += 2) {
            transactionsHold.addTransaction(new Transaction(hold.retrieveUserById(i+1), hold.retrieveUserById(i+2), Transaction.TransactionCategory.CREDIT, 50));
        }
        transactionsHold.removeTransactionById((transactionsHold.toArray()[0].getIdentifier()));
        Transaction[] holdArray = transactionsHold.toArray();
        for(int i = 0 ; i < holdArray.length ; i++) {
            System.out.println(holdArray[i].getIdentifier());
            
        }
    }
}
