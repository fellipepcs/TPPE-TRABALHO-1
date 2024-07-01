import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClienteTest {
    @Test
    public void testCliente() {
        Cliente cliente = new Cliente("Especial", 100.00, "SP", true);

        assertEquals("Especial", cliente.getTipo());
        assertEquals(100.00, cliente.getMensalidade());
        assertEquals("SP", cliente.getEstado());
        assertTrue(cliente.isCapital());
    }
}
