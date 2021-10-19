package ControleTarefasBack.DAO;

import ControleTarefasBack.model.Colaborador;
import ControleTarefasBack.infra.ConexaoMySQL;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColaboradorDao implements GenericDAO<Colaborador> {
    private ConexaoMySQL connection;
    private String query = "";
    Colaborador colaborador;
    ArrayList<Colaborador> listaColaboradores = new ArrayList<>();

    public ColaboradorDao() throws SQLException, ClassNotFoundException {
        connection = new ConexaoMySQL();
    }

    // Método para INSERIR colaborador na tabela Colaborador
    @Override
    public void include(Colaborador colaborador) throws SQLException {
        this.query = "insert into colaborador (nomeColaborador) values (?);";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setString(1, colaborador.getNomeColaborador());
            statement.execute();

            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    // Método para ALTERAR colaborador da tabela Colaborador
    @Override
    public void update(Colaborador colaborador) throws SQLException {
        this.query = "update colaborador set nomeColaborador = ?, where idColaborador = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setString(1, colaborador.getNomeColaborador());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    // Método para EXCLUIR colaborador da tabela Colaborador
    @Override
    public String delete(int id) throws SQLException {
        String status;
        this.query = "delete from colaborador where idColaborador = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setInt(1, id);

            statement.execute();
            this.connection.commit();
            status = "Deleted!";
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
        return status;
    }

    // Método para LISTAR todos os colaboradores da tabela Colaborador
    @Override
    public List<Colaborador> findAll() throws SQLException {
        this.query = "select * from colaborador;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<Colaborador> listaColaboradores = new ArrayList<>();
            while (resultSet.next()) {
                Colaborador colaborador = new Colaborador(resultSet.getInt("idColaborador"),
                        resultSet.getString("nomeColaborador"));
                listaColaboradores.add(colaborador);
            }
            return listaColaboradores;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    // Método para DETALHAR apenas um colaborador da tabela Colaborador
    @Override
    public Colaborador findByOne(int id) throws SQLException {
        this.query = "select * from colaborador where idColaborador = " + id + ";";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            Colaborador colaborador = null;

            while (resultSet.next()) {
                colaborador = new Colaborador(resultSet.getString("nomeColaborador"));
            }
            return colaborador;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }
}
