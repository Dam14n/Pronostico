package com.mycompany.mitpmaven.data.loader;

import com.mycompany.mitpmaven.database.BaseDeDatos;
import com.mycompany.mitpmaven.lists.ListaParticipantes;
import com.mycompany.mitpmaven.model.Participante;
import com.mycompany.mitpmaven.utils.FileUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CargadorParticipantes {

	public void cargaDeDatos(int opcion, ListaParticipantes listaparticipantes) {
		switch (opcion) {
			case 1:
				cargarDeArchivo(listaparticipantes);
				break;
			case 2:
				cargarDeDb(listaparticipantes);
				break;
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}


	private void cargarDeArchivo(ListaParticipantes listaparticipantes) {
		String datosParticipante;
		String vectorParticipante[];
		Participante participante;
		int fila = 0;

		try (Scanner sc = new Scanner(FileUtils.getFile(listaparticipantes))) {
			sc.useDelimiter(System.lineSeparator());
			while (sc.hasNext()) {
				datosParticipante = sc.next();
				fila++;
				if (fila == 1)
					continue;

				vectorParticipante = datosParticipante.split(",");
				int readIdParticipante = Integer.parseInt(vectorParticipante[0]);
				String readNombre = vectorParticipante[1];
				participante = new Participante(readIdParticipante, readNombre);
				listaparticipantes.addParticipante(participante);
			}
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	private void cargarDeDb(ListaParticipantes listaparticipantes) {
		try (Connection connection = BaseDeDatos.conexion();
			 Statement statement = BaseDeDatos.crearSentencia(connection)) {

			String sql = "SELECT idParticipante, Nombre FROM participantes";
			ResultSet rs = statement.executeQuery(sql); // loop through the result set

			while (rs.next()) {
				Participante p = new Participante(
					rs.getInt("idParticipante"),
					rs.getString("Nombre")
				);

				listaparticipantes.addParticipante(p);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
