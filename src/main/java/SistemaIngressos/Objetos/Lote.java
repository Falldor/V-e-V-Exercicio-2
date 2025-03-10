package SistemaIngressos.Objetos;

import SistemaIngressos.utils.TipoIngresso;

import java.util.ArrayList;
import java.util.List;

public class Lote {
    private int id;
    private List<Ingresso> ingressos;
    private double desconto;

    public Lote(int id, List<Ingresso> ingressos, double desconto) {
        this.id = id;
        this.ingressos = new ArrayList<Ingresso>();
        checkLote(ingressos);
        this.desconto = Math.min(desconto, 0.25);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        checkLote(ingressos);
    }
    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    private void checkLote(List<Ingresso> ingressos) {
        int qtdIngressos = ingressos.size();
        double qtdIngressosVipMaximo = qtdIngressos * 0.3;
        int qtdIngressosVip = 0;
        double qtdIngressosMeiaMaximo = qtdIngressos * 0.1;
        int qtdIngressosMeia = 0;
        double qtdIngressosNormalMaximo = qtdIngressos - (qtdIngressosVipMaximo + qtdIngressosMeiaMaximo);
        int qtdIngressosNormal = 0;

        for (Ingresso ingresso : ingressos) {
            if (ingresso.getTipo() == TipoIngresso.VIP) {
                if (qtdIngressosVip < qtdIngressosVipMaximo) {
                    this.ingressos.add(ingresso);
                    qtdIngressosVip++;
                } else {
                    throw new IllegalArgumentException("Não pode inserir mais ingressos do tipo vip, cota atingida");
                }
            } else if (ingresso.getTipo() == TipoIngresso.MEIA_ENTRADA) {
                if (qtdIngressosMeia < qtdIngressosMeiaMaximo) {
                    this.ingressos.add(ingresso);
                    qtdIngressosMeia++;
                } else {
                    throw new IllegalArgumentException("Não pode inserir mais ingressos do tipo meia, cota atingida");
                }
            } else if (ingresso.getTipo() == TipoIngresso.NORMAL) {
                if (qtdIngressosNormal < qtdIngressosNormalMaximo) {
                    this.ingressos.add(ingresso);
                    qtdIngressosNormal++;
                } else {
                    throw new IllegalArgumentException("Não pode inserir mais ingressos do tipo normal, cota atingida");
                }
            }
        }
    }
}



