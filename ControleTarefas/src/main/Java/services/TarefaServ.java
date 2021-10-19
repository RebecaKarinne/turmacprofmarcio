package ControleTarefasBack.services;

import ControleTarefasBack.DAO.TarefaDao;
import ControleTarefasBack.model.Tarefa;

import java.awt.font.FontRenderContext;
import java.sql.SQLException;
import java.util.List;

public class TarefaServ {

    private TarefaDao dao;

    public TarefaServ() throws SQLException, ClassNotFoundException{}

    public void include(Tarefa tarefa) throws SQLException, ClassNotFoundException{
        dao = new TarefaDao();
        dao.include(tarefa);
    }

    public void update(Tarefa tarefa) throws SQLException, ClassNotFoundException{
        dao = new TarefaDao();
        dao.update(tarefa);
    }

    public String delete(int id) throws SQLException, ClassNotFoundException{
        dao = new TarefaDao();
        return dao.delete(id);
    }

    public List<Tarefa> findAll() throws SQLException, ClassNotFoundException{
        dao = new TarefaDao();
        return dao.findAll();
    }

    public Tarefa findByOne(int id) throws SQLException, ClassNotFoundException{
        dao = new TarefaDao();
        return dao.findByOne(id);
    }

}
