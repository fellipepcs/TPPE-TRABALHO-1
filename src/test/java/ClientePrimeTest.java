import org.example.entities.ClientePrime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClientePrimeTest {
    private final ClientePrime cliente;
    private final String nomeEsperado;
    private final String estadoEsperado;
    private final boolean capitalEsperado;
    private final double valorTotal;
    private final String metodoPagamento;
    private final double descontoEsperado;
    private final double freteEsperado;
    private final double cashbackEsperado;

    public ClientePrimeTest(ClientePrime cliente, String nomeEsperado, String estadoEsperado, boolean capitalEsperado,
                            double valorTotal, String metodoPagamento, double descontoEsperado, double freteEsperado, double cashbackEsperado) {
        this.cliente = cliente;
        this.nomeEsperado = nomeEsperado;
        this.estadoEsperado = estadoEsperado;
        this.capitalEsperado = capitalEsperado;
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.descontoEsperado = descontoEsperado;
        this.freteEsperado = freteEsperado;
        this.cashbackEsperado = cashbackEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ClientePrime("Alice", "SP", true), "Alice", "SP", true, 100.0, "4296 1312 3456 7890", 20.0, 0.0, 5.0},
                {new ClientePrime("Bob", "RJ", false), "Bob", "RJ", false, 200.0, "1234 5678 9101 1121", 20.0, 0.0, 6.0},
                {new ClientePrime("Carol", "MG", true), "Carol", "MG", true, 300.0, "4296 1312 3456 7890", 60.0, 0.0, 15.0},
                {new ClientePrime("Dave", "RS", false), "Dave", "RS", false, 150.0, "2233 4455 6677 8899", 15.0, 0.0, 4.5}
        });
    }

    @Test
    public void testClientePrime() {
        assertEquals("Prime", cliente.getTipo());
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
        double frete = cliente.calcularFrete(50.0);
        assertEquals(freteEsperado, frete, 0.001);
    }

    @Test
    public void testCalcularCashback() {
        double cashback = cliente.calcularCashback(valorTotal, metodoPagamento);
        assertEquals(cashbackEsperado, cashback, 0.001);
    }
}
