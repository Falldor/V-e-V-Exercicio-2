package SistemaIngressos.junit5Tests;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoteTest {

    @Test
    void deveCriarLoteComIngressosEAplicarDesconto() {
        Ingresso ingresso1 = new Ingresso(1, TipoIngresso.VIP, false, 20.0);
        Ingresso ingresso2 = new Ingresso(2, TipoIngresso.NORMAL, false, 10.0);
        Lote lote = new Lote(1, List.of(ingresso1, ingresso2), 0.15);

        assertAll(
                () -> assertEquals(1, lote.getId()) ,
                () -> assertEquals(2, lote.getIngressos().size()),
                () -> assertEquals(0.15, lote.getDesconto())
        );
    }

    @ParameterizedTest
    @EnumSource(TipoIngresso.class)
    public void LimitesTiposLotes(TipoIngresso tipo){
        List<Ingresso> ingressos = new ArrayList<Ingresso>();
        for(int i = 0; i < 100; i++){
           Ingresso ingresso = new Ingresso(i,tipo,false,50);
           ingressos.add(ingresso);
        }
        assertThrows(IllegalArgumentException.class, () -> new Lote(1,ingressos,0));
    }
}
