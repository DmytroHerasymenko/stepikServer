package dbService.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dima on 02.12.16.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
