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
        Contas conta1 = new Contas(new Date(2024, 12,16), 500);
        Contas conta2 = new Contas(new Date(2024, 12,15), 700);
        Contas conta3 = new Contas(new Date(2024, 12,14), 400);
        contas.addConta(conta1);
        contas.addConta(conta2);
        contas.addConta(conta3);
        assertEquals(3, contas.size());
    }

    @Test
    public void criaPagamentos(){
        ListaContas contas = new ListaContas();
        for(int i = 0; i < 10; i++){
            Contas conta = new Contas(new Date(2024,12,1),4999);
            contas.addConta(conta);
            contas.criaPagamento(conta.getCodigo());
        }
        assertEquals(10,contas.sizePagamentos());
    }




}
