/*
*/
package com.mycompany.mitpmaven;

/**
* @author GRUPO 7
*/

import static com.mycompany.mitpmaven.BaseDeDatos.abrirConexion;
import static com.mycompany.mitpmaven.BaseDeDatos.cerrarConexion;
import static com.mycompany.mitpmaven.BaseDeDatos.crearSentencia;
import de.vandermeer.asciitable.AsciiTable;
import java.io.File;
import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.beryx.textio.TextIO;
//import org.beryx.textio.TextTerminal;
//import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;
//import org.beryx.textio.system.SystemTextTerminal;

public class ListaEquipos {
    // Atributos
    private List<Equipo> equipos;
    private String equiposCSV;
    private Object textIO;
    private TextTerminal<?> systerm;
    
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

    /***
     * Este método devuelve un Equipo (o null) buscandolo por idEquipo
     * @param idEquipo Identificador del equipo deseado
     * @return Objeto Equipo (o null si no se encuentra)
     */
    public Equipo getEquipo (int idEquipo) {
        // Defini un objeto de tipo Equipo en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Equipo encontrado = null;
        // Recorro la lista de equipos que está cargada
        for (Equipo eq : this.getEquipos()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdEquipo() == idEquipo) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el equipo, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }
    
    @Override
    public String toString() {
        return "ListaEquipos{" + "equipos=" + equipos + '}';
    }

    // Metodos Especificos    
    public void listados(int opcion) {
        switch (opcion) {
            case 1 -> System.out.println(listar());  // Listado para carga de archivos
            case 2 -> listarEnTabla();   // Listado para carga de DB
            default -> {
                System.out.println();
                System.out.println("Opción no implementada.");
                System.out.println();
            }
        }
    }
    
    public String listar() {
        String lista = "";

        lista += System.lineSeparator();
        lista += "Los equipos cargados son : " + System.lineSeparator();
        lista += "--------------------------" + System.lineSeparator();
        
        for (Equipo equipo: equipos) {
            lista += equipo + System.lineSeparator();
        }           
        
        return lista;
    }
    
    public void listarEnTabla() {
        SystemTextTerminal systerm = new SystemTextTerminal();
        TextIO textIO = new TextIO (systerm);
        TextTerminal terminal = textIO.getTextTerminal();
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("    Número    ","    Descripción    ");
        at.addRule();

        for (Equipo equipo: equipos) {
            at.addRow(equipo.getIdEquipo(), equipo.getNombre());
        }           

        at.addRule();
        String rend = at.render();
        terminal.print (rend);
        System.out.println();
    }
    
    // Seleccion de la carga de datos
    public void cargaDeDatos(int opcion, ListaEquipos listaequipos) {
        switch (opcion) {
            case 1 -> cargarDeArchivo(listaequipos);  // Carga desde la base de datos0
            case 2 -> cargarDeDb(listaequipos);   // Carga desde la base de datos
            default -> {
                System.out.println();
                System.out.println("Opción no implementada.");
                System.out.println();
            }
        }
    }
    
    // cargar desde el archivo
    public void cargarDeArchivo(ListaEquipos listaequipos) {
        // para las lineas del archivo csv
        String datosEquipo;
        // para los datos individuales de cada linea
        String vectorEquipo[];
        // para el objeto en memoria
        Equipo equipo;
        int fila = 0;
       
        System.out.println ();
        System.out.println("Cargando desde archivo " + " ...");
        System.out.println ();

        try { 
            //Scanner sc = new Scanner(new File("./Archivos/equipos.csv"));
            Scanner sc;
            sc = new Scanner(new File(this.getEquiposCSV()));
            sc.useDelimiter(System.lineSeparator() );   //setea el separador de los datos

            //System.out.println("Los equipos cargados en el archivo son : ");
            //System.out.println("----------------------------------------");

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosEquipo = sc.next();
                //System.out.println(datosEquipo);  //muestra los datos levantados 
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
                //System.out.println(equipo);  //muestra los datos levantados 
            }

            //closes the scanner
            sc.close();
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
    }
    
    // cargar desde la base de datos
    public void cargarDeDb(ListaEquipos listaequipos) {
        // Todas las lineas comentadas son del codigo original 
        //Connection conn = null;
        
        try {
            
            // Establecer una conexión
            //conn = DriverManager.getConnection("jdbc:sqlite:./Archivos/pronosticos.db");
            //conn = abrirConexion();
            abrirConexion();
            
            // Crear la base de datos
            // Statement stmt = conn.createStatement();
            Statement stmt = crearSentencia();

            //System.out.println("Consultando datos...");
            String sql = "SELECT idEquipo, Nombre, Descripcion FROM equipos";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set

            //System.out.println("Cargando los datos en ListaEquipos...");

            //ListaEquipos lista = new ListaEquipos();
            while (rs.next()) {
                Equipo e = new Equipo(
                        rs.getInt("idEquipo"),
                        rs.getString("Nombre"),
                        rs.getString("Descripcion")
                );
                
                //lista.addEquipo(e);
                listaequipos.addEquipo(e);
            }

            //System.out.println("Mostrando los OBJETOS de ListaEquipos...");
            //System.out.println(lista.listar());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarConexion();
        }
    }
}