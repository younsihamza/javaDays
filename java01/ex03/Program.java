public class Program {

    public static void main(String[] args) {
        UsersArrayList hold = new UsersArrayList();
        for(int i = 0; i < 100; i++){
            hold.AddUser(new User("user "+ i, i));
        }
            System.out.println(hold.retrieveNumberOfUsers());
    }
}
