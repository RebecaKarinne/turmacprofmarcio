package model;

import java.util.Date;

public class Matricula {
    public int codMatricula;
    public int codAluno;
    public int codDisciplina;
    public Date dataMatricula;

    public Matricula(int codMatricula, int codAluno, int codDisciplina, Date dataMatricula) {
        this.codMatricula = codMatricula;
        this.codAluno = codAluno;
        this.codDisciplina = codDisciplina;
        this.dataMatricula = dataMatricula;
    }

    public int getCodMatricula() {
        return codMatricula;
    }

    public void setCodMatricula(int codMatricula) {
        this.codMatricula = codMatricula;
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

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
