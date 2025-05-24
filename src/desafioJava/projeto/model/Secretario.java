package desafioJava.projeto.model;

import java.time.LocalDate;

public class Secretario extends Funcionario {

    public Secretario(String nome, LocalDate dataContratacao) {
        super(nome, Cargo.SECRETARIO, dataContratacao);
    }



    @Override
    public double calcularSalario(int ano, int mes) {
        return calcularSalarioBase(ano, mes) + calcularBeneficio(ano, mes);
    }

    @Override
    public double calcularSalarioBase(int ano, int mes) {
        return 7000.0;  // valor fixo
    }

    @Override
    public double calcularBeneficio(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        return anosServico * 1000.0;
    }

}
