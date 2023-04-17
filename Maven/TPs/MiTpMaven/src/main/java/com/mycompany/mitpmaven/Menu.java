/*
*/
package com.mycompany.mitpmaven;

/**
* @author GRUPO 7
*/

import org.beryx.textio.TextIO;
import org.beryx.textio.system.SystemTextTerminal;

public class Menu {
    public int runMenu() {
        SystemTextTerminal systerm = new SystemTextTerminal();
        TextIO textIO = new TextIO (systerm);
        int opcion;

        do {
            System.out.println();
            System.out.println("      Seleccione una opción     ");
            System.out.println("--------------------------------");
            System.out.println(" 1 - Cargar desde archivos      ");
            System.out.println(" 2 - Cargar desde base de datos ");
            System.out.println("--------------------------------");
            System.out.println(" 0 - Salir                      ");
            System.out.println("--------------------------------");
            System.out.println("--------------------------------");

            opcion = textIO.newIntInputReader()
                     .withMinVal(1)
                     .withMaxVal(9)
                     .read("Opcion : ");

            switch (opcion) {
                case 1 -> {}
                case 2 -> {}
                case 0 -> {
                    System.out.println();
                    System.out.println("Saliendo del programa...");
                    System.out.println();
                    }
                    default -> {
                        // Para evitar un bucle infinito
                        opcion = -1;
                        System.out.println();
                        System.out.println("Opción inválida. Intente de nuevo.");
                        System.out.println();
                }
            }
        } while (opcion != 0);
        
        return opcion;
    }
}
