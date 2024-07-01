import org.example.entities.ClienteEspecial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteEspecialTest {
    @Test
    public void testCalcularDescontoSemCartaoEmpresa() {
        ClienteEspecial cliente = new ClienteEspecial(100.00, "SP", true);
        double valorTotal = 1000.00;
        String metodoPagamento = "1234 5678 9123 4567";

        double desconto = cliente.calcularDesconto(valorTotal, metodoPagamento);

        assertEquals(100.00, desconto, 0.001);
    }

    @Test
    public void testCalcularDescontoComCartaoEmpresa() {
        ClienteEspecial cliente = new ClienteEspecial(100.00, "SP", true);
        double valorTotal = 1000.00;
        String metodoPagamento = "4296 1300 0000 0000";

        double desconto = cliente.calcularDesconto(valorTotal, metodoPagamento);

        assertEquals(200.00, desconto, 0.001);
    }

    @Test
    public void testCalcularFrete() {
        ClienteEspecial cliente = new ClienteEspecial(100.00, "SP", true);
        double valorFrete = 50.00;

        double freteComDesconto = cliente.calcularFrete(valorFrete);

        assertEquals(35.00, freteComDesconto, 0.001);
    }
}
