package desafioJava.projeto.model;

import java.time.LocalDate;

public class Secretario extends Funcionario {

    private static final double SALARIO_BASE = 7000.0;
    private static final double BENEFICIO_ANUAL = 1000.0;

    public Secretario(String nome, LocalDate dataContratacao) {
        super(nome, Cargo.SECRETARIO, dataContratacao);
    }

    @Override
    public double calcularSalario(int anoConsulta) {
        long anos = getAnosServico(anoConsulta);
        double beneficio = anos * BENEFICIO_ANUAL;
        double bonus = SALARIO_BASE * 0.20;

        return SALARIO_BASE + beneficio + bonus;
    }
}
