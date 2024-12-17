package SistemaIngressos;

import static org.junit.jupiter.api.Assertions.*;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.Objetos.Relatorio;
import SistemaIngressos.Objetos.Show;
import org.junit.jupiter.api.Test;
import java.util.List;

class ShowTest {

    @Test
    void deveGerarRelatorioDoShowComLucro() {
        Ingresso vip = new Ingresso(1, "VIP", true, 20.0);
        Ingresso normal = new Ingresso(2, "NORMAL", true, 10.0);
        Lote lote = new Lote(1, List.of(vip, normal), 0.15);

        Show show = new Show("2024-01-15", "Artista X", 1000.0, 2000.0, true, List.of(lote));
        Relatorio relatorio = show.gerarRelatorio();

        assertEquals(2, relatorio.getTotalIngressosVendidos());
        assertEquals(1, relatorio.getVipVendidos());
        assertEquals(1, relatorio.getNormalVendidos());
        assertEquals("LUCRO", relatorio.getStatusFinanceiro());
    }
}

