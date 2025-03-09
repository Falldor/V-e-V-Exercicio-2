package org.ProcessadorContas;

import org.ProcessadorContas.Objetos.Contas;
import org.ProcessadorContas.Objetos.Fatura;
import org.ProcessadorContas.Objetos.Pagamento;
import org.ProcessadorContas.utils.Status;
import org.ProcessadorContas.utils.TipoPagamento;

import java.util.ArrayList;
import java.util.List;

public class ProcessaContas {


    public ProcessaContas(Fatura fatura, List<Contas> contas){
        List<Pagamento> pagamentos = geraPagamentos(fatura, contas);
        double total = 0;
        for(Pagamento pagamento: pagamentos){
            total += pagamento.getValorPago();
        }

        if(total >= fatura.getValorTotal()){
            fatura.setStaus(Status.PAGA);
        }else{
            fatura.setStaus(Status.PENDENTE);
        }
    }

    private List<Pagamento> geraPagamentos(Fatura fatura, List<Contas> contas){
        List<Pagamento> pagamentos = new ArrayList<Pagamento>();
        for(Contas conta: contas){
            if(conta.getTipoPagamento() == TipoPagamento.BOLETO){
               conta.setValorPago(checkBoleto(conta, fatura));
            }else if (conta.getTipoPagamento() == TipoPagamento.CARTAO_CREDITO){
                conta.setValorPago(checkCredito(conta,fatura));
            } else if (conta.getTipoPagamento() == TipoPagamento.TRANSFERENCIA_BANCARIA) {
                conta.setValorPago(checkTranferencia(conta,fatura));
            }

            Pagamento pagamento = new Pagamento(conta.getValorPago(),conta.getData(), conta.getTipoPagamento());
            pagamentos.add(pagamento);
        }
        return pagamentos;
    }

    private double checkBoleto(Contas conta, Fatura fatura){
        if(conta.getValorPago() > 0.01 && conta.getValorPago() < 5000){
            if(conta.getData().isAfter(fatura.getDataVencimento())){
                conta.setValorPago(conta.getValorPago() * 0.10);
            }
            return conta.getValorPago();
        }
        return 0;
    }

    private double checkCredito(Contas conta, Fatura fatura){
        if(conta.getData().isBefore(fatura.getDataVencimento().minusDays(14))){
            return conta.getValorPago();
        }
        return 0;
    }

    private double checkTranferencia(Contas conta, Fatura fatura){
        if(conta.getData().isBefore(fatura.getDataVencimento())){
            return conta.getValorPago();
        }
        return 0;
    }
}
