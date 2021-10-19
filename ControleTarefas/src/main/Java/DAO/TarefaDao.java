package ControleTarefasBack.DAO;

import ControleTarefasBack.infra.ConexaoMySQL;
import ControleTarefasBack.model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDao implements GenericDAO<Tarefa>{
    private ConexaoMySQL connection;
    Tarefa tarefa;
    private String query = "";
    ArrayList<Tarefa> listaTarefas = new ArrayList<>();

    public TarefaDao() throws SQLException, ClassNotFoundException {
        connection = new ConexaoMySQL();
    }

    @Override
    public void include(Tarefa tarefa) throws SQLException {
        this.query = "insert into tarefa(idColaborador, descrTarefa, dataHoraInicio, dataHoraFim, statusTarefa, prioridadeTarefa)" +
                "values (?,?,?,?,?,?);";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setInt(1, tarefa.getIdColaborador());
            statement.setString(2, tarefa.getDescrTarefa());
            statement.setString(3, tarefa.getDataHoraInicio());
            statement.setString(4, tarefa.getDataHoraFim());
            statement.setString(5, tarefa.getStatusTarefa());
            statement.setString(6, tarefa.getPrioridadeTarefa());

            statement.execute();
            this.connection.commit();

        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    @Override
    public void update(Tarefa tarefa) throws SQLException {
        this.query = "update tarefa set descrTarefa, statusTarefa, prioridadeTarefa = ?, where idTarefa = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setString(1, tarefa.getDescrTarefa());
            statement.setString(2, tarefa.getStatusTarefa());
            statement.setString(3, tarefa.getPrioridadeTarefa());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    @Override
    public String delete(int id) throws SQLException {
        String status;
        this.query = "delete from tarefa where idTarefa = ?;";
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

    @Override
    public List<Tarefa> findAll() throws SQLException {
        this.query = "select * from tarefa;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<Tarefa> listaTarefas = new ArrayList<>();
            while (resultSet.next()) {
                Tarefa tarefa = new Tarefa(resultSet.getInt("idTarefa"),
                        resultSet.getInt("idColaborador"),
                        resultSet.getString("descrTarefa"),
                        resultSet.getString("dataHoraInicio"),
                        resultSet.getString("dataHoraFim"),
                        resultSet.getString("statusTarefa"),
                        resultSet.getString("prioridadeTarefa"));
                listaTarefas.add(tarefa);
            }
            return listaTarefas;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    @Override
    public Tarefa findByOne(int id) throws SQLException {
        this.query = "select * from tarefa where idTarefa = " + id + ";";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Tarefa tarefa = null;
            while (resultSet.next()) {
                tarefa = new Tarefa(resultSet.getInt("idTarefa"),
                        resultSet.getInt("idColaborador"),
                        resultSet.getString("descrTarefa"),
                        resultSet.getString("dataHoraInicio"),
                        resultSet.getString("dataHoraFim"),
                        resultSet.getString("statusTarefa"),
                        resultSet.getString("prioridadeTarefa"));
            }
            return tarefa;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }
}
