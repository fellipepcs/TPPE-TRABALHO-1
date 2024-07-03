package org.example.entities;

public abstract class Cliente {
    private String nome;
    private String tipo;
    private String estado;
    private boolean capital;

    public Cliente(String nome ,String tipo, String estado, boolean capital) {
        this.nome = nome;
        this.tipo = tipo;
        this.estado = estado;
        this.capital = capital;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isCapital() {
        return capital;
    }

    public abstract double calcularDesconto(double valorTotal, String metodoPagamento);

    public abstract double calcularFrete(double valorFrete);
}
