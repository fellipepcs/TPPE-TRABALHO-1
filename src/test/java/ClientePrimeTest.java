import org.example.entities.ClientePrime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientePrimeTest {
    @Test
    public void testCalcularFrete() {
        ClientePrime cliente = new ClientePrime(200.00, "DF", true);
        double valorFrete = 50.00;

        double freteComDesconto = cliente.calcularFrete(valorFrete);

        assertEquals(0.00, freteComDesconto, 0.001);
    }

    @Test
    public void testCalcularCashbackSemCartaoEmpresa() {
        ClientePrime cliente = new ClientePrime(200.00, "DF", true);
        double valorTotal = 1000.00;
        String metodoPagamento = "1234 5678 9123 4567";

        double cashback = cliente.calcularCashback(valorTotal, metodoPagamento);

        assertEquals(30.00, cashback, 0.001);
    }

    @Test
    public void testCalcularCashbackComCartaoEmpresa() {
        ClientePrime cliente = new ClientePrime(200.00, "DF", true);
        double valorTotal = 1000.00;
        String metodoPagamento = "4296 1300 0000 0000";

        double cashback = cliente.calcularCashback(valorTotal, metodoPagamento);

        assertEquals(50.00, cashback, 0.001);
    }
}
