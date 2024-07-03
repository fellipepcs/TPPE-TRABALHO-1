import org.example.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class VendaTest {
    private final Venda venda;
    private final double descontoEsperado;
    private final double icmsEsperado;
    private final double impostoMunicipalEsperado;
    private final double freteEsperado;
    private final double valorTotalEsperado;

    public VendaTest(Venda venda, double descontoEsperado, double icmsEsperado, double impostoMunicipalEsperado,
                     double freteEsperado, double valorTotalEsperado) {
        this.venda = venda;
        this.descontoEsperado = descontoEsperado;
        this.icmsEsperado = icmsEsperado;
        this.impostoMunicipalEsperado = impostoMunicipalEsperado;
        this.freteEsperado = freteEsperado;
        this.valorTotalEsperado = valorTotalEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Cliente cliente1 = new ClientePrime("Alice", "DF", true);
        Cliente cliente2 = new ClientePadrao("Bob", "SP", false);

        Produto produto1 = new Produto("001", "Notebook", 3000.00, "un");
        Produto produto2 = new Produto("002", "Smartphone", 2000.00, "un");

        Venda venda1 = new Venda(new Date(), cliente1, Arrays.asList(produto1, produto2), "cartao_credito");
        Venda venda2 = new Venda(new Date(), cliente2, Arrays.asList(produto1), "boleto");

        return Arrays.asList(new Object[][]{
                {venda1, 500.0, 900.0, 0.0, 0.0, 4977.0},
                {venda2, 0.0, 360.0, 120.0, 10.0, 2977.0}
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
}
