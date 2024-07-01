package org.example.entities;

public class Cliente {
    private String tipo;
    private double mensalidade;
    private String estado;
    private boolean capital;

    public Cliente(String tipo, double mensalidade, String estado, boolean capital) {
        this.tipo = tipo;
        this.mensalidade = mensalidade;
        this.estado = estado;
        this.capital = capital;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isCapital() {
        return capital;
    }
}
