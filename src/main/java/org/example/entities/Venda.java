package org.example.entities;


import java.util.Date;
import java.util.List;

public class Venda {
    private Date data;
    private Cliente cliente;
    private List<Produto> produtos;
    private String metodoPagamento;

    public Venda(Date data, Cliente cliente, List<Produto> produtos, String metodoPagamento) {
        this.data = data;
        this.cliente = cliente;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;
    }

    public Date getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }
}
