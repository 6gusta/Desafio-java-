package desafioJava.projeto.model;

import java.time.LocalDate;

public class Gerente extends Funcionario {

    private static final double SALARIO_BASE = 20000.0;
    private static final double BENEFICIO_ANUAL = 3000.0;

    public Gerente(String nome, LocalDate dataContratacao) {
        super(nome, Cargo.GERENTE, dataContratacao);
    }

    @Override
    public double calcularSalario(int anoConsulta) {
        long anosServico = getAnosServico(anoConsulta);
        return SALARIO_BASE + (BENEFICIO_ANUAL * anosServico);
    }
}
