package ProcessadorContas;

import org.ProcessadorContas.Objetos.ListaContas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


public class ListaDeContasTest {

    @Test
    public void listaVazia(){
        ListaContas contas = new ListaContas();
        assertEquals(0, contas.size());
    }
}
