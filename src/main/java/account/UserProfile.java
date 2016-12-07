package account;

/**
 * Created by dima on 15.11.16.
 */
public class UserProfile {
    private final String login;
    private final String password;
    private final String email;

    public UserProfile(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public UserProfile(String login){
        this.login = login;
        this.password = login;
        this.email = login;
    }
    public UserProfile(String login, String password){
        this.login=login;
        this.password = password;
        this.email = login + "@mail";
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
