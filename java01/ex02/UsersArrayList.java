public class UsersArrayList implements UserList {

    private User []  users          = new User[10];
    private Integer currentSize     = 0;
    private Integer maxSize         = 10;

    public class UserNotFoundException extends RuntimeException {
        UserNotFoundException(String s) {
            super(s);
        }
    }
    private User [] copyList(Integer currentSize, User[] oldList) {
        User[] newList = new User[currentSize + (int)(currentSize / 2)];
        for(int i = 0; i < currentSize ; i++) {
            newList[i] = oldList[i];
        }
        return newList;
    }

    public void AddUser(User user) {
        if (currentSize >= maxSize) {
            maxSize += (int)(currentSize / 2);
            users = this.copyList(currentSize, users);
        }
        this.users[currentSize] = user;
        currentSize++;
    }
    
    public User retrieveUserById(Integer id){
        for (Integer i = 0; i < this.currentSize; i++){
                if (users[i].getIdentifier() == id) {
                    return users[i];
                }
        }
        throw (new UserNotFoundException("user not found with id " + id));
    }

    public User retrieveUserByIndex(Integer index) {
        if(index >= currentSize || index < 0)
            throw new UserNotFoundException("not user  at index " + index );
        return users[index];
    }

    public Integer retrieveNumberOfUsers(){
        return currentSize;
    }
}
