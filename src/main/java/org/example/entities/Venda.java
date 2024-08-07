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

    public Venda cadastrarVenda(Cliente cliente, List<Produto> produtos, String metodoPagamento) {
        Venda venda = new Venda(new Date(), cliente, produtos, metodoPagamento);

        return venda;
    }

    public double realizarVenda() {
        CadastroProduto cadastroProduto = new CadastroProduto();
        cadastroProduto.cadastrar("2121", "Notebook", 100, "2");
        cadastroProduto.cadastrar("2122", "Smartphone", 200, "2");
        cadastroProduto.cadastrar("2123", "Tablet", 300, "2");
        cadastroProduto.cadastrar("2124", "Headphones", 400, "2");
        cadastroProduto.cadastrar("2125", "Mouse", 500, "2");

        ClienteEspecial clienteEspecial = new ClienteEspecial("Cliente 1", "SP", true);
        CadastroCliente cadastro = new CadastroCliente();
        cadastro.cadastrar(clienteEspecial);

        List<Produto> produtosCadastrados = cadastroProduto.getProdutos();
        System.out.println("Produtos cadastrados: " + produtosCadastrados.size());

        Venda venda = new Venda(new Date() ,clienteEspecial, cadastroProduto.getProdutos(), "1234 5678 9123 4567");

        double desconto = venda.calcularDesconto();
        System.out.println("Desconto: " + desconto);
        double frete = clienteEspecial.calcularFrete(50.00);
        System.out.println("Frete: " + frete);
        double icms = venda.calcularICMS();
        System.out.println("ICMS: " + icms);
        double impostoMunicipal = 0.0;
        double valorTotal = venda.calcularValorTotal(desconto, frete, icms, impostoMunicipal);

        System.out.println("Valor total da venda: " + valorTotal);
        return valorTotal;
    }
    public double calcularValorTotal(double desconto, double frete, double icms, double impostoMunicipal) {
        return produtos.stream().mapToDouble(Produto::getValor).sum() - desconto + frete + icms + impostoMunicipal;
    }
    public double calcularTotalProdutos() {
        return produtos.stream().mapToDouble(Produto::getValor).sum();
    }

    public double calcularDesconto() {
        return cliente.calcularDesconto(calcularTotalProdutos(), metodoPagamento);
    }

    public double calcularICMS() {
        double total = calcularTotalProdutos();
        if (cliente.getEstado().equals("DF")) {
            return total * 0.18;
        } else {
            return total * 0.12;
        }
    }

    public double calcularImpostoMunicipal() {
        if (cliente.getEstado().equals("DF")) {
            return 0;
        } else {
            return calcularTotalProdutos() * 0.04;
        }
    }

    public double calcularFrete() {
        double freteBase = obterFreteBase(cliente.getEstado(), cliente.isCapital());
        if(cliente.getTipo().equals("prime")){
            return 0;
        }
        return cliente.calcularFrete(freteBase);
    }

    private double obterFreteBase(String estado, boolean capital) {
        switch (estado) {
            case "DF":
                return capital ? 5.00 : 0;
            case "GO":
            case "MT":
            case "MS":
                return capital ? 10.00 : 13.00;
            case "BA":
            case "AL":
            case "SE":
            case "PE":
            case "PB":
            case "RN":
            case "CE":
            case "PI":
            case "MA":
                return capital ? 15.00 : 18.00;
            case "AM":
            case "RR":
            case "AP":
            case "PA":
            case "TO":
            case "RO":
            case "AC":
                return capital ? 20.00 : 25.00;
            case "SP":
            case "RJ":
            case "MG":
            case "ES":
                return capital ? 7.00 : 10.00;
            case "PR":
            case "SC":
            case "RS":
                return capital ? 10.00 : 13.00;
            default:
                return 0;
        }
    }
}
