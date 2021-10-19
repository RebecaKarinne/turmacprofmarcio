package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoMySQL {

    private Connection connection = null;

    // Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/escola?useTimezone=true&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD  = "251116";

    public ConexaoMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        this.connection.setAutoCommit(false);
    }


    public Connection getConnection(){
        return this.connection;
    }

    public void close(){
        if(this.connection != null){
            // tenta executar esse bloco de comando
            try {
                this.connection.close();
            } catch (SQLException e){
                Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public void commit() throws SQLException {
        this.connection.commit();
        this.close();
    }

    public void rollback(){
        if(this.connection != null){
            // tenta executar esse bloco de comando
            try {
                this.connection.rollback();
            } catch (SQLException e){
                Logger.getLogger(ConexaoMySQL.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
