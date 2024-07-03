import org.example.entities.Produto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ProdutoTest {
    private final Produto produto;
    private final String codigoEsperado;
    private final String descricaoEsperada;
    private final double valorEsperado;
    private final String unidadeEsperada;

    public ProdutoTest(Produto produto, String codigoEsperado, String descricaoEsperada, double valorEsperado, String unidadeEsperada) {
        this.produto = produto;
        this.codigoEsperado = codigoEsperado;
        this.descricaoEsperada = descricaoEsperada;
        this.valorEsperado = valorEsperado;
        this.unidadeEsperada = unidadeEsperada;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new Produto("001", "Notebook", 3000.00, "un"), "001", "Notebook", 3000.00, "un"},
                {new Produto("002", "Smartphone", 2000.00, "un"), "002", "Smartphone", 2000.00, "un"},
                {new Produto("003", "Tablet", 1500.00, "un"), "003", "Tablet", 1500.00, "un"},
                {new Produto("004", "Headphones", 500.00, "un"), "004", "Headphones", 500.00, "un"}
        });
    }

    @Test
    public void testProduto() {
        assertEquals(codigoEsperado, produto.getCodigo());
        assertEquals(descricaoEsperada, produto.getDescricao());
        assertEquals(valorEsperado, produto.getValor(), 0.001);
        assertEquals(unidadeEsperada, produto.getUnidade());
    }
}
