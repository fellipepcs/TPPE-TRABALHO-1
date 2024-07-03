import org.example.entities.Cliente;
import org.example.entities.ClienteEspecial;
import org.example.entities.ClientePrime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ClienteTest {
    private final Cliente cliente;
    private final String nomeEsperado;
    private final String estadoEsperado;
    private final String tipoEsperado;

    public ClienteTest(Cliente cliente, String nomeEsperado, String estadoEsperado, String tipoEsperado) {
        this.cliente = cliente;
        this.nomeEsperado = nomeEsperado;
        this.estadoEsperado = estadoEsperado;
        this.tipoEsperado = tipoEsperado;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new ClienteEspecial("fellipe", "SP", true), "fellipe", "SP", "Especial"},
                {new ClienteEspecial("ana", "RJ", false), "ana", "RJ", "Especial"},
                {new ClienteEspecial("joao", "MG", true), "joao", "MG", "Especial"}
        });
    }

    @Test
    public void testCliente() {
        assertEquals(tipoEsperado, cliente.getTipo());
        assertEquals(nomeEsperado, cliente.getNome());
        assertEquals(estadoEsperado, cliente.getEstado());
    }
}
