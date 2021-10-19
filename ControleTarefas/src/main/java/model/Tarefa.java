package model;

public class Tarefa {

    private int idTarefa;
    private int idColaborador;
    private String descrTarefa;
    private String dataHoraInicio;
    private String dataHoraFim;
    private String statusTarefa;
    private String prioridadeTarefa;
    
    public Tarefa() {}
    
    public Tarefa(int idTarefa, String descrTarefa, String dataHoraInicio, String dataHoraFim, String statusTarefa, String prioridadeTarefa) {
    	this.idTarefa = idTarefa;
    	this.descrTarefa = descrTarefa;
    	this.dataHoraInicio = dataHoraInicio;
    	this.dataHoraFim = dataHoraFim;
    	this.statusTarefa = statusTarefa;
    	this.prioridadeTarefa = prioridadeTarefa;
    }
    
    public Tarefa(int idTarefa, int idColaborador, String descrTarefa, String dataHoraInicio, String dataHoraFim,
                  String statusTarefa, String prioridadeTarefa) {
        this.idTarefa = idTarefa;
        this.idColaborador = idColaborador;
        this.descrTarefa = descrTarefa;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusTarefa = statusTarefa;
        this.prioridadeTarefa = prioridadeTarefa;
    }

    public Tarefa(String desc, String dataHoraInicio, String dataHoraFim, String status, String priority) {
        this.descrTarefa = desc;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.statusTarefa = status;
        this.prioridadeTarefa = priority;
    }
    
    public int getIdTarefa() {
    	return idTarefa;
    }
    
    public void setIdTarefa(int idTarefa) {
    	this.idTarefa = idTarefa;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getDescrTarefa() {
        return descrTarefa;
    }

    public void setDescrTarefa(String descrTarefa) {
        this.descrTarefa = descrTarefa;
    }

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public String getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(String dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(String statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public String getPrioridadeTarefa() {
        return prioridadeTarefa;
    }

    public void setPrioridadeTarefa(String prioridadeTarefa) {
        this.prioridadeTarefa = prioridadeTarefa;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "idTarefa=" + idTarefa +
                ", idColaborador=" + idColaborador +
                ", descrTarefa='" + descrTarefa + '\'' +
                ", dataHoraInicio=" + dataHoraInicio +
                ", dataHoraFim=" + dataHoraFim +
                ", statusTarefa='" + statusTarefa + '\'' +
                ", prioridadeTarefa='" + prioridadeTarefa + '\'' +
                '}';
    }
}
