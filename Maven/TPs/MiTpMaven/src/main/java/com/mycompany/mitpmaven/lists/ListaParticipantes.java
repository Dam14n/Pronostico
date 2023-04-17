/*
Clase ListaParticipantes para la entrega 2
 */
package com.mycompany.mitpmaven.lists;

import com.mycompany.mitpmaven.database.BaseDeDatos;
import com.mycompany.mitpmaven.model.Participante;
import de.vandermeer.asciitable.AsciiTable;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListaParticipantes {
	private List<Participante> participantes;
	private String participantesCSV;

	public ListaParticipantes() {
		this(new ArrayList<>(), "./Archivos/participantes.csv");
	}

	public void addParticipante(Participante p) {
		this.participantes.add(p);
	}

	public void removeParticipante(Participante p) {
		this.participantes.remove(p);
	}

	/***
	 * Este método devuelve un Participante (o null) buscandolo por id
	 * @param id Identificador del equipo deseado
	 * @return Objeto Participante (o null si no se encuentra)
	 */
	public Participante getParticipante(int id) {
		for (Participante eq : this.getParticipantes()) {
			if (eq.getId() == id) {
				return eq;
			}
		}
		return null;
	}

	public void listar(int opcion) {
		switch (opcion) {
			case 1:
				listadoEstandar();
				break;
			case 2:
				listadoTabla();
				break;
			default:
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

		for (Participante participante : participantes) {
			lista += participante + System.lineSeparator();
		}

		System.out.println(lista);
	}

	public void listadoTabla() {
		SystemTextTerminal systerm = new SystemTextTerminal();
		TextIO textIO = new TextIO(systerm);
		TextTerminal terminal = textIO.getTextTerminal();
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("    Número    ", "    Descripción    ");
		at.addRule();

		for (Participante participante : participantes) {
			at.addRow(participante.getId(), participante.getNombre());
		}

		at.addRule();
		String rend = at.render();
		terminal.print(rend);
		System.out.println();
	}


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


	public void cargarDeArchivo(ListaParticipantes listaparticipantes) {
		String datosParticipante;
		String vectorParticipante[];
		Participante participante;
		int fila = 0;

		try {
			Scanner sc;
			sc = new Scanner(new File(this.getParticipantesCSV()));
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

			sc.close();
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	public void cargarDeDb(ListaParticipantes listaparticipantes) {
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
