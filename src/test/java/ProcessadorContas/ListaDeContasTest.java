package ProcessadorContas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;


public class ListaDeContasTest {

    @Test
    public void listaVazia(){
        Listacontas contas = new ListaContas();
        assertEquals(0, contas.size());
    }
}
