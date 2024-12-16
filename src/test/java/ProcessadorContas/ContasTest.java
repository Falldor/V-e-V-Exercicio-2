package ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.utils.TipoPagamento;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContasTest {
    @Test
    public void TestaCriarConta(){
        Contas conta = new Contas(new Date(2024, 12,16), 400);
        assertEquals(new Date(2024, 12,16), conta.getData());
        assertEquals(400, conta.getValorPago());
    }
}
