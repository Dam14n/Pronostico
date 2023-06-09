/*
*/
package com.mycompany.mitpmaven;

/**
* @author GRUPO 7
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
    private static Connection conexion;

    // Abre la conexion de la base de datos
    public static Connection abrirConexion() {
        String api = "jdbc";
        String driver = "sqlite";
        String road = "./Archivos/";
        String port = "3306/";
        String database = "pronosticos.db";
        String usuario = "root";
        // No se usa ñ para las claves
        String password = "contraseña";
        String separator = ":";
        String url = api + separator + driver + separator + road + database;
        //String url = "jdbc:mysql://localhost:3306/pronosticos.db";
        
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
        }
        
        return conexion;
    }
    
    public static Statement crearSentencia() {
        Statement statement = null;
        
        try {
            if (conexion != null) {
                statement = conexion.createStatement();
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el statement");
        }
        
        return statement;
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            // close failed.
           System.out.println("Error al cerrar la conexión con la base de datos");
        }
    }

    //  abrirConexion()
        
    //  Statement statement = crearStatement();
        
    //  cerrarConexion();
}
