package org.example.entities;

/*
    Classe resultante da aplicação da refatoração "Extrair Classe" sobre a classe original de cliente.

    A lógica e atributos relacionados a clientes, que anteriormente poderiam estar dispersos em outras classes,
    foram centralizados nesta classe abstrata `Cliente`. Essa refatoração permitiu uma melhor organização do código,
    separando as responsabilidades dos diferentes tipos de clientes e possibilitando a extensão para subclasses específicas.

    A classe `Cliente` define atributos comuns como `nome`, `tipo`, `estado` e `capital`, além de métodos abstratos para
    o cálculo de desconto e frete, que serão implementados pelas subclasses, permitindo a customização do comportamento
    para diferentes tipos de clientes.
*/

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
