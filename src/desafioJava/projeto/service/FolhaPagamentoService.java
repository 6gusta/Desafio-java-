package desafioJava.projeto.service;

import desafioJava.projeto.model.Funcionario;
import desafioJava.projeto.model.Vendedor;

import java.util.List;

public class FolhaPagamentoService {

    // 1. Total pago (salário + benefício)
    public double calcularTotalPago(List<Funcionario> funcionarios, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario(ano, mes);
        }
        return total;
    }

    // 2. Total pago somente em salários base (sem benefícios)
    public double calcularTotalSalarios(List<Funcionario> funcionarios, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalarioBase(ano, mes);
        }
        return total;
    }

    // 3. Total pago somente em benefícios (lista só de funcionários que recebem benefício)
    public double calcularTotalBeneficios(List<Funcionario> funcionariosComBeneficio, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionariosComBeneficio) {
            total += f.calcularBeneficio(ano, mes);
        }
        return total;
    }

    // 4. Funcionário que mais recebeu (salário + benefício)
    public Funcionario buscarFuncionarioMaiorRecebimento(List<Funcionario> funcionarios, int ano, int mes) {
        Funcionario maiorRecebedor = null;
        double maiorValor = Double.MIN_VALUE;

        for (Funcionario f : funcionarios) {
            double total = f.calcularSalario(ano, mes);
            if (total > maiorValor) {
                maiorValor = total;
                maiorRecebedor = f;
            }
        }
        return maiorRecebedor;
    }

    // 5. Funcionário com maior benefício
    public String buscarNomeMaiorBeneficio(List<Funcionario> funcionariosComBeneficio, int ano, int mes) {
        Funcionario maiorBeneficiado = null;
        double maiorBeneficio = Double.MIN_VALUE;

        for (Funcionario f : funcionariosComBeneficio) {
            double beneficio = f.calcularBeneficio(ano, mes);
            if (beneficio > maiorBeneficio) {
                maiorBeneficio = beneficio;
                maiorBeneficiado = f;
            }
        }
        return (maiorBeneficiado != null) ? maiorBeneficiado.getNomefuncionario() : null;
    }

    // 6. Vendedor que mais vendeu no mês
    public Vendedor buscarVendedorMaiorVenda(List<Vendedor> vendedores, int ano, int mes) {
        Vendedor maiorVendedor = null;
        double maiorVenda = Double.MIN_VALUE;
        String chave = String.format("%02d/%d", mes, ano);

        for (Vendedor v : vendedores) {
            double venda = v.getVendas().getOrDefault(chave, 0.0);
            if (venda > maiorVenda) {
                maiorVenda = venda;
                maiorVendedor = v;
            }
        }
        return maiorVendedor;
    }
}
