package SistemaIngressos;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.Objetos.Relatorio;
import SistemaIngressos.Objetos.Show;
import SistemaIngressos.utils.Status;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class RelatorioTest {

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
    void deveGerarRelatorioDoShowComLucro() {
        Show show = new Show("2024-01-15", "Artista X", 1000.0, 2000.0, true, List.of(lote));
        Relatorio relatorio = new Relatorio();
        relatorio.gerarRelatorio(show);

        assertEquals(1, relatorio.getTotalVip());
        assertEquals(0, relatorio.getTotalMeia());
        assertEquals(1, relatorio.getTotalNormal());
        assertEquals(-3274.5, relatorio.getLucroLiquido());
        assertEquals(Status.PREJUIZO, relatorio.getStatus());
    }
}
