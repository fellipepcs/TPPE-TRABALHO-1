package org.example.entities;

public class ClientePadrao extends Cliente {
    public ClientePadrao(double mensalidade, String estado, boolean capital) {
        super("Padrao", mensalidade, estado, capital);
    }

    @Override
    public double calcularDesconto(double valorTotal, String metodoPagamento) {
        return 0;
    }

    @Override
    public double calcularFrete(double valorFrete) {
        return valorFrete;
    }

    @Override
    public double calcularCashback(double valorTotal, String metodoPagamento) {
        return 0;
    }
}
