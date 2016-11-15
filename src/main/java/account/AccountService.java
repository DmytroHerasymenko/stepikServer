package account;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dima on 15.11.16.
 */
public class AccountService {
    private  final Map<String, UserProfile> loginToProfile;
    private final Map<String, UserProfile> sessionToProfile;

    public AccountService() {
        loginToProfile = new HashMap<>();
        sessionToProfile = new HashMap<>();
    }

    public void addNewUser(UserProfile userProfile){
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }
    public UserProfile getUserByLogin(String login){
        return loginToProfile.get(login);
    }
    public UserProfile getUserBySession ( String session){
        return sessionToProfile.get(session);
    }
    public void addSession(String session, UserProfile profile){
        sessionToProfile.put(session, profile);
    }
    public void deleteSession(String session){
        sessionToProfile.remove(session);
    }
}
