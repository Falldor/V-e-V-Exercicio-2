package SistemaIngressos.junit5Tests;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ingressoTest {

    @Test
    void deveCriarIngressoComAtributosCorretos() {
        Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL, false, 10.0);

        assertAll(
                () -> assertEquals(1, ingresso.getId()),
                () -> assertEquals(TipoIngresso.NORMAL, ingresso.getTipo()),
                () -> assertFalse(ingresso.isVendido()),
                () -> assertEquals(10.0, ingresso.getPreco())
        );
    }
}
