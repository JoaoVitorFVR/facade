package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RemessaTest {

    @Test
    void deveRetornarPendenciaCozinhaLiberacao() {
        Remessa remessa = new Remessa();
        Cozinha.getInstancia().addRemessaPendente(remessa);

        assertEquals(false, remessa.liberar());
    }

    @Test
    void deveRetornarPendenciaFinanceiroLiberacao() {
        Remessa remessa = new Remessa();
        Financeiro.getInstancia().addRemessaPendente(remessa);

        assertEquals(false, remessa.liberar());
    }

    @Test
    void deveRetornarPendenciaLogisticaLiberacao() {
        Remessa remessa = new Remessa();
        Logistica.getInstancia().addRemessaPendente(remessa);

        assertEquals(false, remessa.liberar());
    }

    @Test
    void deveRetornarRemessaSemPendenciaLiberacao() {
        Remessa remessa = new Remessa();

        assertEquals(true, remessa.liberar());
    }

    @Test
    void deveListarAsAreasComPendencia() {
        Remessa remessa = new Remessa();
        Cozinha.getInstancia().addRemessaPendente(remessa);
        Logistica.getInstancia().addRemessaPendente(remessa);

        List<String> esperado = Arrays.asList("Cozinha", "Logistica");

        assertEquals(esperado, remessa.listarPendencias());
    }

    @Test
    void deveListarVazioQuandoNaoHaPendencia() {
        Remessa remessa = new Remessa();

        assertTrue(remessa.listarPendencias().isEmpty());
    }

    @Test
    void deveLiberarRemessaDepoisDeResolverAPendencia() {
        Remessa remessa = new Remessa();
        Financeiro.getInstancia().addRemessaPendente(remessa);
        assertEquals(false, remessa.liberar());

        Financeiro.getInstancia().removerRemessaPendente(remessa);
        assertEquals(true, remessa.liberar());
    }

    @Test
    void naoDeveAfetarOutraRemessa() {
        Remessa comPendencia = new Remessa();
        Remessa semPendencia = new Remessa();
        Cozinha.getInstancia().addRemessaPendente(comPendencia);

        assertEquals(false, comPendencia.liberar());
        assertEquals(true, semPendencia.liberar());
    }

    @Test
    void deveUsarSempreAsMesmasAreas() {
        assertSame(Cozinha.getInstancia(), Cozinha.getInstancia());
        assertSame(Financeiro.getInstancia(), Financeiro.getInstancia());
        assertSame(Logistica.getInstancia(), Logistica.getInstancia());
    }

}
