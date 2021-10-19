package model;

public class Professor {
    public int codProfessor;
    public String nomeProfessor;
    public boolean ativo;

    public Professor(int codProfessor, String nomeProfessor, boolean ativo) {
        this.codProfessor = codProfessor;
        this.nomeProfessor = nomeProfessor;
        this.ativo = ativo;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
