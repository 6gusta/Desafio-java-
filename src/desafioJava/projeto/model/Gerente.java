package desafioJava.projeto.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {

    private static final double salariobase = 20000.0;
    private static final double beneficioatual = 3000.0;

    public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, Cargo.GERENTE, dataContratacao);
    }

    @Override
    public double calcularSalario(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        return salariobase + (beneficioatual* anosServico);
    }

    @Override
    public double calcularSalarioBase(int ano, int mes) {
        return salariobase;
    }

    @Override
    public double calcularBeneficio(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        return beneficioatual * anosServico;
    }
}
