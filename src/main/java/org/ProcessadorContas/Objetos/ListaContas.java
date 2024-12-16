package org.ProcessadorContas.Objetos;

import java.util.ArrayList;
import java.util.List;

public class ListaContas {
    private List<Contas> contas;

    public ListaContas(){
        this.contas = new ArrayList<Contas>();
    }

    public int size(){
        return this.contas.size();
    }
}
