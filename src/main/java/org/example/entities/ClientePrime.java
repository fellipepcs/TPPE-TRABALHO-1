package org.example.entities;

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
