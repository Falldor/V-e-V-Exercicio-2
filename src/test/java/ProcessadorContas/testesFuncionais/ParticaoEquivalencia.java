package ProcessadorContas.testesFuncionais;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.ProcessaContas;
import org.ProcessadorContas.utils.Status;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

public class ParticaoEquivalencia {

    private static ProcessaContas processador;
    private static Fatura fatura;

    @BeforeEach
    public void setup(){
        fatura = new Fatura(1400, LocalDate.of(2025,02,20), "fulano");
    }
    @Test
    public void ContaCreditoAtrasada(){
        Contas conta = new Contas(LocalDate.of(2025,02,06), 1400, TipoPagamento.CARTAO_CREDITO);
        processador = new ProcessaContas(fatura, List.of(conta));
        assertEquals(Status.PENDENTE, fatura.getStatus());
    }

    @Test
    public void ContaCreditoEmDia(){
        Contas conta = new Contas(LocalDate.of(2025,02,05), 1400, TipoPagamento.CARTAO_CREDITO);
        processador = new ProcessaContas(fatura, List.of(conta));
        assertEquals(Status.PAGA, fatura.getStatus());
    }
}
