package model;

public class Colaborador {

    private int idColaborador;
    private String nomeColaborador;



    public Colaborador(int idColaborador, String nomeColaborador) {
        this.idColaborador = idColaborador;
        this.nomeColaborador = nomeColaborador;
    }

    public Colaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }
    
    public Colaborador() {}

    @Override
    public String toString() {
        return "Collaborator id: " + idColaborador + '\n' +
                "Collaborator name: " + nomeColaborador + '\n';
    }
}

