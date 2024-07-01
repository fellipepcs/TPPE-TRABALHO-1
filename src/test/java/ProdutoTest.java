import org.junit.Test;

public class ProdutoTest {
    @Test
    public void testProduto() {
        Produto produto = new Produto("001", "Notebook", 3000.00, "un");

        assertEquals("001", produto.getCodigo());
        assertEquals("Notebook", produto.getDescricao());
        assertEquals(3000.00, produto.getValor());
        assertEquals("un", produto.getUnidade());
    }
}
