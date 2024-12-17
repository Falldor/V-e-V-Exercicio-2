package SistemaIngressos.Objetos;

import java.util.List;

public class Lote {
    private int id;
    private List<Ingresso> ingressos;
    private double desconto; // Máximo de 0.25 (25%)

    public Lote(int id, List<Ingresso> ingressos, double desconto) {
        this.id = id;
        this.ingressos = ingressos;
        this.desconto = Math.min(desconto, 0.25); // Garante limite
    }

    public int getId() { return id; }
    public List<Ingresso> getIngressos() { return ingressos; }
    public double getDesconto() { return desconto; }
}

