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

public class AnaliseValoresLimites {

    private static Fatura faturaMenor;
    private static Fatura faturaMaior;
    private static ProcessaContas processador;
    @BeforeEach
    public void setup(){
        faturaMenor = new Fatura(1400, LocalDate.of(2023,02,20), "FulanoMenor");
        faturaMaior = new Fatura(5000, LocalDate.of(2023,02,20), "FulanoMaior");
    }


    @Test
    public void casoAbaixoLimiteInferiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),0.001, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMenor, List.of(conta));
        assertEquals(Status.PENDENTE,faturaMenor.getStatus());
    }
    @Test
    public void casoLimiteInferiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),0.01, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMenor, List.of(conta));
        assertEquals(Status.PENDENTE,faturaMenor.getStatus());
    }

    @Test
    public void casoAcimaLimiteInferiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),0.02, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMenor, List.of(conta));
        assertEquals(Status.PENDENTE,faturaMenor.getStatus());
    }

    @Test
    public void casoValorQualquerBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),1400, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMenor, List.of(conta));
        assertEquals(Status.PAGA,faturaMenor.getStatus());
    }

    @Test
    public void casoValorAcimaLimiteSuperiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),5001, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMaior, List.of(conta));
        assertEquals(Status.PENDENTE,faturaMenor.getStatus());
    }

    @Test
    public void casoValorLimiteSuperiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),5000, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMaior, List.of(conta));
        assertEquals(Status.PAGA,faturaMaior.getStatus());
    }

    @Test
    public void casoValorAbaixoLimiteSuperiorBoleto(){
        Contas conta = new Contas(LocalDate.of(2023,02,20),4999, TipoPagamento.BOLETO);
        processador = new ProcessaContas(faturaMaior, List.of(conta));
        assertEquals(Status.PENDENTE,faturaMenor.getStatus());
    }




}
