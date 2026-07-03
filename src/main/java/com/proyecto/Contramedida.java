package com.proyecto;

public abstract sealed class Contramedida permits Virus, CentinelaIA, Ransomware {
    private String nombre;
    private int seguridad;
    private String hashID;

    // Bloque de inicialización de instancia
    {
        this.hashID = "0x" + Long.toHexString((long) (Math.random() * 0xFFFFFFFFFFL));
    }

    public Contramedida(String nombre, int seguridad) {
        this.nombre = nombre;
        this.seguridad = seguridad;
    }

    public String getNombre() { return nombre; }
    public int getSeguridad() { return seguridad; }
    public String getHashID() { return hashID; }
    
    public void reducirSeguridad(int cantidad) {
        this.seguridad -= cantidad;
        if (this.seguridad < 0) this.seguridad = 0;
    }
}