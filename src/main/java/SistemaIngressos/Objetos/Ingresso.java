package SistemaIngressos.Objetos;

import SistemaIngressos.utils.TipoIngresso;

public class Ingresso {
    private int id;
    private TipoIngresso tipo;
    private boolean vendido;
    private double preco;

    public Ingresso(int id, TipoIngresso tipo, boolean vendido, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.vendido = vendido;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoIngresso getTipo() {
        return tipo;
    }

    public void setTipo(TipoIngresso tipo) {
        this.tipo = tipo;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void marcarComoVendido() { this.vendido = true; }
}
