package com.proyecto;

public class Nodo {
    private String nombreNodo;
    private Contramedida contramedida;
    private boolean terminalOculta;

    public Nodo(String nombreNodo, Contramedida contramedida, boolean terminalOculta) {
        this.nombreNodo = nombreNodo;
        this.contramedida = contramedida;
        this.terminalOculta = terminalOculta;
    }

    public String getNombreNodo() { return nombreNodo; }
    public Contramedida getContramedida() { return contramedida; }
    public boolean isTerminalOculta() { return terminalOculta; }
}