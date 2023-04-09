/*
Cargar y leer un archivo de texto simple
*/
package clase7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7_1 {
    public static void main(String[] args) {
        escribirArchivo();
        leerArchivo();
    }
    
    private static void escribirArchivo() {
        String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };

        FileWriter archivo = null;
        try {
            archivo = new FileWriter("./archivoPrueba.txt");

            // Escribimos linea a linea en el archivo
            for (String linea : lineas) {
                   archivo.write(linea + "\n");
            }

            archivo.close();

        } catch (IOException ex) {
                System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
    
    private static void leerArchivo() {
        // archivo del que queremos leer
        File archivo = new File("./archivoPrueba.txt");
        Scanner s = null;

        try {
            // Leemos el contenido del archivo
            System.out.println("... Leemos el contenido del archivo ...");
            s = new Scanner(archivo);

            // Leemos linea a linea el archivo
            while (s.hasNextLine()) {
                    String linea = s.nextLine(); 	// Guardamos la linea en un String
                    System.out.println(linea);      // Imprimimos la linea
            }
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el archivo tanto si la lectura ha sido correcta o no
            try {
                    if (s != null)
                            s.close();
            } catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }
}

