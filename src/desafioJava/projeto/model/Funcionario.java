package desafioJava.projeto.model;

import java.time.LocalDate;

public abstract class Funcionario {

    private String nomefuncionario;
    private Cargo cargo;
    private LocalDate dataContratacao;

    public Funcionario(String nome, Cargo cargo, LocalDate dataContratacao) {
        this.nomefuncionario = nome;
        this.cargo = cargo;
        this.dataContratacao = dataContratacao;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    protected long getAnosServico(int anoConsulta) {
        return anoConsulta - dataContratacao.getYear();
    }

    // Agora todos os métodos usam ano + mês
    public abstract double calcularSalario(int ano, int mes);
    public abstract double calcularSalarioBase(int ano, int mes);
    public abstract double calcularBeneficio(int ano, int mes);
}
