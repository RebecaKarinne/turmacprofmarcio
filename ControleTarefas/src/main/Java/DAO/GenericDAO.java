package ControleTarefasBack.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {

    void include(T t) throws SQLException;
    void update(T t) throws SQLException;
    String delete(int id) throws SQLException;
    List<T> findAll() throws SQLException;
    T findByOne(int id) throws SQLException;

}
