package org.example;

public class Logistica extends Area {

    private static Logistica logistica = new Logistica();

    private Logistica() {
        super("Logistica");
    };

    public static Logistica getInstancia() {
        return logistica;
    }
}
