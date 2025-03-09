package ProcessadorContas;

import org.ProcessadorContas.Objetos.Fatura;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class FaturaTest {

    @Test
    public void criaFatura(){
        Fatura fatura = new Fatura(1500, LocalDate.of(2024,12,30),"Fulano da Silva");
        assertEquals("Fulano da Silva", fatura.getNomeCliente());
    }


}
