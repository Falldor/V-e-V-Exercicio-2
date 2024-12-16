package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.ListaContas;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;
import java.util.List;


public class ListaDeContasTest {

    @Test
    public void listaVazia(){
        ListaContas contas = new ListaContas();
        assertEquals(0, contas.size());
    }

    @Test
    public void addContaNaLista(){
        ListaContas contas = new ListaContas();
        Contas conta1 = new Contas(new Date(2024, 12,16), TipoPagamento.BOLETO);
        Contas conta2 = new Contas(new Date(2024, 12,15), TipoPagamento.CARTAO_CREDITO);
        Contas conta3 = new Contas(new Date(2024, 12,14), TipoPagamento.TRANSFERENCIA_BANCARIA);
        contas.addConta(conta1);
        contas.addConta(conta2);
        contas.addConta(conta3);
        assertEquals(3, contas.size());
    }
}
