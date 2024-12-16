package org.ProcessadorContas.Objetos;

import org.ProcessadorContas.utils.TipoPagamento;

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

    public Date getData() {
        return data;
    }

    public TipoPagamento getTipo(){
        return this.tipo;
    }
}
