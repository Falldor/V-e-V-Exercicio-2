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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getCache() {
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public boolean isDataEspecial() {
        return dataEspecial;
    }

    public void setDataEspecial(boolean dataEspecial) {
        this.dataEspecial = dataEspecial;
    }

    public List<Lote> getLotes() {
        return lotes;
    }

    public void setLotes(List<Lote> lotes) {
        this.lotes = lotes;
    }
}
