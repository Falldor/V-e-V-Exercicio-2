package ProcessadorContas.junit5Tests;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

class Objetos {

    @Nested
    class CriaObjetos{
        private Contas conta;
        private LocalDate data = LocalDate.of(2025, 03, 10);

        @Test
        void criaFatura(){
            Fatura fatura = new org.ProcessadorContas.Objetos.Fatura(1500, data,"Fulano da Silva");
            assertAll(
                    () -> assertEquals("Fulano da Silva", fatura.getNomeCliente()),
                    () -> assertEquals(LocalDate.of(2025,03, 10), fatura.getDataVencimento()),
                    () -> assertEquals(1500, fatura.getValorTotal())
            );

        }

        @Test
        void CriarConta(){
            conta = new Contas(data, 400, TipoPagamento.BOLETO);
            assertAll(
                    () -> assertEquals(LocalDate.of(2025,03, 10), conta.getData()),
                    () -> assertEquals(400, conta.getValorPago()),
                    () -> assertEquals(TipoPagamento.BOLETO, conta.getTipoPagamento())
            );
        }

        @Test
        public void criaPagamento(){
            conta = new Contas(data, 1400, TipoPagamento.BOLETO);
            org.ProcessadorContas.Objetos.Pagamento pagamento = new org.ProcessadorContas.Objetos.Pagamento(conta.getValorPago(),conta.getData(),conta.getTipoPagamento());
            assertAll(
                    () -> assertEquals(1400, pagamento.getValorPago()),
                    () -> assertEquals(data, pagamento.getDataPagamento()),
                    () -> assertEquals(TipoPagamento.BOLETO,pagamento.getTipoPagamento())
            );

        }
    }

}
