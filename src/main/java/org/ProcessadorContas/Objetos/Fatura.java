package org.ProcessadorContas.Objetos;

import java.util.Date;

public class Fatura {

    private String nomeCliente;
    private float valorTotal;
    private Date dataVencimento;


    public Fatura(float valorTotal, Date dataVencimento, String nomeCliente ){
        this.nomeCliente = nomeCliente;
        this.dataVencimento = dataVencimento;
        this.valorTotal = valorTotal;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public String getCliente() {
        return nomeCliente;
    }
}
