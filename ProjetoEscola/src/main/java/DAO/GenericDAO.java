package DAO;

import java.sql.SQLException;

public interface GenericDAO<T> {

    boolean include(T t) throws SQLException;
    void update (T t) throws SQLException;
    T findByOne (int id) throws SQLException;

}
