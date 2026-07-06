package com.proyecto;

public class Hacker {
    private String alias;
    private int integridad;
    private int fragmentosCore;

    public Hacker(String alias) {
        this.alias = alias;
        this.integridad = 100;
        this.fragmentosCore = 0;
    }

    public String getAlias() { 
        return alias; 
    }
    public int getIntegridad() { 
        return integridad; 
    }
    public int getFragmentosCore() { 
        return fragmentosCore; 
    }

    public void recibirDaño(int cantidad) {
        this.integridad -= cantidad;
        if (this.integridad < 0) this.integridad = 0;
        System.out.println(" > Integridad del Hacker disminuida a: " + this.integridad + "%");
    }

    public void extraerFragmento() {
        this.fragmentosCore++;
        System.out.println(" > [\u25C6] ¡Fragmento extraído con éxito! Total: " + this.fragmentosCore);
    }
}