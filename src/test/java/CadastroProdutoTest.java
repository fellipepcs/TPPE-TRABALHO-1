import org.example.entities.CadastroProduto;
import org.example.entities.Produto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CadastroProdutoTest {
    private String codigo;
    private String descricao;
    private double valor;
    private String unidade;
    private CadastroProduto cadastroProduto;

    public CadastroProdutoTest(String codigo, String descricao, double valor, String unidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.unidade = unidade;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"003", "Tablet", 1500.00, "un"},
                {"004", "Headphones", 500.00, "un"}
        });
    }

    @Before
    public void setUp() {
        cadastroProduto = new CadastroProduto();
    }

    @Test
    public void testCadastrar() {
        Produto produto = cadastroProduto.cadastrar(codigo, descricao, valor, unidade);
        assertEquals(codigo, produto.getCodigo());
        assertEquals(descricao, produto.getDescricao());
        assertEquals(valor, produto.getValor(), 0.01);
        assertEquals(unidade, produto.getUnidade());
    }
}