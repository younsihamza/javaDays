import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList{
    private Transaction head;
    private Transaction tail;
    private Integer numberOfTransaction;


    class TransactionNotFoundException extends RuntimeException {
        TransactionNotFoundException(String s){
            super(s);
        }
    }

    TransactionsLinkedList(){
        head                = null;
        tail                = null;
        numberOfTransaction = 0;
    }
    public void addTransaction(Transaction transaction){
        if (head == null) {
            head                    = transaction;
            tail                    = transaction;
        }else {
            tail.nextTransaction    = transaction;
            tail                    = transaction;
        }
        numberOfTransaction++;
    }

    public void removeTransactionById(String id){
        Transaction currentTranstaction = head;
        Transaction previousTransaction = head;

        while(currentTranstaction != null) {
            if (currentTranstaction.getIdentifier() == id) {
                previousTransaction.nextTransaction = currentTranstaction.nextTransaction;
                numberOfTransaction--;
                return;
            }
            previousTransaction = currentTranstaction;
            currentTranstaction = currentTranstaction.nextTransaction;
        }
        throw new TransactionNotFoundException("transaction with id " + id + " not found");
    }

    public Transaction[] toArray() {
        Transaction[]            transactioArray;
        Transaction              tmp;

        if(numberOfTransaction == 0)
            return null;
        transactioArray = new Transaction[numberOfTransaction];
        tmp             = head;
        for(int i = 0; i < numberOfTransaction; i++) {
            transactioArray[i]  = tmp;
            tmp                 = tmp.nextTransaction; 
        }
        return transactioArray;
    }
}
