package DAO;

import infra.ConexaoMySQL;
import model.Aluno;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlunoDAO implements GenericDAO<Aluno> {
    private ConexaoMySQL connection;
    private String query = "";
    Aluno aluno;

    @Override
    public boolean include(Aluno aluno) throws SQLException {
        this.query = "insert into Aluno (codAluno, nomeAluno, cpfAluno, dataNascimento,"
                + "dataMatricula, nomePai, nomeMae, responsavel, foneResponsavel, matriculado)"
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setInt(1, aluno.getCodAluno());
            statement.setString(2, aluno.getNomeAluno());
            statement.setString(3, aluno.getCpfAluno());
            statement.setDate(4, (Date) aluno.getDataNascimento());
            statement.setDate(5, (Date) aluno.getDataMatricula());
            statement.setString(6, aluno.getNomePai());
            statement.setString(7, aluno.getNomeMae());
            statement.setString(8, aluno.getResponsavel());
            statement.setString(9, aluno.getFoneResponsavel());
            statement.setBoolean(10, aluno.isMatriculado());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            return false;
        }
        return true;
    }

    @Override
    public void update(Aluno aluno) throws SQLException {
        this.query = "update Aluno set responsavel, foneResponsavel, matriculado = ?, where codAluno = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setString(1, aluno.getResponsavel());
            statement.setString(2, aluno.getFoneResponsavel());
            statement.setBoolean(3, aluno.isMatriculado());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    public void updateStatusStudent(Aluno aluno) throws SQLException {
        this.query = "update Aluno set matriculado = ?, where codAluno = ?;";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            statement.setBoolean(1, aluno.isMatriculado());

            statement.execute();
            this.connection.commit();
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }

    @Override
    public Aluno findByOne(int id) throws SQLException {
        this.query = "select * from Aluno where codAluno = " + id + ";";
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            Aluno aluno = null;
            while (resultSet.next()) {
                aluno = new Aluno(resultSet.getInt("codAluno"),
                        resultSet.getString("nomeAluno"),
                        resultSet.getString("cpfAluno"),
                        resultSet.getDate("dataNascimento"),
                        resultSet.getDate("dataMatricula"),
                        resultSet.getString("nomePai"),
                        resultSet.getString("nomeMae"),
                        resultSet.getString("responsavel"),
                        resultSet.getString("foneResponsavel"),
                        resultSet.getBoolean("matriculado"));
            }
            return aluno;
        } catch (SQLException e) {
            this.connection.rollback();
            throw e;
        }
    }
}
