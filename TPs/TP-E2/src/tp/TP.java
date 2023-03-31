/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp;

import java.io.*;  
import java.util.Scanner;  

public class TP {

    public static PronosticoDeportivo PRODE;
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
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
                equipo = new Equipo (vectorEquipo.hashCode(), vectorEquipo[0], vectorEquipo[1]);
                // graba el equipo en la lista en memoria
                lista.addEquipo(equipo);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
        System.out.println(lista.listar());  //muestra los datos de la lista
        
        /*
        PRODE = new PronosticoDeportivo();
        PRODE.cargarEquipos();   
        System.out.println ("=== EQUIPOS ===");
        System.out.println (PRODE.listarEquipos());
        
        System.out.println("*".repeat(40));

        PRODE.cargarParticipantes();   
        System.out.println ("=== PARTICIPANTES ===");
        System.out.println (PRODE.listarParticipantes());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPartidos();   
        System.out.println ("=== PARTIDOS ===");
        System.out.println (PRODE.listarPartidos());
        
        System.out.println("*".repeat(40));

        PRODE.cargarPronosticos();   
        System.out.println ("=== PRONOSTICO ===");
        System.out.println (PRODE.listarPronosticos());
        */
    }
    
}
