package SistemaIngressos.junit5Tests;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.Objetos.Show;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class showTest {

    Ingresso ingressoVip;
    Ingresso ingressoNormal;
    Lote lote;
    @BeforeEach
    public void setup(){
        ingressoVip = new Ingresso(1, TipoIngresso.NORMAL, false, 10.0);
        ingressoNormal = new Ingresso(1, TipoIngresso.VIP, false, 20.0);
        lote = new Lote(1, List.of(ingressoVip, ingressoVip), 0.15);
    }

    @Test
    public void criaShow(){
        Show show = new Show("2024-12-20","Artista X", 1000, 2000,false, List.of(lote));
        assertAll(
                () ->  assertEquals("2024-12-20", show.getData()),
                () ->  assertEquals("Artista X", show.getArtista()),
                () ->  assertEquals(1000,show.getCache()),
                () ->  assertEquals(2000, show.getDespesas()),
                () ->  assertFalse(show.isDataEspecial()),
                () ->  assertEquals(1, List.of(lote).size())
        );
    }
}
