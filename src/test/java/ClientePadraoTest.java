import org.example.entities.ClientePadrao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClientePadraoTest {
    private final ClientePadrao cliente;
    private final String nomeEsperado;
    private final String estadoEsperado;
    private final boolean capitalEsperado;
    private final double valorTotal;
    private final String metodoPagamento;
    private final double valorFrete;
    private final double descontoEsperado;
    private final double freteEsperado;

    public ClientePadraoTest(ClientePadrao cliente, String nomeEsperado, String estadoEsperado, boolean capitalEsperado,
                             double valorTotal, String metodoPagamento, double valorFrete, double descontoEsperado, double freteEsperado) {
        this.cliente = cliente;
        this.nomeEsperado = nomeEsperado;
        this.estadoEsperado = estadoEsperado;
        this.capitalEsperado = capitalEsperado;
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.valorFrete = valorFrete;
        this.descontoEsperado = descontoEsperado;
        this.freteEsperado = freteEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ClientePadrao("Maria", "SP", true), "Maria", "SP", true, 100.0, "cartao_credito", 50.0, 0.0, 50.0},
                {new ClientePadrao("José", "RJ", false), "José", "RJ", false, 200.0, "boleto", 75.0, 0.0, 75.0},
                {new ClientePadrao("Joana", "MG", true), "Joana", "MG", true, 300.0, "cartao_credito", 25.0, 0.0, 25.0},
                {new ClientePadrao("Pedro", "RS", false), "Pedro", "RS", false, 150.0, "dinheiro", 60.0, 0.0, 60.0}
        });
    }

    @Test
    public void testClientePadrao() {
        assertEquals("Padrão", cliente.getTipo());
        assertEquals(nomeEsperado, cliente.getNome());
        assertEquals(estadoEsperado, cliente.getEstado());
        assertEquals(capitalEsperado, cliente.isCapital());
    }

    @Test
    public void testCalcularDesconto() {
        double desconto = cliente.calcularDesconto(valorTotal, metodoPagamento);
        assertEquals(descontoEsperado, desconto, 0.001);
    }

    @Test
    public void testCalcularFrete() {
        double frete = cliente.calcularFrete(valorFrete);
        assertEquals(freteEsperado, frete, 0.001);
    }
}
