package org.ProcessadorContas.Objetos;

import java.util.Date;
import java.util.UUID;


public class Contas {
    private String codigoConta;
    private Date data;
    private Float valorPago;

    public Contas(Date dataVencimento,float valorPago){
        this.codigoConta = UUID.randomUUID().toString();
        this.data = dataVencimento;
        this.valorPago = valorPago;
    }

    public Date getData() {
        return data;
    }

    public float getValorPago(){
        return this.valorPago;
    }
}
