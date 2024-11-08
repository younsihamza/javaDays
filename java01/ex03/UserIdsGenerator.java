

public class UserIdsGenerator {
    private Integer currentId = 1;
    private static UserIdsGenerator cashObject= null;

    public static UserIdsGenerator getInstance(){
        if(UserIdsGenerator.cashObject == null)
            UserIdsGenerator.cashObject = new UserIdsGenerator();
        return UserIdsGenerator.cashObject;
    }

    public Integer generateId() {
        return this.currentId++;
    } 

    private UserIdsGenerator() { }
}

