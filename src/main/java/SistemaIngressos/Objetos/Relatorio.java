package SistemaIngressos.Objetos;

import SistemaIngressos.utils.Status;
import SistemaIngressos.utils.TipoIngresso;

public class Relatorio {

    private int totalVip = 0, totalNormal = 0, totalMeia = 0;
    private double lucroLiquido = 0.0;
    double receita = 0.0;
    private Status status;

    public int getTotalVip() {
        return totalVip;
    }

    public void setTotalVip(int totalVip) {
        this.totalVip = totalVip;
    }

    public int getTotalNormal() {
        return totalNormal;
    }

    public void setTotalNormal(int totalNormal) {
        this.totalNormal = totalNormal;
    }

    public int getTotalMeia() {
        return totalMeia;
    }

    public void setTotalMeia(int totalMeia) {
        this.totalMeia = totalMeia;
    }

    public double getLucroLiquido() {
        return lucroLiquido;
    }

    public void setLucroLiquido(double lucroLiquido) {
        this.lucroLiquido = lucroLiquido;
    }

    public double getReceita(){return receita;}

    public void setReceita(double receita){this.receita = receita;}

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void gerarRelatorio(Show show) {



        for (Lote lote : show.getLotes()) {
            for (Ingresso ingresso : lote.getIngressos()) {
                if (ingresso.isVendido()) {
                    double preco = ingresso.getPreco();
                    if (lote.getDesconto() > 0 && (ingresso.getTipo() == TipoIngresso.NORMAL || ingresso.getTipo() == TipoIngresso.VIP)) {
                        preco -= preco * lote.getDesconto();
                    }
                    this.receita += preco;

                    if (ingresso.getTipo().equals(TipoIngresso.VIP)) this.totalVip++;
                    else if (ingresso.getTipo().equals(TipoIngresso.NORMAL)) this.totalNormal++;
                    else if (ingresso.getTipo().equals(TipoIngresso.MEIA_ENTRADA)) this.totalMeia++;
                }
            }
        }
        if (show.isDataEspecial()) {
            this.lucroLiquido = this.receita - show.getCache() - show.getDespesas() + (show.getDespesas() * 0.15);

        } else {
            this.lucroLiquido = this.receita - show.getCache() - show.getDespesas();
        }
        this.status = lucroLiquido > 0 ? Status.LUCRO : lucroLiquido == 0 ? Status.ESTAVEL : Status.PREJUIZO;
    }
}

