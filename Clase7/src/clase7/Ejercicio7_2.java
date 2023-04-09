/*
Graba y lee nombres de equipos
*/
package clase7;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio7_2 {
    public static void main(String[] args) {
        grabarEquipos();
        leerEquipos();
        
    }

    private static void grabarEquipos() {
        Scanner string = new Scanner(System.in);
        Scanner numero = new Scanner(System.in);
        // opcion para seguir cargando
        String nombre;
        FileWriter archivo = null;
        try {
            archivo = new FileWriter("./archivoEquipos.txt");
            // para cargar sin saber la cantidad
            int op = 1;
            while (op != 0) {
                //carga el nombre del equipo
                System.out.print("Ingrese el nombre del equipo : ");
                nombre = string.nextLine();
                // agregar el nombre en el archivo
                archivo.write(nombre + "\n");
                // pregunta si quiere crgar otro
                System.out.print("Ingrese otro equipo? (0-NO) (1-SI): ");
                op = numero.nextInt();
            }       
            archivo.close();
        } catch (IOException ex) {
                System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
    
    private static void leerEquipos() {
        // Fichero del que queremos leer
        File archivo = new File("./archivoEquipos.txt");
        Scanner s = null;

        try {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del archivo ...");
            s = new Scanner(archivo);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                    String nombre = s.nextLine(); 	// Guardamos la linea en un String
                    System.out.println(nombre);      // Imprimimos la linea
            }
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos elarchivo tanto si la lectura ha sido correcta o no
            try {
                    if (s != null)
                            s.close();
            } catch (Exception ex2) {
                    System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }
}

