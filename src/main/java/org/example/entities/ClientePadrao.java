package org.example.entities;

/*
    Classe resultante da especialização da classe abstrata `Cliente`, criada como parte da refatoração "Extrair Classe".

    A classe `ClientePadrao` representa um cliente com comportamento padrão, sem descontos aplicáveis.
    Essa especialização herda atributos e métodos de `Cliente`, mas implementa a lógica específica para o cliente padrão.

    O método `calcularDesconto` retorna zero, indicando que clientes padrão não têm direito a descontos.
    O método `calcularFrete` simplesmente retorna o valor do frete, sem alterações.
*/

public class ClientePadrao extends Cliente {
    public ClientePadrao(String nome, String estado, boolean capital) {
        super(nome, "Padrão", estado, capital);
    }

    @Override
    public double calcularDesconto(double valorTotal, String metodoPagamento) {
        return 0;
    }

    @Override
    public double calcularFrete(double valorFrete) {
        return valorFrete;
    }
}
