import desafioJava.projeto.model.Gerente;
import desafioJava.projeto.model.Secretario;
import desafioJava.projeto.model.Vendedor;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Secretario sec = new Secretario("joaõ", LocalDate.of(2018,5, 1));
        System.out.println("Salário Secretário 2022: " + sec.calcularSalario(2022));

        Map<String, Double> vendas = new HashMap<>();
        vendas.put("05/2025", 5000.0);
        Vendedor vend = new Vendedor("Maria", LocalDate.of(2024, 5, 1), vendas);
        System.out.println("Salário Vendedor 2025: " + vend.calcularSalario(2025));

        Gerente ger = new Gerente("Carlos", LocalDate.of(2020, 1, 1));
        System.out.println("Salário Gerente 2025: " + ger.calcularSalario(2025));
    }
}