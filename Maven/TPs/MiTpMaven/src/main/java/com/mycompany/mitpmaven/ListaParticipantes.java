/*
Clase ListaParticipantes para la entrega 2
 */
package com.mycompany.mitpmaven;

import static com.mycompany.mitpmaven.BaseDeDatos.abrirConexion;
import static com.mycompany.mitpmaven.BaseDeDatos.cerrarConexion;
import static com.mycompany.mitpmaven.BaseDeDatos.crearSentencia;
import de.vandermeer.asciitable.AsciiTable;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

public class ListaParticipantes {
    // atributo
    private List<Participante> participantes;
    private String participantesCSV;

    public ListaParticipantes(List<Participante> participantes, String participantesCSV) {
        this.participantes = participantes;
        this.participantesCSV = participantesCSV;
    }
    
    public ListaParticipantes() {
        this.participantes = new ArrayList<Participante>();
        this.participantesCSV = "./Archivos/participantes.csv";
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getParticipantesCSV() {
        return participantesCSV;
    }

    public void setParticipantesCSV(String participantesCSV) {
        this.participantesCSV = participantesCSV;
    }
    
    // add y remove elementos
    public void addParticipante(Participante p) {
        this.participantes.add(p);
    }
    public void removeParticipante(Participante p) {
        this.participantes.remove(p);
    }
    
    @Override
    public String toString() {
        return "ListaParticipantes{" + "participantes=" + participantes + '}';
    }

    /***
     * Este método devuelve un Participante (o null) buscandolo por idParticipante
     * @param idParticipante Identificador del equipo deseado
     * @return Objeto Participante (o null si no se encuentra)
     */
    public Participante getParticipante (int idParticipante) {
        // Defini un objeto de tipo Participante en dónde va a ir mi resultado
        // Inicialmente es null, ya que no he encontrado el equipo que 
        // buscaba todavía.
        Participante encontrado = null;
        // Recorro la lista de participantes que está cargada
        for (Participante eq : this.getParticipantes()) {
            // Para cada equipo obtengo el valor del ID y lo comparo con el que
            // estoy buscando
            if (eq.getIdParticipante() == idParticipante) {
                // Si lo encuentro (son iguales) lo asigno como valor de encontrado
                encontrado = eq;
                // Y hago un break para salir del ciclo ya que no hace falta seguir buscando
                break;
            }
        }
        // Una vez fuera del ciclo retorno el Participante, pueden pasar dos cosas:
        // 1- Lo encontré en el ciclo, entonces encontrado tiene el objeto encontrado
        // 2- No lo encontré en el ciclo, entonces conserva el valor null del principio
        return encontrado;
    }

    // Metodos Especificos    
    public void listar(int opcion) {
        switch (opcion) {
            case 1 :
                listadoEstandar();  // Listado para carga de archivos
                break;
            case 2 :
                listadoTabla();   // Listado para carga de DB
                break;
            default :
                System.out.println();
                System.out.println("Opción no implementada.");
                System.out.println();
        }
    }

    public void listadoEstandar() {
        String lista = "";

        lista += System.lineSeparator();
        lista += "Los participantes cargados son : " + System.lineSeparator();
        lista += "--------------------------------" + System.lineSeparator();
        
        for (Participante participante: participantes) {
            lista += participante + System.lineSeparator();
        }           
 
        System.out.println(lista);
    }
    
    public void listadoTabla() {
        SystemTextTerminal systerm = new SystemTextTerminal();
        TextIO textIO = new TextIO (systerm);
        TextTerminal terminal = textIO.getTextTerminal();
        AsciiTable at = new AsciiTable();
        at.addRule();
        at.addRow("    Número    ","    Descripción    ");
        at.addRule();

        for (Participante participante : participantes) {
            at.addRow(participante.getIdParticipante(), participante.getNombre());
        }           

        at.addRule();
        String rend = at.render();
        terminal.print (rend);
        System.out.println();
    }
    
    // Seleccion de la carga de datos
    public void cargaDeDatos(int opcion, ListaParticipantes listaparticipantes) {
        switch (opcion) {
            case 1 :
                cargarDeArchivo(listaparticipantes);  // Carga desde la base de datos0
                break;
            case 2 :
                cargarDeDb(listaparticipantes);   // Carga desde la base de datos
                break;
            default :
                System.out.println();
                System.out.println("Opción no implementada.");
                System.out.println();
        }
    }

    // cargar desde el archivo
    public void cargarDeArchivo(ListaParticipantes listaparticipantes) {
        // para las lineas del archivo csv
        String datosParticipante;
        // para los datos individuales de cada linea
        String vectorParticipante[];
        // para el objeto en memoria
        Participante participante;
        int fila = 0;
       
        try { 
            Scanner sc;
            sc = new Scanner(new File(this.getParticipantesCSV()));
            sc.useDelimiter(System.lineSeparator() );   //setea el separador de los datos
                
            //System.out.println("Los participantes cargados en el archivo son : ");
            //System.out.println("----------------------------------------------");

            while (sc.hasNext()) {
                // levanta los datos de cada linea
                datosParticipante = sc.next();
                //System.out.println(datosParticipante);  //muestra los datos levantados 
                // Descomentar si se quiere mostrar cada línea leída desde el archivo
                // System.out.println(datosParticipante);  //muestra los datos levantados 
                fila ++;
                // si es la cabecera la descarto y no se considera para armar el listado
                if (fila == 1)
                    continue;              
                 
                //Proceso auxiliar para convertir los string en vector
                // guarda en un vector los elementos individuales
                vectorParticipante = datosParticipante.split(",");   
                
                // graba el equipo en memoria
                //convertir un string a un entero;
                int readIdParticipante = Integer.parseInt(vectorParticipante[0]);
                String readNombre = vectorParticipante[1];
                // crea el objeto en memoria
                participante = new Participante(readIdParticipante, readNombre);
                
                // llama al metodo add para grabar el equipo en la lista en memoria
                //this.addParticipante(participante);
                listaparticipantes.addParticipante(participante);
            }

            //closes the scanner
            sc.close();
        } catch (IOException ex) {
                System.out.println("Mensaje: " + ex.getMessage());
        }       
    }

    // cargar desde la base de datos
    public void cargarDeDb(ListaParticipantes listaparticipantes) {
        // Todas las lineas comentadas son del codigo original 
        //Connection conn = null;
        
        try {
            
            // Establecer una conexión
            //conn = DriverManager.getConnection("jdbc:sqlite:./Archivos/pronosticos.db");
            abrirConexion();
            
            // Crear la base de datos
            //Statement stmt = conn.createStatement();
            Statement stmt = crearSentencia();

            //System.out.println("Consultando datos...");
            String sql = "SELECT idParticipante, Nombre FROM participantes";
            ResultSet rs = stmt.executeQuery(sql); // loop through the result set

            //System.out.println("Cargando los datos en ListaPArticipantes...");

            //ListaEquipos lista = new ListaEquipos();
            while (rs.next()) {
                Participante p = new Participante(
                        rs.getInt("idParticipante"),
                        rs.getString("Nombre")
                );
                
                //lista.addEquipo(e);
                listaparticipantes.addParticipante(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            cerrarConexion();
        }
    }}
