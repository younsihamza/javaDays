package models;

public class User {
    private Long id;
    private String login;
    private String password;
    private boolean authStatus;
    
    
    public User(long id, String login, String password, boolean authStatus) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.authStatus = authStatus;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAuthStatus() {
        return authStatus;
    }
    public void setAuthStatus(boolean authStatus) {
        this.authStatus = authStatus;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        return true;
    } 
}
