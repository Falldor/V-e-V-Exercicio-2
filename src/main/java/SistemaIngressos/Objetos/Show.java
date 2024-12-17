package SistemaIngressos.Objetos;

import java.util.List;

public class Show {
    private String data;
    private String artista;
    private double cache;
    private double despesas;
    private boolean dataEspecial;
    private List<Lote> lotes;

    public Show(String data, String artista, double cache, double despesas, boolean dataEspecial, List<Lote> lotes) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.despesas = dataEspecial ? despesas * 1.15 : despesas;
        this.lotes = lotes;
    }

    public Relatorio gerarRelatorio() {
        int totalVip = 0, totalNormal = 0;
        double receita = 0.0;

        for (Lote lote : lotes) {
            for (Ingresso ingresso : lote.getIngressos()) {
                if (ingresso.isVendido()) {
                    double preco = ingresso.getPreco();
                    if (lote.getDesconto() > 0) {
                        preco -= preco * lote.getDesconto();
                    }
                    receita += preco;

                    if (ingresso.getTipo().equals("VIP")) totalVip++;
                    else if (ingresso.getTipo().equals("NORMAL")) totalNormal++;
                }
            }
        }

        double lucroLiquido = receita - cache - despesas;
        String statusFinanceiro = lucroLiquido > 0 ? "LUCRO" : lucroLiquido == 0 ? "ESTÁVEL" : "PREJUÍZO";

        return new Relatorio(totalVip, totalNormal, receita, statusFinanceiro);
    }
}
