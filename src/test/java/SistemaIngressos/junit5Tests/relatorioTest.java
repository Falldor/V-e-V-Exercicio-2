package SistemaIngressos.junit5Tests;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.Objetos.Relatorio;
import SistemaIngressos.Objetos.Show;
import SistemaIngressos.utils.Status;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class relatorioTest {

    Ingresso ingressoVip;
    Ingresso ingressoNormal;
    Lote lote;

    @BeforeEach
    public void setup(){
        ingressoVip = new Ingresso(1, TipoIngresso.NORMAL, true, 10.0);
        ingressoNormal = new Ingresso(1, TipoIngresso.VIP, true, 20.0);
        lote = new Lote(1, List.of(ingressoNormal, ingressoVip), 0);
    }

    @ParameterizedTest
    @CsvSource({
            "100,180,-250, PREJUIZO",
            "20,10,0,ESTAVEL",
            "0,10,20,LUCRO"
    })
    void deveGerarRelatorioDoShow(int cache, int despesa, double liquido, Status status) {
        Show show = new Show("2024-01-15", "Artista X", cache, despesa, false, List.of(lote));
        Relatorio relatorio = new Relatorio();
        relatorio.gerarRelatorio(show);

        assertAll(
                () -> assertEquals(1, relatorio.getTotalVip()),
                () -> assertEquals(0, relatorio.getTotalMeia()),
                () -> assertEquals(1, relatorio.getTotalNormal()),
                () -> assertEquals(liquido, relatorio.getLucroLiquido()),
                () -> assertEquals(status, relatorio.getStatus())
        );
    }
}
