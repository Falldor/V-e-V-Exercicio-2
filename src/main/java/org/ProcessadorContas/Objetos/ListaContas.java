package org.ProcessadorContas.Objetos;

import java.util.ArrayList;
import java.util.List;

public class ListaContas {
    private List<Contas> contas;

    public ListaContas(){
        this.contas = new ArrayList<Contas>();
    }

    public void addConta(Contas contas){
        this.contas.add(contas);
    }

    public int size(){
        return this.contas.size();
    }
}
