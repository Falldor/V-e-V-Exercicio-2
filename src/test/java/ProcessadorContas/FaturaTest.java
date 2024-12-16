package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.Objetos.ListaContas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;

public class FaturaTest {

    @Test
    public void criaFatura(){
        Fatura fatura = new Fatura(1500,new Date(2024,12,30),"Fulano da Silva");
        assertEquals("Fulano da silva", fatura.getCliente());
    }
}
