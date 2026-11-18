package org.example;

import java.util.List;

public class Remessa {

    public boolean liberar() {
        return RemessaFacade.verificarPendenciasLiberacao(this);
    }

    public List<String> listarPendencias() {
        return RemessaFacade.listarPendencias(this);
    }
}
