package org.example;

import org.example.entities.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();

        Cliente cliente1 = new ClientePadrao("Cristian","SP", true);
        Cliente cliente2 = new ClienteEspecial("Barbosa", "DF", true);
        clientes.add(cliente1);
        clientes.add(cliente2);

        Produto produto1 = new Produto("001", "Notebook", 3000.00, "un");
        Produto produto2 = new Produto("002", "Smartphone", 1500.00, "un");
        produtos.add(produto1);
        produtos.add(produto2);

        System.out.println("Bem-vindo ao sistema de vendas!");

        while (true) {
            exibirMenuPrincipal();

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    criarCliente(clientes, sc);
                    break;
                case 2:
                    realizarVenda(clientes, produtos, sc);
                    break;
                case 3:
                    listarClientes(clientes);
                    break;
                case 4:
                    listarProdutos(produtos);
                    break;
                case 5:
                    cadastrarProduto(produtos, sc);
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1 - Cadastrar novo cliente");
        System.out.println("2 - Realizar nova venda");
        System.out.println("3 - Listar clientes cadastrados");
        System.out.println("4 - Listar produtos cadastrados");
        System.out.println("5 - Cadastrar novo produto");
        System.out.println("6 - Sair do sistema");
        System.out.print("Escolha uma opção: ");
    }

    private static void criarCliente(List<Cliente> clientes, Scanner sc) {
        System.out.println("\n===== CADASTRO DE NOVO CLIENTE =====");
        System.out.println("Digite o tipo de cliente (Padrão, Especial, Prime): ");
        String tipo = sc.nextLine();

        switch (tipo.toLowerCase()) {
            case "padrão":
                System.out.println("Informe o estado do cliente:  (Sigla)");
                String estadoPadrao = sc.nextLine();
                System.out.println("Informe o seu nome:");
                String nome = sc.nextLine();
                System.out.println("Digite 1 se você é da capital e 0 caso não seja:");
                int capitalPadrao = sc.nextInt();
                boolean capitalFinal = false;
                if(capitalPadrao != 0 && capitalPadrao != 1){
                    System.out.println("Valor inválido, digite 1 ou 0");
                    break;
                }
                if (capitalPadrao == 1){
                    capitalFinal = true;
                }
                clientes.add(new ClientePadrao(nome ,estadoPadrao, capitalFinal));
                System.out.println("Cliente padrão cadastrado com sucesso!");
                break;
            case "especial":
                System.out.println("Informe o estado do cliente: (Sigla)");
                String estado = sc.nextLine();
                System.out.println("Informe o seu nome:");
                String nomeEspecial = sc.nextLine();
                System.out.println("Digite 1 se você é da capital e 0 caso não seja:");
                int capitalEspecial = sc.nextInt();
                boolean capitalEspecialFinal = false;
                if(capitalEspecial != 0 && capitalEspecial != 1){
                    System.out.println("Valor inválido, digite 1 ou 0");
                    break;
                }
                if (capitalEspecial == 1){
                    capitalEspecialFinal = true;
                }
                clientes.add(new ClienteEspecial(nomeEspecial ,estado, capitalEspecialFinal));
                System.out.println("Cliente especial cadastrado com sucesso!");
                break;
            case "prime":
                System.out.println("Informe o estado do cliente:  (Sigla)12222");
                String estadoPrime = sc.nextLine();
                System.out.println("Informe o seu nome:");
                String nomePrime = sc.nextLine();
                System.out.println("Digite 1 se você é da capital e 0 caso não seja:");
                int capitalPrime = sc.nextInt();
                boolean capitalEspecialPrime = false;
                if(capitalPrime != 0 && capitalPrime != 1){
                    System.out.println("Valor inválido, digite 1 ou 0");
                    break;
                }
                if (capitalPrime == 1){
                    capitalEspecialPrime = true;
                }
                clientes.add(new ClientePrime(nomePrime ,estadoPrime, capitalEspecialPrime));
                System.out.println("Cliente prime cadastrado com sucesso!");
                break;
            default:
                System.out.println("Tipo de cliente inválido!");
        }
    }

    private static void realizarVenda(List<Cliente> clientes, List<Produto> produtos, Scanner sc) {
        System.out.println("\n===== NOVA VENDA =====");

        listarClientes(clientes);
        System.out.print("Selecione o cliente pelo número: ");
        int clienteIndex = sc.nextInt();
        Cliente clienteSelecionado = clientes.get(clienteIndex - 1);
        System.out.println(clienteSelecionado.getNome());
        sc.nextLine();

        listarProdutos(produtos);
        System.out.print("Selecione o produto pelo número: ");
        int produtoIndex = sc.nextInt();
        Produto produtoSelecionado = produtos.get(produtoIndex - 1);
        sc.nextLine();

        Date data = new Date();

        System.out.print("Informe o método de pagamento (digite 'dinheiro' ou o número do cartão): ");
        String metodoPagamento = sc.nextLine();
        if (metodoPagamento.length() != 16 && !metodoPagamento.equals("dinheiro")) {
            System.out.println("Número de cartão inválido!");
            return;
        }
        List<Produto> produtosVendidos = new ArrayList<>();
        produtosVendidos.add(produtoSelecionado);

        Venda venda = new Venda(data, clienteSelecionado, produtosVendidos, metodoPagamento);


        imprimirNotaFiscal(venda);
    }

    private static void cadastrarProduto(List<Produto> produtoList, Scanner sc){
        System.out.print("Informe o nome do produto que deseja cadastrar:");
        String nome = sc.nextLine();
        System.out.print("Informe o valor do produto que deseja cadastrar:");
        double valor = sc.nextDouble();
        System.out.print("Informe a unidade do produto que deseja cadastrar:");
        String unidade = sc.nextLine();
        String codigo = sc.nextLine();
        Produto produto = new Produto(codigo, nome, valor, unidade);
        produtoList.add(produto);
    }

    private static void listarClientes(List<Cliente> clientes) {
        System.out.println("\n===== CLIENTES CADASTRADOS =====");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + " - " + clientes.get(i).getNome());
        }
    }

    private static void listarProdutos(List<Produto> produtos) {
        System.out.println("\n===== PRODUTOS CADASTRADOS =====");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println((i + 1) + " - " + produtos.get(i).getDescricao() + " - R$" + produtos.get(i).getValor());

        }
    }

    private static void imprimirNotaFiscal(Venda venda) {
        System.out.println("\n===== NOTA FISCAL =====");
        System.out.println("Data da Venda: " + venda.getData());
        System.out.println("Cliente: " + venda.getCliente().getTipo());

        // Cálculo dos valores
        double desconto = venda.calcularDesconto();
        double frete = venda.calcularFrete();
        double icms = venda.calcularICMS();
        double impostoMunicipal = venda.calcularImpostoMunicipal();
        double valorTotal = venda.calcularValorTotal(desconto, frete, icms, impostoMunicipal);

        System.out.println("Desconto: R$" + desconto);
        System.out.println("Frete: R$" + frete);
        System.out.println("ICMS: R$" + icms);
        System.out.println("Imposto Municipal: R$" + impostoMunicipal);
        System.out.println("TOTAL: R$" + valorTotal);
    }
}
