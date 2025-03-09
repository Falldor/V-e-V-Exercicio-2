package ProcessadorContas.junit5Tests;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.ProcessaContas;
import org.ProcessadorContas.utils.Status;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessadorContas {

    private static Fatura fatura;
    private static Fatura faturaMaior;
    private static List<Contas> listcontas;
    private static ProcessaContas processador;

    @BeforeEach
    public void setup(){
        fatura = new Fatura(1500, LocalDate.of(2023,02,20),"Fulano");
        faturaMaior = new Fatura(1500, LocalDate.of(2023,02,20),"Fulano");
        listcontas = new ArrayList<Contas>();
    }

    @Nested
    class PagamentoBoleto{

        @Test
        void contasBoletos(){
            double[] valores = {500.00,400.00,600.00};
            for(double valor : valores){
                Contas contas = new Contas(LocalDate.of(2023,02,20),valor, TipoPagamento.BOLETO);
                listcontas.add(contas);
            }
            processador = new ProcessaContas(fatura, listcontas);
            assertEquals(Status.PAGA, fatura.getStatus());
        }

        @ParameterizedTest
        @ValueSource(doubles = {0.001, 0.01,0.02})
        void CasosLimiteInferior(double valores){
            Contas conta = new Contas(LocalDate.of(2023,02,20),valores, TipoPagamento.BOLETO);
            processador = new ProcessaContas(fatura, List.of(conta));
            assertEquals(Status.PENDENTE,fatura.getStatus());
        }

        @ParameterizedTest
        @ValueSource(doubles = {4999, 5001})
        void CasosLimiteSuperior(double valores){
            Contas conta = new Contas(LocalDate.of(2023,02,20),valores, TipoPagamento.BOLETO);
            processador = new ProcessaContas(faturaMaior, List.of(conta));
            assertEquals(Status.PENDENTE,fatura.getStatus());
        }

        @Test
        void CasoLimiteMaximo(){
            Contas conta = new Contas(LocalDate.of(2023,02,20),5000, TipoPagamento.BOLETO);
            processador = new ProcessaContas(faturaMaior, List.of(conta));
            assertEquals(Status.PAGA,faturaMaior.getStatus());
        }
    }

    @Nested
    class PagamentoCartaoCredito{
        @Test
        public void contasCreditoTempoCerto(){
            listcontas.add(new Contas(LocalDate.of(2023,02,05),700, TipoPagamento.CARTAO_CREDITO));
            listcontas.add(new Contas(LocalDate.of(2023,02,17),800,TipoPagamento.TRANSFERENCIA_BANCARIA));
            processador = new ProcessaContas(fatura,listcontas);
            assertEquals(Status.PAGA,fatura.getStatus());
        }

        @Test
        public void contasCreditoTempoErrado(){
            listcontas.add(new Contas(LocalDate.of(2023,02,06),700,TipoPagamento.CARTAO_CREDITO));
            listcontas.add(new Contas(LocalDate.of(2023,02,17),800,TipoPagamento.TRANSFERENCIA_BANCARIA));
            processador = new ProcessaContas(fatura,listcontas);
            assertEquals(Status.PENDENTE,fatura.getStatus());
        }
    }
}
