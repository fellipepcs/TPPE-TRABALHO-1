import org.junit.Test;

public class VendaTest {

    @Test
    public void testVenda() {
        System.out.println("Teste de venda");
    }

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
