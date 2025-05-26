import desafioJava.projeto.model.*;
import desafioJava.projeto.service.FolhaPagamentoService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();


        funcionarios.add(new Secretario("Jorge Carvalho", LocalDate.of(2018, 1, 1)));
        funcionarios.add(new Secretario("Maria Souza", LocalDate.of(2015, 12, 1)));


        Map<String, Double> vendasAna = new HashMap<>();
        vendasAna.put("12/2021", 5200.00);
        vendasAna.put("01/2022", 4000.00);
        vendasAna.put("02/2022", 4200.00);
        vendasAna.put("03/2022", 5850.00);
        vendasAna.put("04/2022", 7000.00);
        funcionarios.add(new Vendedor("Ana Silva", LocalDate.of(2021, 12, 1), vendasAna));

        Map<String, Double> vendasJoao = new HashMap<>();
        vendasJoao.put("12/2021", 3400.00);
        vendasJoao.put("01/2022", 7700.00);
        vendasJoao.put("02/2022", 5000.00);
        vendasJoao.put("03/2022", 5900.00);
        vendasJoao.put("04/2022", 6500.00);
        funcionarios.add(new Vendedor("João Mendes", LocalDate.of(2021, 12, 1), vendasJoao));

        funcionarios.add(new Gerente("Juliana Alves", LocalDate.of(2017, 7, 1)));
        funcionarios.add(new Gerente("Bento Albino", LocalDate.of(2014, 3, 1)));

        FolhaPagamentoService folhaService = new FolhaPagamentoService();

        int anoConsulta = 2022;
        int mesConsulta = 3;

        double totalFolha = folhaService.calcularTotalPago(funcionarios, anoConsulta, mesConsulta);
        System.out.println("Total da folha de pagamento em " + mesConsulta + "/" + anoConsulta + ": R$ " + totalFolha);

        for (Funcionario f : funcionarios) {
            double salario = f.calcularSalario(anoConsulta, mesConsulta);
            System.out.println(f.getNomefuncionario() + " - Salário em " + mesConsulta + "/" + anoConsulta + ": R$ " + salario);
        }


        Funcionario topRecebedor = folhaService.buscarFuncionarioMaiorRecebimento(funcionarios, anoConsulta, mesConsulta);
        System.out.println("\nFuncionário que mais recebeu em " + mesConsulta + "/" + anoConsulta + ": " + topRecebedor.getNomefuncionario());


        List<Funcionario> comBeneficio = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f.getCargo() != Cargo.VENDENDOR) {
                comBeneficio.add(f);
            }
        }

        String nomeMaiorBeneficio = folhaService.buscarNomeMaiorBeneficio(comBeneficio, anoConsulta, mesConsulta);
        System.out.println("Funcionário com maior benefício: " + nomeMaiorBeneficio);

        List<Vendedor> vendedores = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            if (f instanceof Vendedor) {
                vendedores.add((Vendedor) f);
            }
        }

        Vendedor topVendedor = folhaService.buscarVendedorMaiorVenda(vendedores, anoConsulta, mesConsulta);
        if (topVendedor != null) {
            System.out.println("Vendedor que mais vendeu: " + topVendedor.getNomefuncionario());
        }
    }
}
