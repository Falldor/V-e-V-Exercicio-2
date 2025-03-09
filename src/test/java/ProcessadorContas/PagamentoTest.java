package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Pagamento;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;

public class PagamentoTest {
    private static Contas conta;

    @BeforeAll
    public static void setup(){
        conta = new Contas(LocalDate.of(2024,12,10),1400, TipoPagamento.BOLETO);
    }

    @Test
    public void criaPagamento(){
        Pagamento pagamento = new Pagamento(conta.getValorPago(),conta.getData(),conta.getTipoPagamento());
        assertEquals(1400, pagamento.getValorPago());
        assertEquals(LocalDate.of(2024,12,10), pagamento.getDataPagamento());
        assertEquals(TipoPagamento.BOLETO,pagamento.getTipoPagamento());
    }
}
