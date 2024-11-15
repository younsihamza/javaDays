import java.util.UUID;



public class Transaction {
    private String Identifier;
    private User Recipient;
    private User Sender;
    private TransactionCategory transactionCategory;
    private double transfetAmount;
    public enum TransactionCategory {
        DEBIT("debit"),
        CREDIT("credit");
        
        TransactionCategory(final String txt){
            
        }
    }
    public Transaction(User Sender, User Recipient, TransactionCategory transactionCategory,double transfetAmount) {
        this.Sender                 = Sender;
        this.Recipient              = Recipient;
        this.transactionCategory    = transactionCategory;
        this.transfetAmount         = transfetAmount;
        this.Identifier             = UUID.randomUUID().toString();
    
        if (transactionCategory == TransactionCategory.DEBIT && transfetAmount < 0 ){
            if(Sender.getBalance() > transfetAmount*-1){
                Sender.setBalance(transfetAmount);
                Recipient.setBalance(transfetAmount*-1);
            }
        }else if(transfetAmount > 0 && transactionCategory == TransactionCategory.CREDIT ){
            Recipient.setBalance(transfetAmount);
        }
    }
    TransactionCategory getTransactionCategory() {
        return transactionCategory;
    }

    UUID getIdentifier(){
        return Identifier;
    }

    double getTransfetAmount() {
        return transfetAmount;
    }

}


