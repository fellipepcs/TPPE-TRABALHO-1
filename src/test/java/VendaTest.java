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
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class VendaTest {
    private final Venda venda;
    private final double descontoEsperado;
    private final double icmsEsperado;
    private final double impostoMunicipalEsperado;
    private final double freteEsperado;
    private final double valorTotalEsperado;
    private final double valorTotalVenda;

    private final Cliente cliente;
    private final List<Produto> produtos;
    private final String metodoPagamento;

    public VendaTest(Venda venda, double descontoEsperado, double icmsEsperado, double impostoMunicipalEsperado,
                     double freteEsperado, double valorTotalEsperado, double valorTotalVenda, Cliente cliente, List<Produto> produtos, String metodoPagamento) {
        this.venda = venda;
        this.descontoEsperado = descontoEsperado;
        this.icmsEsperado = icmsEsperado;
        this.impostoMunicipalEsperado = impostoMunicipalEsperado;
        this.freteEsperado = freteEsperado;
        this.valorTotalEsperado = valorTotalEsperado;
        this.valorTotalVenda = valorTotalVenda;

        this.cliente = cliente;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Cliente cliente1 = new ClientePrime("Alice", "DF", true);
        Cliente cliente2 = new ClientePadrao("Bob", "SP", false);

        Produto produto1 = new Produto("001", "Notebook", 3000.00, "un");
        Produto produto2 = new Produto("002", "Smartphone", 2000.00, "un");

        Venda venda1 = new Venda(new Date(), cliente1, Arrays.asList(produto1, produto2), "4296 13XX XXXX XXXX");
        Venda venda2 = new Venda(new Date(), cliente2, Arrays.asList(produto1), "boleto");

        return Arrays.asList(new Object[][]{
                {venda1, 1000.0, 900.0, 0.0, 0.0, 4977.0, 1565.0, cliente1, Arrays.asList(produto1, produto2), "4296 13XX XXXX XXXX"},
                {venda2, 0.0, 360.0, 120.0, 10.0, 2977.0, 1565.0, cliente2, Arrays.asList(produto1), "boleto"}
        });
    }
    @Test
    public void testCalcularDesconto() {
        assertEquals(descontoEsperado, venda.calcularDesconto(), 0.001);
    }

    @Test
    public void testCalcularICMS() {
        assertEquals(icmsEsperado, venda.calcularICMS(), 0.001);
    }

    @Test
    public void testCalcularImpostoMunicipal() {
        assertEquals(impostoMunicipalEsperado, venda.calcularImpostoMunicipal(), 0.001);
    }

    @Test
    public void testCalcularFrete() {
        assertEquals(freteEsperado, venda.calcularFrete(), 0.001);
    }

    @Test
    public void testCalcularValorTotal() {
        assertEquals(valorTotalEsperado, venda.calcularValorTotal(100, 12, 21, 44), 0.001);
    }
    @Test
    public void testCadastrarVenda() {
        Venda venda = this.venda.cadastrarVenda(cliente, produtos, metodoPagamento);
        assertNotNull(venda);
        assertEquals(cliente, venda.getCliente());
        assertEquals(produtos, venda.getProdutos());
        assertEquals(metodoPagamento, venda.getMetodoPagamento());
    }

}