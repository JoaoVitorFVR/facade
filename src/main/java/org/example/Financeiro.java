package org.example;

public class Financeiro extends Area {

    private static Financeiro financeiro = new Financeiro();

    private Financeiro() {
        super("Financeiro");
    };

    public static Financeiro getInstancia() {
        return financeiro;
    }
}
