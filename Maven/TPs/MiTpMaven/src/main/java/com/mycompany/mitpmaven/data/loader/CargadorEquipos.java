package com.mycompany.mitpmaven.data.loader;

import com.mycompany.mitpmaven.database.BaseDeDatos;
import com.mycompany.mitpmaven.lists.ListaEquipos;
import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.utils.FileUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CargadorEquipos {

	public static final String COMMA = ",";

	public void cargaDeDatos(int opcion, ListaEquipos listaequipos) {
		switch (opcion) {
			case 1:
				cargarDeArchivo(listaequipos);
				break;
			case 2:
				cargarDeDb(listaequipos);
				break;
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}


	private void cargarDeArchivo(ListaEquipos listaequipos) {
		String datosEquipo;
		String vectorEquipo[];
		Equipo equipo;
		int fila = 0;

		try (Scanner sc = new Scanner(FileUtils.getFile(listaequipos))) {
			sc.useDelimiter(System.lineSeparator());

			while (sc.hasNext()) {
				datosEquipo = sc.next();
				fila++;
				if (fila == 1) {
					continue;
				}
				vectorEquipo = datosEquipo.split(COMMA);

				int id = Integer.parseInt(vectorEquipo[0]);
				String nombre = vectorEquipo[1];
				String readdescripcion = vectorEquipo[2];
				equipo = new Equipo(id, nombre, readdescripcion);
				listaequipos.addEquipo(equipo);
			}
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	private void cargarDeDb(ListaEquipos listaequipos) {
		try (Connection connection = BaseDeDatos.conexion();
			 Statement statement = BaseDeDatos.crearSentencia(connection)) {

			String sql = "SELECT idEquipo, Nombre, Descripcion FROM equipos";
			ResultSet rs = statement.executeQuery(sql);

			while (rs.next()) {
				Equipo e = new Equipo(
					rs.getInt("idEquipo"),
					rs.getString("Nombre"),
					rs.getString("Descripcion")
				);
				listaequipos.addEquipo(e);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
