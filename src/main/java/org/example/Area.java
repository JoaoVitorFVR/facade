package org.example;

import java.util.ArrayList;
import java.util.List;

public abstract class Area {

    private String nome;
    private List<Remessa> remessasComPendencia = new ArrayList<Remessa>();

    protected Area(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void addRemessaPendente(Remessa remessa) {
        this.remessasComPendencia.add(remessa);
    }

    public void removerRemessaPendente(Remessa remessa) {
        this.remessasComPendencia.remove(remessa);
    }

    public boolean verificarRemessaComPendencia(Remessa remessa) {
        return this.remessasComPendencia.contains(remessa);
    }

}
