import org.example.entities.Cliente;
import org.example.entities.ClienteEspecial;
import org.example.entities.Produto;
import org.example.entities.Venda;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VendaTest {
    @Test
    public void testCalculosVenda() {
        Cliente cliente = new ClienteEspecial("DF", true);
        Produto produto1 = new Produto("001", "Notebook", 3000.00, "un");
        Produto produto2 = new Produto("002", "Mouse", 150.00, "un");
        List<Produto> produtos = Arrays.asList(produto1, produto2);
        Date data = new Date();

        Venda venda = new Venda(data, cliente, produtos, "dinheiro");

        assertEquals(3150.00, venda.calcularValorTotal(), 0.001);
        assertEquals(567.0, venda.calcularICMS(), 0.001);
        assertEquals(0.0, venda.calcularImpostoMunicipal(), 0.001);
        assertEquals(3.5, venda.calcularFrete(), 0.001);
    }
}

