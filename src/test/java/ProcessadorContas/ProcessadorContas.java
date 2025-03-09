package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.ProcessaContas;
import org.ProcessadorContas.ProcessaContas.*;
import org.ProcessadorContas.utils.Status;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorContas {
    private static Fatura fatura;
    private static List<Contas> listcontas;
    private static ProcessaContas processador;

    @BeforeEach
    public void setup(){
        fatura = new Fatura(1500, LocalDate.of(2023,02,20),"Fulano");
        listcontas = new ArrayList<Contas>();
    }

    @Test
    public void contasBoletos(){
        double[] valores = {500.00,400.00,600.00};
        for(double valor : valores){
            Contas contas = new Contas(LocalDate.of(2023,02,20),valor, TipoPagamento.BOLETO);
            listcontas.add(contas);
        }
        processador = new ProcessaContas(fatura, listcontas);
        assertEquals(Status.PAGA, fatura.getStaus());
    }

    @Test
    public void contasCreditoTempoCerto(){
        listcontas.add(new Contas(LocalDate.of(2023,02,05),700,TipoPagamento.CARTAO_CREDITO));
        listcontas.add(new Contas(LocalDate.of(2023,02,17),800,TipoPagamento.TRANSFERENCIA_BANCARIA));
        processador = new ProcessaContas(fatura,listcontas);
        assertEquals(Status.PAGA,fatura.getStaus());
    }

    @Test
    public void contasCreditoTempoErrado(){
        listcontas.add(new Contas(LocalDate.of(2023,02,06),700,TipoPagamento.CARTAO_CREDITO));
        listcontas.add(new Contas(LocalDate.of(2023,02,17),800,TipoPagamento.TRANSFERENCIA_BANCARIA));
        processador = new ProcessaContas(fatura,listcontas);
        assertEquals(Status.PENDENTE,fatura.getStaus());
    }
}
