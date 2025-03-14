package org.ProcessadorContas.Objetos;

import org.ProcessadorContas.utils.TipoPagamento;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;


public class Contas {
    private String codigoConta;
    private LocalDate data;
    private double valorPago;
    private TipoPagamento tipoPagamento;

    public Contas(LocalDate data, double valorPago, TipoPagamento tipoPagamento) {
        this.codigoConta =  UUID.randomUUID().toString();
        this.data = data;
        this.valorPago = valorPago;
        this.tipoPagamento = tipoPagamento;
    }

    public String getCodigoConta() {
        return codigoConta;
    }

    public void setCodigoConta(String codigoConta) {
        this.codigoConta = codigoConta;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
