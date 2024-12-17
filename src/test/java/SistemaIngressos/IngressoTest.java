package SistemaIngressos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class IngressoTest {

    @Test
    void deveCriarIngressoComAtributosCorretos() {
        Ingresso ingresso = new Ingresso(1, "NORMAL", false, 10.0);

        assertEquals(1, ingresso.getId());
        assertEquals("NORMAL", ingresso.getTipo());
        assertFalse(ingresso.isVendido());
        assertEquals(10.0, ingresso.getPreco());
    }
}
