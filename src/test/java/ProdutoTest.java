import org.example.entities.Produto;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProdutoTest {
    @Test
    public void testProduto() {
        Produto produto = new Produto("001", "Notebook", 3000.00, "un");

        assertEquals("001", produto.getCodigo());
        assertEquals("Notebook", produto.getDescricao());
        assertEquals(3000.00f, produto.getValor(), 0.001);
        assertEquals("un", produto.getUnidade());
    }
}
