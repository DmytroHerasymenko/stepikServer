package dbService;

import dbService.dataSets.UsersDataSet;


/**
 * Created by dima on 09.12.16.
 */
public interface DBService {
    long addUser(String login, String password) throws DBException;

     UsersDataSet getUser(long userId) throws DBException;

     UsersDataSet getUserByLogin(String login) throws DBException;
}
