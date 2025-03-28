package SistemaIngressos;

import static org.junit.jupiter.api.Assertions.*;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.Test;

class IngressoTest {

    @Test
    void deveCriarIngressoComAtributosCorretos() {
        Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL, false, 10.0);

        assertEquals(1, ingresso.getId());
        assertEquals(TipoIngresso.NORMAL, ingresso.getTipo());
        assertFalse(ingresso.isVendido());
        assertEquals(10.0, ingresso.getPreco());
    }
}
