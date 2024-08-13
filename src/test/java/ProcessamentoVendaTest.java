import org.example.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ProcessamentoVendaTest {
    private final List<Produto> produtos;
    private final double descontoEsperado;
    private final double freteEsperado;
    private final double icmsEsperado;
    private final double impostoMunicipalEsperado;
    private final double valorTotalEsperado;

    private final double valorTotalProcessamentoVenda;

    private CadastroProduto cadastroProduto;
    private CadastroCliente cadastroCliente;
    private ProcessamentoVenda processamentoVenda;


    public ProcessamentoVendaTest(double descontoEsperado, double freteEsperado, double icmsEsperado, double impostoMunicipalEsperado, double valorTotalEsperado, double valorTotalProcessamentoVenda, List<Produto> produtos) {
        this.descontoEsperado = descontoEsperado;
        this.freteEsperado = freteEsperado;
        this.icmsEsperado = icmsEsperado;
        this.impostoMunicipalEsperado = impostoMunicipalEsperado;
        this.valorTotalEsperado = valorTotalEsperado;
        this.valorTotalProcessamentoVenda = valorTotalProcessamentoVenda;
        this.produtos = produtos;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{150.0, 35.0, 180.0, 60.0, 1625.0, 1594.9 ,
                Arrays.asList(new Produto("2121", "Notebook", 100, "2"),
                        new Produto("2122", "Smartphone", 200, "2"),
                        new Produto("2123", "Tablet", 300, "2"),
                        new Produto("2124", "Headphones", 400, "2"),
                        new Produto("2125", "Mouse", 500, "2"))},
                {27.0, 35.0, 32.4,10.8, 321.2 ,1881.1000000000001,
                        Arrays.asList(new Produto("2126", "Monitor", 150, "3"),
                        new Produto("2127", "Teclado", 70, "3"),
                        new Produto("2128", "Webcam", 50, "3"))},
                {40.0, 35.0, 48.0, 16.0, 459.0, 2018.9, Arrays.asList(
                        new Produto("2129", "Impressora", 250, "4"),
                        new Produto("2130", "Scanner", 150, "4"))}
        });
    }

    @Before
    public void setUp() {
        cadastroProduto = new CadastroProduto();
        cadastroCliente = new CadastroCliente();
        processamentoVenda = new ProcessamentoVenda(cadastroProduto, cadastroCliente);

        cadastrarProdutos();
        cadastrarClientes();
    }

    @Test
    public void testProcessarVenda() {
        ClienteEspecial cliente = (ClienteEspecial) cadastroCliente.pesquisar("Cliente 1");
        Venda venda = new Venda(new Date(), cliente, cadastroProduto.getProdutos(), "1234 5678 9123 4567");

        assertEquals(descontoEsperado, venda.calcularDesconto(), 0.01);
        assertEquals(freteEsperado, cliente.calcularFrete(50.00), 0.01);
        assertEquals(icmsEsperado, venda.calcularICMS(), 0.01);
        assertEquals(impostoMunicipalEsperado, venda.calcularImpostoMunicipal(), 0.01);

        double valorTotalCalculado = venda.calcularValorTotal(venda.calcularDesconto(), cliente.calcularFrete(50.00), venda.calcularICMS(), venda.calcularImpostoMunicipal());
        double valorTotalCalculadoVenda = processamentoVenda.processarVenda();

        assertEquals(valorTotalProcessamentoVenda, valorTotalCalculadoVenda, 0.01);
        assertEquals(valorTotalEsperado, valorTotalCalculado, 0.01);
    }

    private void cadastrarProdutos() {
        for (Produto produto : produtos) {
            cadastroProduto.cadastrar(produto.getCodigo(), produto.getDescricao(), produto.getValor(), produto.getUnidade());
        }
    }

    private void cadastrarClientes() {
        ClienteEspecial clienteEspecial = new ClienteEspecial("Cliente 1", "SP", true);
        cadastroCliente.cadastrar(clienteEspecial);
    }
}
