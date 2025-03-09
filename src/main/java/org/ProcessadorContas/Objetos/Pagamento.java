package org.ProcessadorContas.Objetos;

import org.ProcessadorContas.utils.TipoPagamento;

import java.time.LocalDate;

public class Pagamento {

    private double valorPago;
    private LocalDate DataPagamento;
    private TipoPagamento tipoPagamento;

    public Pagamento(double valorPago, LocalDate dataPagamento, TipoPagamento tipoPagamento) {
        this.valorPago = valorPago;
        DataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return DataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        DataPagamento = dataPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
