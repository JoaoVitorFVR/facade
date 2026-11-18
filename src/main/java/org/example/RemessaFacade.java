package org.example;

import java.util.ArrayList;
import java.util.List;

public class RemessaFacade {

    public static List<String> listarPendencias(Remessa remessa) {
        List<String> pendencias = new ArrayList<String>();
        if (Cozinha.getInstancia().verificarRemessaComPendencia(remessa)) {
            pendencias.add(Cozinha.getInstancia().getNome());
        }
        if (Financeiro.getInstancia().verificarRemessaComPendencia(remessa)) {
            pendencias.add(Financeiro.getInstancia().getNome());
        }
        if (Logistica.getInstancia().verificarRemessaComPendencia(remessa)) {
            pendencias.add(Logistica.getInstancia().getNome());
        }
        return pendencias;
    }

    public static boolean verificarPendenciasLiberacao(Remessa remessa) {
        return listarPendencias(remessa).isEmpty();
    }
}
