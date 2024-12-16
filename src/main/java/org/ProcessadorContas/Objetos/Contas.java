package org.ProcessadorContas.Objetos;

import java.util.Date;
import java.util.UUID;


public class Contas {
    private String codigoConta;
    private Date data;
    private TipoPagamento tipo;

    public Contas(Date dataVencimento,TipoPagamento tipoPagamento){
        this.codigoConta = UUID.randomUUID().toString();
        this.data = dataVencimento;
        this.tipo = tipoPagamento;
    }
}
