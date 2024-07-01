package org.example.entities;

public class ClientePrime extends Cliente {
    public ClientePrime(double mensalidade, String estado, boolean capital) {
        super("Prime", mensalidade, estado, capital);
    }

    @Override
    public double calcularDesconto(double valorTotal, String metodoPagamento) {
        return 0;
    }

    @Override
    public double calcularFrete(double valorFrete) {
        return 0;
    }

    @Override
    public double calcularCashback(double valorTotal, String metodoPagamento) {
        double cashback = valorTotal * 0.03;
        if (metodoPagamento.startsWith("4296 13")) {
            cashback = valorTotal * 0.05;
        }
        return cashback;
    }
}
