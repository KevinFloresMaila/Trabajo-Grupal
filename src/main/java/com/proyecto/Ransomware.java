package com.proyecto;

public final class Ransomware extends Contramedida {
    public Ransomware() { super("Cryptolocker Corporativo", 55); }

    // Método exclusivo para demostrar Downcasting
    public void encriptarMemoria(Hacker hacker) {
        System.out.println(" [\u26A1] ¡ALERTA! El Ransomware ha encriptado tus herramientas.");
        hacker.recibirDaño(25);
    }
}
