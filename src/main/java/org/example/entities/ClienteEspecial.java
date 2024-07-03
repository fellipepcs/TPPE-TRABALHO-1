package org.example.entities;

public class ClienteEspecial extends Cliente {
    public ClienteEspecial(String nome, String estado, boolean capital) {
        super( nome,"Especial", estado, capital);
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
