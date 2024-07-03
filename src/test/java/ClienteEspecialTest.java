import org.example.entities.ClienteEspecial;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClienteEspecialTest {

    private double valorTotal;
    private String metodoPagamento;
    private double descontoEsperado;

    public ClienteEspecialTest(double valorTotal, String metodoPagamento, double descontoEsperado) {
        this.valorTotal = valorTotal;
        this.metodoPagamento = metodoPagamento;
        this.descontoEsperado = descontoEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1000.00, "1234 5678 9123 4567", 100.00},
                {1000.00, "4296 1300 0000 0000", 200.00}
        });
    }

    @Test
    public void testCalcularDesconto() {
        ClienteEspecial cliente = new ClienteEspecial("Cliente 1", "SP", true);
        double desconto = cliente.calcularDesconto(valorTotal, metodoPagamento);
        assertEquals(descontoEsperado, desconto, 0.001);
    }

    @Test
    public void testCalcularFrete() {
        ClienteEspecial cliente = new ClienteEspecial("Cliente 1", "SP", true);
        double valorFrete = 50.00;
        double freteComDesconto = cliente.calcularFrete(valorFrete);
        assertEquals(35.00, freteComDesconto, 0.001);
    }
}
