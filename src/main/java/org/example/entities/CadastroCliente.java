package org.example.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class CadastroCliente {
    private Map<String, Cliente> clientes = new HashMap<>();
    public boolean cadastrar(Cliente cliente) {
        if (clientes.containsKey(cliente.getNome())) {
            return false;
        }
        clientes.put(cliente.getNome(), cliente);
        return true;
    }

    public Cliente pesquisar(String nome) {
        return clientes.get(nome);
    }

    public boolean remover(String nome) {
        if (clientes.containsKey(nome)) {
            clientes.remove(nome);
            return true;
        }
        return false;
    }

    public Collection<Cliente> listarTodos() {
        return clientes.values();
    }
    public boolean clienteCadastrado(String nome) {
        return clientes.containsKey(nome);
    }
    public boolean atualizar(Cliente cliente) {
        if (clientes.containsKey(cliente.getNome())) {
            clientes.put(cliente.getNome(), cliente);
            return true;
        }
        return false;
    }
}
