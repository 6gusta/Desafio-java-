package desafioJava.projeto.service;

import desafioJava.projeto.model.Funcionario;
import desafioJava.projeto.model.Vendedor;

import java.util.List;

public class FolhaPagamentoService {

    public double calcularTotalPago(List<Funcionario> funcionarios, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalario(ano, mes);
        }
        return total;
    }

    public double calcularTotalSalarios(List<Funcionario> funcionarios, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionarios) {
            total += f.calcularSalarioBase(ano, mes);
        }
        return total;
    }


    public double calcularTotalBeneficios(List<Funcionario> funcionariosComBeneficio, int ano, int mes) {
        double total = 0;
        for (Funcionario f : funcionariosComBeneficio) {
            total += f.calcularBeneficio(ano, mes);
        }
        return total;
    }


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
