package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by dima on 02.12.16.
 */
public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String name) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        return ((UsersDataSet) criteria.add(Restrictions.eq("name", name)).uniqueResult()).getId();
    }

    public long insertUser(String name) throws HibernateException {
        return (Long) session.save(new UsersDataSet(name));
    }

}
