package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContasTest {
    @Test
    public void TestaCriarConta(){
        Contas conta = new Contas(new Date(2024, 12,16),TipoPagemento.BOLETO);
        assertEquals(new Date(2024, 12,16), conta.getDate());
        assertEquals(TipoPagemento, conta.getTipoPagamento());
    }
}
