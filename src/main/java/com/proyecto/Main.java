package com.proyecto;

import java.util.Scanner;

public class Main {
    private static String[] bannerLore;

    // Bloque de inicialización estático (Requisito del proyecto)
    static {
        bannerLore = new String[] {
            "==================================================",
            "                     PHANTOM-7              ",
            "   Infiltrándose en los Servidores de Corp...    ",
            "=================================================="
        };
    }

    public static void main(String[] args) {
        for (String linea : bannerLore) {
            System.out.println(linea);
        }

        // Inicialización clásica del Scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Introduce tu alias de Hacker: ");
        String alias = scanner.nextLine();
        Hacker hacker = new Hacker(alias);

        // ARREGLO ASIMÉTRICO (Estructura irregular de la red corporativa)
        Nodo[][] redServidores = new Nodo[3][];
        redServidores[0] = new Nodo[2]; // Subred Perimetral
        redServidores[1] = new Nodo[3]; // Subred de Datos
        redServidores[2] = new Nodo[1]; // Núcleo Central

        // Inicialización de los nodos con las distintas contramedidas independientes
        redServidores[0][0] = new Nodo("Nodo_Perimetro_A", new Virus(), false);
        redServidores[0][1] = new Nodo("Nodo_Perimetro_B", null, true); // Terminal oculta

        redServidores[1][0] = new Nodo("Nodo_Data_Center", new Ransomware(), false);
        redServidores[1][1] = new Nodo("Nodo_Almacenamiento", new Virus(), false);
        redServidores[1][2] = new Nodo("Nodo_Seguridad_Aux", new CentinelaIA(), false);

        redServidores[2][0] = new Nodo("Nodo_Core_Principal", new CentinelaIA(), false);

        System.out.println("\n--- INICIANDO PROTOCOLO DE EXTRACCIÓN ---");

        // Bucle principal de infiltración a través del arreglo asimétrico
        for (int i = 0; i < redServidores.length; i++) {
            System.out.println("\n>>> Accediendo a la Subred Nivel: " + i + " (Nodos: " + redServidores[i].length + ")");
            
            for (int j = 0; j < redServidores[i].length; j++) {
                Nodo nodoActual = redServidores[i][j];
                System.out.println("\nAnalizando [" + nodoActual.getNombreNodo() + "]...");

                // 1. Evento único mediante Clase Anónima
                if (nodoActual.isTerminalOculta()) {
                    System.out.println(" [\u2605] ¡Brecha detectada! Inyectando script de emergencia...");
                    AccionHack scriptInyeccion = new AccionHack() {
                        @Override
                        public void ejecutar(Hacker h, Contramedida c) {
                            System.out.println(" -> [Script Anónimo] Parcheando cortafuegos del Hacker. +30 Integridad.");
                            h.recibirDaño(-30); 
                        }
                    };
                    scriptInyeccion.ejecutar(hacker, null);
                    continue;
                }

                // 2. Procesamiento de amenazas y Demostración de Castings
                Contramedida amenaza = nodoActual.getContramedida();
                if (amenaza != null) {
                    System.out.println(" ALERT: Amenaza detectada -> " + amenaza.getNombre() + " [ID: " + amenaza.getHashID() + "]");
                    
                    // Uso polimórfico de la interfaz
                    AccionHack ataqueEstandar = new AccionHack() {
                        @Override
                        public void ejecutar(Hacker h, Contramedida c) {
                            System.out.println(" -> Executing 'Descarga_Sobrecarga.exe' contra " + c.getNombre());
                            c.reducirSeguridad(60);
                        }
                    };
                    
                    ataqueEstandar.ejecutar(hacker, amenaza);

                    // DOWNCASTING explícito
                    if (amenaza instanceof Ransomware) {
                        Ransomware rm = (Ransomware) amenaza; 
                        rm.encriptarMemoria(hacker);
                    } else if (amenaza instanceof CentinelaIA) {
                        System.out.println(" -> La IA Centinela está analizando tus puertos de conexión.");
                        hacker.recibirDaño(15);
                    } else if (amenaza instanceof Virus) {
                        System.out.println(" -> El Virus ralentiza tu velocidad de descarga.");
                        hacker.recibirDaño(10);
                    }

                    if (amenaza.getSeguridad() == 0) {
                        System.out.println(" Nodo desinfectado.");
                        hacker.extraerFragmento();
                    }
                }

                if (hacker.getIntegridad() <= 0) {
                    System.out.println("\n [SISTEMA] CONEXIÓN PERDIDA. El hacker fue capturado.");
                    scanner.close(); // Cerramos el scanner manualmente aquí antes de salir por derrota
                    return; 
                }
            }
        }

        System.out.println("\n==================================================");
        System.out.println(" ¡INFILTRACIÓN COMPLETADA CON ÉXITO, " + hacker.getAlias().toUpperCase() + "!");
        System.out.println(" Fragmentos Core Recuperados: " + hacker.getFragmentosCore());
        System.out.println("==================================================");

        scanner.close();
    }
}
