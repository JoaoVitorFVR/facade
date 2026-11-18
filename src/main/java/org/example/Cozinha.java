package org.example;

public class Cozinha extends Area {

    private static Cozinha cozinha = new Cozinha();

    private Cozinha() {
        super("Cozinha");
    };

    public static Cozinha getInstancia() {
        return cozinha;
    }
}
