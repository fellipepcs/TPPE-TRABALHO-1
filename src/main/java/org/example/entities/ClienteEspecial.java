package org.example.entities;

import java.util.Date;
import java.util.List;

/*
    Classe resultante da especialização da classe abstrata `Cliente`, criada como parte da refatoração "Extrair Classe".

    A classe `ClienteEspecial` representa um cliente com status "Especial", oferecendo benefícios exclusivos em termos de desconto e frete.

    O método `calcularDesconto` aplica um desconto de 10% sobre o valor total da compra. Caso o método de pagamento
    inicie com "4296 13", um desconto adicional de 10% é aplicado, somando um total de 20% de desconto.

    O método `calcularFrete` aplica um desconto de 30% no valor do frete, resultando em um custo de frete reduzido para clientes especiais.
*/

public class ClienteEspecial extends Cliente {

    public ClienteEspecial(String nome, String estado, boolean capital) {
        super(nome, "Especial", estado, capital);
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
        return valorFrete * 0.70;
    }
}
