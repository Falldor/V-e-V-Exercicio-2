package SistemaIngressos.junit5Tests;

import SistemaIngressos.Objetos.Ingresso;
import SistemaIngressos.Objetos.Lote;
import SistemaIngressos.Objetos.Relatorio;
import SistemaIngressos.Objetos.Show;
import SistemaIngressos.utils.Status;
import SistemaIngressos.utils.TipoIngresso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class tabelaDecisoes {
    Relatorio relatorio;


    @BeforeEach
    public void setup(){
        relatorio = new Relatorio();
    }

    @Nested
    public class LoteTiposIngressos{
        @Test
        public void LoteMeia(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.MEIA_ENTRADA, true, 5);
            Lote lote = new Lote(1, List.of(ingresso),0);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalMeia()) ,
                    () -> assertTrue(ingresso.isVendido())
            );
        }

        @Test
        public void LoteNormal(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL, true, 10);
            Lote lote = new Lote(1, List.of(ingresso),0);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalNormal()),
                    () -> assertTrue(ingresso.isVendido())
            );
        }

        @Test
        public void LoteVip(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.VIP, true, 20);
            Lote lote = new Lote(1, List.of(ingresso),0);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalVip()),
                    () -> assertTrue(ingresso.isVendido())
            );
        }
    }


    @Nested
    public class LoteTiposIngressosComDesconto{
        @Test
        public void LoteNormalDesconto(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.NORMAL, true, 10);
            Lote lote = new Lote(1, List.of(ingresso),0.10);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalNormal()),
                    () -> assertTrue(ingresso.isVendido()),
                    () -> assertEquals(9, relatorio.getReceita())
            );
        }

        @Test
        public void LoteVipDesconto(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.VIP, true, 20);
            Lote lote = new Lote(1, List.of(ingresso),0.10);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalVip()) ,
                    () -> assertTrue(ingresso.isVendido()),
                    () -> assertEquals(18, relatorio.getReceita())
            );
        }

        @Test
        public void LoteMeiaDesconto(){
            Ingresso ingresso = new Ingresso(1, TipoIngresso.MEIA_ENTRADA, true, 5);
            Lote lote = new Lote(1, List.of(ingresso),0.10);
            Show show = new Show("x","x", 1, 1,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalMeia()),
                    () -> assertTrue(ingresso.isVendido()),
                    () -> assertEquals(5, relatorio.getReceita())
            );
        }
    }


    @Nested
    public class StatusRelatorio{
        @Test
        public void RelatorioPositivo(){
            Ingresso ingressoNormal = new Ingresso(1, TipoIngresso.NORMAL, true, 10.0);
            Ingresso ingressoVip = new Ingresso(1, TipoIngresso.VIP, true, 20.0);
            Lote lote = new Lote(1, List.of(ingressoNormal,ingressoNormal, ingressoVip),0.10);
            Show show = new Show("x","x", 10, 5,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalVip()),
                    () -> assertEquals(0, relatorio.getTotalMeia()),
                    () -> assertEquals(2, relatorio.getTotalNormal()),
                    () -> assertEquals(21, relatorio.getLucroLiquido()),
                    () -> assertEquals(Status.LUCRO, relatorio.getStatus())
            );
        }

        @Test
        public void RelatorioEstavel(){
            Ingresso ingressoNormal = new Ingresso(1, TipoIngresso.NORMAL, true, 10.0);
            Ingresso ingressoVip = new Ingresso(1, TipoIngresso.VIP, true, 20.0);
            Lote lote = new Lote(1, List.of(ingressoNormal,ingressoNormal, ingressoVip),0);
            Show show = new Show("x","x", 20, 20,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalVip()),
                    () -> assertEquals(0, relatorio.getTotalMeia()),
                    () -> assertEquals(2, relatorio.getTotalNormal()),
                    () -> assertEquals(0, relatorio.getLucroLiquido()),
                    () -> assertEquals(Status.ESTAVEL, relatorio.getStatus())
            );
        }

        @Test
        public void RelatorioPrejuizo(){
            Ingresso ingressoNormal = new Ingresso(1, TipoIngresso.NORMAL, true, 10.0);
            Ingresso ingressoVip = new Ingresso(1, TipoIngresso.VIP, true, 20.0);
            Lote lote = new Lote(1, List.of(ingressoNormal,ingressoNormal, ingressoVip),0.10);
            Show show = new Show("x","x", 10, 50,false,List.of(lote));
            relatorio.gerarRelatorio(show);
            assertAll(
                    () -> assertEquals(1, relatorio.getTotalVip()),
                    () -> assertEquals(0, relatorio.getTotalMeia()),
                    () -> assertEquals(2, relatorio.getTotalNormal()),
                    () -> assertEquals(-24, relatorio.getLucroLiquido()),
                    () -> assertEquals(Status.PREJUIZO, relatorio.getStatus())
            );
        }
    }
}
