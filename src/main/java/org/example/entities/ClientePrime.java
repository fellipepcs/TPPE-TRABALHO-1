package org.example.entities;

/*
    Classe resultante da especialização da classe abstrata `Cliente`, criada como parte da refatoração "Extrair Classe".

    A classe `ClientePrime` representa um cliente com um plano especial "Prime", oferecendo benefícios adicionais.
    Essa especialização implementa a lógica específica para clientes Prime, incluindo descontos e frete gratuito.

    O método `calcularDesconto` aplica um desconto de 10% sobre o valor total da compra. Caso o método de pagamento
    inicie com "4296 13", um desconto adicional de 10% é aplicado.

    O método `calcularFrete` sempre retorna zero, indicando que clientes Prime não pagam frete.

    O método `calcularCashback` calcula um cashback de 3% sobre o valor total da compra. Se o método de pagamento
    iniciar com "4296 13", o cashback aumenta para 5%.
*/

public class ClientePrime extends Cliente {
    public ClientePrime(String nome, String estado, boolean capital) {
        super(nome, "Prime", estado, capital);
    }

    @Override
    public double calcularDesconto(double valorTotal, String metodoPagamento) {
        double desconto = valorTotal * 0.10;
        if (metodoPagamento.startsWith("4296 13")) {
            desconto += valorTotal * 0.10;
        }
        return desconto;
    }
    @Override
    public double calcularFrete(double valorFrete) {
        return 0;
    }

    public double calcularCashback(double valorTotal, String metodoPagamento) {
        double cashback = valorTotal * 0.03;
        if (metodoPagamento.startsWith("4296 13")) {
            cashback = valorTotal * 0.05;
        }
        return cashback;
    }
}
