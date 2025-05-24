package desafioJava.projeto.model;

import java.time.LocalDate;
import java.util.Map;

public class Vendedor extends Funcionario {

    private static final double SALARIO_BASE = 12000.0;
    private static final double BENEFICIO_ANUAL = 1800.0;

    private Map<String, Double> vendas;

    public Vendedor(String nome, LocalDate dataContratacao, Map<String, Double> vendas) {
        super(nome, Cargo.VENDENDOR, dataContratacao);
        this.vendas = vendas;
    }

    public Map<String, Double> getVendas() {
        return vendas;
    }

    public void setVendas(Map<String, Double> vendas) {
        this.vendas = vendas;
    }

    @Override
    public double calcularSalario(int ano, int mes) {
        long anosServico = getAnosServico(ano);
        double salario = SALARIO_BASE + (BENEFICIO_ANUAL * anosServico);

        String chaveMesAno = String.format("%02d/%d", mes, ano);
        double valorVendidoMes = vendas.getOrDefault(chaveMesAno, 0.0);
        double beneficio = valorVendidoMes * 0.30;

        return salario + beneficio;
    }

    @Override
    public double calcularSalarioBase(int ano, int mes) {
        return SALARIO_BASE + (BENEFICIO_ANUAL * getAnosServico(ano));
    }

    @Override
    public double calcularBeneficio(int ano, int mes) {
        String chaveMesAno = String.format("%02d/%d", mes, ano);
        double valorVendidoMes = vendas.getOrDefault(chaveMesAno, 0.0);
        return valorVendidoMes * 0.30;
    }
}
