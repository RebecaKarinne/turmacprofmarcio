package model;

public class Notas {
    public int codNota;
    public int codAluno;
    public int codDisciplina;
    public float vlrNota;

    public Notas(int codNota, int codAluno, int codDisciplina, float vlrNota) {
        this.codNota = codNota;
        this.codAluno = codAluno;
        this.codDisciplina = codDisciplina;
        this.vlrNota = vlrNota;
    }

    public int getCodNota() {
        return codNota;
    }

    public void setCodNota(int codNota) {
        this.codNota = codNota;
    }

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public float getVlrNota() {
        return vlrNota;
    }

    public void setVlrNota(float vlrNota) {
        this.vlrNota = vlrNota;
    }
}
