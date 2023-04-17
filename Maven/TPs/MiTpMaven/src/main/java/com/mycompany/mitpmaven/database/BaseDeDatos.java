package com.mycompany.mitpmaven.database;

/**
 * @author GRUPO 7
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class BaseDeDatos {


	public static Connection conexion() throws SQLException {
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
			return DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("Error al conectar con la base de datos");
			throw e;
		}
	}

	public static Statement crearSentencia(Connection conexion) {
		try {
			if (conexion != null) {
				return conexion.createStatement();
			}
		} catch (SQLException e) {
			System.out.println("Error al crear el statement");
		}
		throw new RuntimeException("Conexion invalida!!");
	}

}
