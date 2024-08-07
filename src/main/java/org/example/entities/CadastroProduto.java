package org.example.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CadastroProduto {
    private Map<String, Produto> produtoMap = new HashMap<>();

    public Produto cadastrar(String codigo, String descricao, double valor, String unidade) {
        Produto produto = new Produto(codigo, descricao, valor, unidade);
        produtoMap.put(codigo, produto);
        return produto;
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtoMap.values());
    }
}
