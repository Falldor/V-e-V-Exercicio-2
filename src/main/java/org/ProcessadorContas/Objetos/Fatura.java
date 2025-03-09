package org.ProcessadorContas.Objetos;

import org.ProcessadorContas.utils.Status;

import java.time.LocalDate;
import java.util.Date;

public class Fatura {

    private String nomeCliente;
    private float valorTotal;
    private LocalDate dataVencimento;

    private Status staus;


    public Fatura(float valorTotal, LocalDate dataVencimento, String nomeCliente ){
        this.nomeCliente = nomeCliente;
        this.dataVencimento = dataVencimento;
        this.valorTotal = valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Status getStaus() {
        return staus;
    }

    public void setStaus(Status staus) {
        this.staus = staus;
    }
}
