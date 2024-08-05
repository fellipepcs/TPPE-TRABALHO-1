
import org.example.entities.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class CadastroClienteTest {

    private CadastroCliente cadastro;
    private Cliente cliente;
    private String nome;
    private boolean expectedResult;
    private boolean shouldExist;

    @Before
    public void setUp() {
        cadastro = new CadastroCliente();
    }

    public CadastroClienteTest(Cliente cliente, String nome, boolean expectedResult, boolean shouldExist) {
        this.cliente = cliente;
        this.nome = nome;
        this.expectedResult = expectedResult;
        this.shouldExist = shouldExist;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new ClienteEspecial("João", "SP", true), "João", true, true},
                {new ClienteEspecial("Maria", "RJ", false), "Maria", true, true},

                {new ClientePadrao("Pedro", "MG", true), "Pedro", true, true},
                {new ClientePadrao("Ana", "SP", false), "Ana", true, true},

                {new ClientePrime("Carlos", "PR", true), "Carlos", true, true},
                {new ClientePrime("Fernanda", "SC", false), "Fernanda", true, true},

                {new ClienteEspecial("João", "SP", true), "João", false, false},
                {new ClientePadrao("Maria", "RJ", true), "Maria", true, true},
        });
    }

    @Test
    public void testCadastrar() {
        assertEquals(true, cadastro.cadastrar(cliente));
    }

    @Test
    public void testPesquisar() {
        cadastro.cadastrar(cliente);
        Cliente pesquisado = cadastro.pesquisar(nome);
        if (shouldExist) {
            assertNotNull(pesquisado);
            assertEquals(cliente.getNome(), pesquisado.getNome());
        }
    }

    @Test
    public void testRemover() {
        cadastro.cadastrar(cliente);
        boolean removed = cadastro.remover(nome);
        if (shouldExist) {
            assertTrue(removed);
            assertNull(cadastro.pesquisar(nome));
        }
    }

    @Test
    public void testAtualizar() {
        cadastro.cadastrar(cliente);
        cadastro.clienteCadastrado(cliente.getNome());
        Cliente updatedCliente = criarClienteAtualizado(cliente);
        boolean updated = cadastro.atualizar(updatedCliente);
        if (shouldExist) {
            assertTrue(updated);
            assertEquals(updatedCliente.getTipo(), cadastro.pesquisar(cliente.getNome()).getTipo());
        }
    }

    @Test
    public void listarTodos() {
        cadastro.cadastrar(cliente);
        Collection<Cliente> clientes = cadastro.listarTodos();
        assertTrue(clientes.contains(cliente));
    }

    @Test
    public void testCalcularDesconto() {
        double valorTotal = 100.0;
        String metodoPagamento = "4296 13 1234 5678";
        double descontoEsperado;

        if (cliente instanceof ClienteEspecial) {
            descontoEsperado = valorTotal * 0.20;
        } else if (cliente instanceof ClientePrime && metodoPagamento.startsWith("4296 13")) {
            descontoEsperado = valorTotal * 0.20;
        } else {
            descontoEsperado = 0.0;
        }

        double descontoCalculado = cliente.calcularDesconto(valorTotal, metodoPagamento);

        assertEquals(descontoEsperado, descontoCalculado, 0.01);
    }

    @Test
    public void testCalcularCashback() {
        if (cliente instanceof ClientePrime) {
            ClientePrime prime = (ClientePrime) cliente;
            double valorTotal = 100.0;
            String metodoPagamento = "4296 13 1234 5678";
            double cashbackEsperado = metodoPagamento.startsWith("4296 13") ? 0.05 * valorTotal : 0.03 * valorTotal;

            assertEquals(cashbackEsperado, prime.calcularCashback(valorTotal, metodoPagamento), 0.01);
        }
    }

    private Cliente criarClienteAtualizado(Cliente cliente) {
        if (cliente instanceof ClienteEspecial) {
            return new ClienteEspecial(cliente.getNome(), cliente.getEstado(), !cliente.isCapital());
        } else if (cliente instanceof ClientePadrao) {
            return new ClientePadrao(cliente.getNome(), cliente.getEstado(), !cliente.isCapital());
        } else if (cliente instanceof ClientePrime) {
            return new ClientePrime(cliente.getNome(), cliente.getEstado(), !cliente.isCapital());
        }
        return cliente;
    }
}
