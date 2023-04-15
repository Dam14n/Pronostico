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

    public static Connection abrirConexion() {
        String url = "jdbc:mysql://localhost:3306/pronosticos.db";
        String usuario = "root";
        String password = "contraseña";
        
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos");
            e.printStackTrace();
        }
        
        return conexion;
    }
    
    public static Statement crearSentencia() {
        Statement statement = null;
        
        try {
            if (conexion != null) {
                statement = conexion.createStatement();
                System.out.println("Statement creado correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al crear el statement");
            e.printStackTrace();
        }
        
        return statement;
    }
    
    public static void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión cerrada correctamente");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión con la base de datos");
            e.printStackTrace();
        }
    }

    //  abrirConexion()
        
    //  Statement statement = crearStatement();
        
    //  cerrarConexion();
}
