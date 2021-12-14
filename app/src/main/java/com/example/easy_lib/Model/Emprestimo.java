package com.example.easy_lib.Model;

import java.util.Date;

public class Emprestimo implements IEmprestimo {

    private int codigo;
    private String dataEmprestimo;
    private String dataDevolucao;
    private String status;
    private String cpfUsuario;
    private int codLivro;

    public Emprestimo(int codigo, String dataEmprestimo, String dataDevolucao, String status, String cpfUsuario, int codLivro) {
        this.codigo = codigo;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.status = status;
        this.cpfUsuario = cpfUsuario;
        this.codLivro = codLivro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public int getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(int codLivro) {
        this.codLivro = codLivro;
    }

    @Override
    public double calcularMulta(Date dataAtual) {
        return 0;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "codigo=" + codigo +
                ", dataEmprestimo='" + dataEmprestimo + '\'' +
                ", dataDevolucao='" + dataDevolucao + '\'' +
                ", status='" + status + '\'' +
                ", cpfUsuario='" + cpfUsuario + '\'' +
                ", codLivro=" + codLivro +
                '}';
    }
}