package services;
import repository.*;
import models.*;
import exceptions.*;
public class UserServiceImpl {
    private UsersRepository usersRepository;

    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public boolean authenticate(String login, String password) {
        User user  = this.usersRepository.findByLogin(login);
        if(user.isAuthStatus())
            throw new AlreadyAuthenticatedException();
        if(password.equals(user.getPassword())){
            user.setAuthStatus(true);
            this.usersRepository.update(user);
            return true;
        } 
        return false;
    }
}
