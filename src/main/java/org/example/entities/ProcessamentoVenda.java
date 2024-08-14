package org.example.entities;

import java.util.Date;
import java.util.List;

/*
    Refatoração: Substituir Método por Objeto-Método
    O método realizarVenda() originalmente presente na classe Venda foi refatorado e movido para esta classe, ProcessamentoVenda.
    A lógica do método foi encapsulada aqui, proporcionando uma maior modularidade e clareza na operação de venda.
    O método realizarVenda foi dividido em métodos auxiliares, como calcularDesconto, calcularFrete, calcularICMS,
    calcularImpostoMunicipal e calcularValorTotal, para facilitar o entendimento e a manutenção do código.
*/

/*
   Classe resultante da refatoração "Substituir método por objeto-método" aplicada ao método realizarVenda() na classe VENDA.

   Durante essa refatoração, o método realizarVenda() foi movido para a nova classe ProcessamentoVenda, que centraliza a lógica
   de processamento da venda, incluindo o cadastro de produtos, cadastro de clientes, criação da venda, e o cálculo de valores
   como desconto, frete, ICMS e imposto municipal.

   Além disso, aplicamos a refatoração "Extrair Método", o que resultou na criação de métodos auxiliares como cadastrarProdutos(),
   cadastrarClientes(), exibirQuantidadeProdutos(), criarVenda() e realizarVenda(), para melhorar a organização e a clareza do código.
*/

public class ProcessamentoVenda {
    private final CadastroProduto cadastroProduto;
    private final CadastroCliente cadastroCliente;

    public ProcessamentoVenda(CadastroProduto cadastroProduto, CadastroCliente cadastroCliente) {
        this.cadastroProduto = cadastroProduto;
        this.cadastroCliente = cadastroCliente;
    }

    public double processarVenda() {
        cadastrarProdutos();
        ClienteEspecial cliente = cadastrarClientes();
        List<Produto> produtosCadastrados = cadastroProduto.getProdutos();
        exibirQuantidadeProdutos(produtosCadastrados);

        Venda venda = criarVenda(cliente, produtosCadastrados);
        return realizarVenda(venda);
    }

    private void cadastrarProdutos() {
        cadastroProduto.cadastrar("2121", "Notebook", 100, "2");
        cadastroProduto.cadastrar("2122", "Smartphone", 200, "2");
        cadastroProduto.cadastrar("2123", "Tablet", 300, "2");
        cadastroProduto.cadastrar("2124", "Headphones", 400, "2");
        cadastroProduto.cadastrar("2125", "Mouse", 500, "2");
    }

    private ClienteEspecial cadastrarClientes() {
        ClienteEspecial clienteEspecial = new ClienteEspecial("Cliente 1", "SP", true);
        cadastroCliente.cadastrar(clienteEspecial);
        return clienteEspecial;
    }

    private void exibirQuantidadeProdutos(List<Produto> produtosCadastrados) {
        System.out.println("Produtos cadastrados: " + produtosCadastrados.size());
    }

    private Venda criarVenda(Cliente cliente, List<Produto> produtos) {
        return new Venda(new Date(), cliente, produtos, "1234 5678 9123 4567");
    }

    private double realizarVenda(Venda venda) {
        double desconto = venda.calcularDesconto();
        System.out.println("Desconto: " + desconto);

        double frete = venda.calcularFrete();
        System.out.println("Frete: " + frete);

        double icms = venda.calcularICMS();
        System.out.println("ICMS: " + icms);

        double impostoMunicipal = venda.calcularImpostoMunicipal();
        System.out.println("Imposto Municipal: " + impostoMunicipal);

        double valorTotal = venda.calcularValorTotal(desconto, frete, icms, impostoMunicipal);
        System.out.println("Valor total da venda: " + valorTotal);

        return valorTotal;
    }
}
