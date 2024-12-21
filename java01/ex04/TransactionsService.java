import java.util.UUID;
public class TransactionsService {
    UserList users = null;



    TransactionsService(){
        this.users  = new UsersArrayList(); 
    }
    void addUser(User user) {
        users.AddUser(user);
    }

    double retrieveUserBalance(Integer id) {
        return users.retrieveUserById(id).getBalance();
    }

    void performTransaction(Integer senderId, Integer recipientId, Integer amount) {

    }

    Transaction[] userTransactions(Integer userId) {
        return users.retrieveUserById(userId).getTransactions().toArray();
    }
    
    void removeTransaction(String transactionId, Integer userId) {
        users.retrieveUserById(userId).getTransactions().removeTransactionById(transactionId);
    }

    Transaction[] checkValidityTransactions() {
        
    }

}
