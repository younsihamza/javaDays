
public interface UserList { 
        void AddUser(User user);
        User retrieveUserById(Integer id);
        User retrieveUserByIndex(Integer id);
        Integer retrieveNumberOfUsers();
}
