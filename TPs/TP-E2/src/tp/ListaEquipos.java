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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ListaEquipos {
    // Atributos
    private List<Equipo> equipos;
    private String equiposCSV;
    
    // Metodos
    public ListaEquipos(List<Equipo> equipos, String equiposCSV) {
        this.equipos = equipos;
        this.equiposCSV = equiposCSV;
    }
    
    public ListaEquipos() {
        this.equipos = new ArrayList<Equipo>();
        this.equiposCSV = "./Archivos/equipos.csv";
    }
    
    public List<Equipo> getEquipos() {
        return equipos;
    }
    
    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public String getEquiposCSV() {
        return equiposCSV;
    }

    public void setEquiposCSV(String equiposCSV) {
        this.equiposCSV = equiposCSV;
    }
    
    // Agregar elemento a la lista
    public void addEquipo(Equipo equipo) {
        this.equipos.add(equipo);
    }

    // Eliminar elemento de la lista
    public void removeEquipo(Equipo equipo) {
        this.equipos.remove(equipo);
    }


    public Equipo getEquipo(int idEquipo) {
        Equipo encontrado = null;
                
        // Recorro la lista
        for (Equipo equipo : this.getEquipos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (equipo.getIdEquipo() == idEquipo) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = equipo;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }

        return encontrado;
    }

    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }

    // Metodos Especificos    
    public String listar() {
        String lista = "";
        for (Equipo equipo: equipos) {
            lista += System.lineSeparator() + equipo;  // System.lineSeparator() se utiliza com separador de linea pero por S.O.
        }           
        
        return lista;
    }

    // Raaliza la carga desde el archivo especificado
    public void cargarDeArchivo() {
        // para las lineas del archivo csv
        String datosEquipo;
        // para los datos individuales de cada linea
        String vectorEquipo[];
        // para el objeto en memoria
        Equipo equipo;
        int fila = 0;
       
        try { 
            Scanner sc = new Scanner(new File("./Archivos/equipos.csv"));
            // sc.useDelimiter("\n");   //setea el separador de los datos
            sc.useDelimiter(System.lineSeparator() );   //setea el separador de los datos // System.lineSeparator() se utiliza com separador de linea pero por S.O.
               
            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosEquipo = sc.next();
                System.out.println(datosEquipo);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorEquipo = datosEquipo.split(",");   
                
                // graba el equipo en memoria
                // convertir un string a un entero;
                int readIdEquipo = Integer.parseInt(vectorEquipo[0]);
                String readNombre = vectorEquipo[1];
                String readDescripcion = vectorEquipo[2];
                // crea el objeto en memoria
                equipo = new Equipo(readIdEquipo, readNombre, readDescripcion);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                this.addEquipo(equipo);
            }
            //closes the scanner
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
    }
}