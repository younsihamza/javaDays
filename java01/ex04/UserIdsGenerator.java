

public class UserIdsGenerator {
    private Integer currentId = 1;
    private static UserIdsGenerator cachObject= null;

    public static UserIdsGenerator getInstance(){
        if(UserIdsGenerator.cachObject == null)
            UserIdsGenerator.cachObject = new UserIdsGenerator();
        return UserIdsGenerator.cachObject;
    }

    public Integer generateId() {
        return this.currentId++;
    } 

    private UserIdsGenerator() { }
}

