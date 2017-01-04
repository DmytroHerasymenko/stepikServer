package accountServer;

/**
 * Created by dima on 04.01.17.
 */
public interface AccountServerI {
    void addNewUser();

    void removeUser();

    int getUsersLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
}
