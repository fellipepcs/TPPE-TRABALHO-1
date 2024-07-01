import org.example.entities.Cliente;
import org.example.entities.Produto;
import org.example.entities.Venda;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VendaTest {
    @Test
    public void testVenda() {
        Cliente cliente = new Cliente("Prime", 200.00, "DF", true);
        Produto produto1 = new Produto("001", "Notebook", 3000.00, "un");
        Produto produto2 = new Produto("002", "Mouse", 150.00, "un");
        List<Produto> produtos = Arrays.asList(produto1, produto2);
        Date data = new Date();

        Venda venda = new Venda(data, cliente, produtos, "cartao");

        assertEquals(data, venda.getData());
        assertEquals(cliente, venda.getCliente());
        assertEquals(produtos, venda.getProdutos());
        assertEquals("cartao", venda.getMetodoPagamento());
    }
}
