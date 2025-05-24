package desafioJava.projeto.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {

    private static final double SALARIO_BASE = 20000.0;
    private static final double BENEFICIO_ANUAL = 3000.0;

    public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, Cargo.GERENTE, dataContratacao);
    }

    @Override
    public double calcularSalario(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        return SALARIO_BASE + (BENEFICIO_ANUAL * anosServico);
    }

    @Override
    public double calcularSalarioBase(int ano, int mes) {
        return SALARIO_BASE;
    }

    @Override
    public double calcularBeneficio(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        return BENEFICIO_ANUAL * anosServico;
    }
}
