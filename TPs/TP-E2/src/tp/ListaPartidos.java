/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp;

/**
 *
 * @author GRUPO 7
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ListaPartidos {
    // Atributos
    private List<Partido> partidos;
    private String partidosCSV;
    
    // Metodos
    public ListaPartidos(List<Partido> partidos, String partidosCSV) {
        this.partidos = partidos;
        this.partidosCSV = partidosCSV;
    }
    
    public ListaPartidos() {
        this.partidos = new ArrayList<Partido>();
        this.partidosCSV = "./Archivos/partidos.csv";
    }
    
    public List<Partido> getEquipos() {
        return partidos;
    }
    
    public void setEquipos(List<Partido> partidos) {
        this.partidos = partidos;
    }

    // Agregar elemento a la lista
    public void addPartido(Partido partido) {
        this.partidos.add(partido);
    }

    // Eliminar elemento de la lista
    public void removePartido(Partido partido) {
        this.partidos.remove(partido);
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + partidos + '}';
    }
    
    // Metodos Especificos    
    public String listar() {
        String lista = "";
        for (Partido partido: partidos) {
            lista += System.lineSeparator() + partido;  // System.lineSeparator() se utiliza com separador de linea pero por S.O.
        }           
        return lista;
    }

    // Raaliza la carga desde el archivo especificado
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosPartido;
        // para los datos individuales de cada linea
        String vectorPartido[];
        // para el objeto en memoria
        Partido partido;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./Archivos/partidos.csv"));
            sc.useDelimiter("\n");   //setea el separador de los datos
                
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosPartido = sc.next();
                System.out.println(datosPartido);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorPartido = datosPartido.split(",");   
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int idPartido = Integer.parseInt(vectorPartido[0]);
                //String nombre = 0//vectorPartido[1];
                //String descripcion = vectorPartido[2];
                // crea el objeto en memoria
                //partido = new Partido(idPartido, nombre, descripcion);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                //this.addPartido(partido);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }           
    }
}