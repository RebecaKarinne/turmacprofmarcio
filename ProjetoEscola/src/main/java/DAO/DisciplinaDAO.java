package DAO;

import infra.ConexaoMySQL;
import model.Disciplina;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DisciplinaDAO implements GenericDAO<Disciplina> {
    private ConexaoMySQL connection;
    private String query = "";
    Disciplina disciplina;

    @Override
    public boolean include(Disciplina disciplina) throws SQLException {
        this.query = "insert into Disciplina (codDisciplina, codProfessor, descDisciplina, cargaHoraria, ativa) " +
                "values (?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setInt(1, disciplina.getCodDisciplina());
            statement.setInt(2, disciplina.getCodProfessor());
            statement.setString(3, disciplina.getDescDisciplina());
            statement.setInt(4, disciplina.getCargaHoraria());
            statement.setBoolean(5, disciplina.isAtiva());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            return false;
        }
        return true;
    }

    @Override
    public void update(Disciplina disciplina) throws SQLException {
        this.query = "update Disciplina set cargaHoraria, ativa = ?, where codDisciplina = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setInt(1, disciplina.getCargaHoraria());
            statement.setBoolean(2, disciplina.isAtiva());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    public void updateStatusSubject (Disciplina disciplina) throws SQLException {
        this.query = "update Disciplina set ativa = ?, where codDisciplina = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setBoolean(1, disciplina.isAtiva());

            statement.execute()
        }
    }

    @Override
    public Disciplina findByOne(int id) throws SQLException {
        this.query = "select * from Disciplina where codDisciplina = " + id + ";";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Disciplina disciplina = null;
            while (resultSet.next()) {
                disciplina = new Disciplina(resultSet.getInt("codDisciplina"),
                                            resultSet.getInt("codProfessor"),
                                            resultSet.getString("descDisciplina"),
                                            resultSet.getInt("cargaHoraria"),
                                            resultSet.getBoolean("ativa"));
            }
            return disciplina;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }
}
