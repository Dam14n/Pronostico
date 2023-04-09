/*
Graba y lee nombres de equipos
*/
package clase7;

import java.io.*;  
import java.util.Scanner;  

public class Ejercicio7_3 {
    public static void main(String[] args) //throws Exception  
    {  
        String datosEquipo;
        String vectorEquipo[];
        Equipo equipo;
        ListaEquipos lista = new ListaEquipos();
            //Establece en el costructor de Scanner que va a tomar datos del archivo Equipos.csv
        try { 
            Scanner sc = new Scanner(new File("./Equipos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosEquipo = sc.next();
                System.out.println(datosEquipo);  //muestra los datos levantados 
                // guarda en un vector los elementos
                vectorEquipo = datosEquipo.split(",");   
                System.out.println("Nombre: "+vectorEquipo[0]+"Descripcion: "+vectorEquipo[1]);
                // graba el equipo en memoria
                equipo = new Equipo (vectorEquipo[0], vectorEquipo[1]);
                // graba el equipo en la lista en memoria
                lista.addEquipo(equipo);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
        System.out.println(lista.listar());  //muestra los datos de la lista
    }
}

