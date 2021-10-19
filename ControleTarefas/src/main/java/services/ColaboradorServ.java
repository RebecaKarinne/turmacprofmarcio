package services;

import DAO.ColaboradorDao;
import DAO.TarefaDao;
import model.Colaborador;
import model.Tarefa;

import java.sql.SQLException;
import java.util.List;

public class ColaboradorServ {

    private ColaboradorDao dao;

    public ColaboradorServ() throws SQLException, ClassNotFoundException{}

    public void include(Colaborador colaborador) throws SQLException, ClassNotFoundException{
        dao = new ColaboradorDao();
        dao.include(colaborador);
    }

    public void update(Colaborador colaborador) throws SQLException, ClassNotFoundException{
        dao = new ColaboradorDao();
        dao.update(colaborador);
    }

    public String delete(int id) throws SQLException, ClassNotFoundException{
        dao = new ColaboradorDao();
        return dao.delete(id);
    }

    public List<Colaborador> findAll() throws SQLException, ClassNotFoundException{
        dao = new ColaboradorDao();
        return dao.findAll();
    }

    public Colaborador findByOne(int id) throws SQLException, ClassNotFoundException{
        dao = new ColaboradorDao();
        return dao.findByOne(id);
    }

}
