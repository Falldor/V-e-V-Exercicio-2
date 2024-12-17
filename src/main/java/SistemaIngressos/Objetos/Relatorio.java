package SistemaIngressos.Objetos;

public class Relatorio {
    private int vipVendidos;
    private int normalVendidos;
    private double receita;
    private String statusFinanceiro;

    public Relatorio(int vipVendidos, int normalVendidos, double receita, String statusFinanceiro) {
        this.vipVendidos = vipVendidos;
        this.normalVendidos = normalVendidos;
        this.receita = receita;
        this.statusFinanceiro = statusFinanceiro;
    }

    public int getVipVendidos() { return vipVendidos; }
    public int getNormalVendidos() { return normalVendidos; }
    public double getReceita() { return receita; }
    public String getStatusFinanceiro() { return statusFinanceiro; }
    public int getTotalIngressosVendidos() { return vipVendidos + normalVendidos; }
}

