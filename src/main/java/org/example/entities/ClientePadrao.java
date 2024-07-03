package org.example.entities;

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
