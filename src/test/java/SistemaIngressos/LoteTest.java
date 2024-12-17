package SistemaIngressos;

import static org.junit.jupiter.api.Assertions.*;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import org.junit.jupiter.api.Test;
import java.util.List;

class LoteTest {

    @Test
    void deveCriarLoteComIngressosEAplicarDesconto() {
        Ingresso ingresso1 = new Ingresso(1, "VIP", false, 20.0);
        Ingresso ingresso2 = new Ingresso(2, "NORMAL", false, 10.0);
        Lote lote = new Lote(1, List.of(ingresso1, ingresso2), 0.15);

        assertEquals(1, lote.getId());
        assertEquals(2, lote.getIngressos().size());
        assertEquals(0.15, lote.getDesconto());
    }
}
