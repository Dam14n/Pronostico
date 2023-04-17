/*
 */
package com.mycompany.mitpmaven.lists;

/**
 * @author GRUPO 7
 */

import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.model.Partido;
import de.vandermeer.asciitable.AsciiTable;
import java.io.File;
import java.io.IOException;
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
public class ListaPartidos {

	private List<Partido> partidos;
	private String partidosCSV;

	public ListaPartidos() {
		this(new ArrayList<>(), "./Archivos/partidos.csv");
	}


	public void addPartido(Partido partido) {
		this.partidos.add(partido);
	}

	public void removePartido(Partido partido) {
		this.partidos.remove(partido);
	}

	/***
	 * Este método devuelve un Equipo (o null) buscandolo por idEquipo
	 * @param idPartido Identificador del equipo deseado
	 * @return Objeto Equipo (o null si no se encuentra)
	 */
	public Partido getPartido(int idPartido) {
		Partido encontrado = null;
		for (Partido partido : this.getPartidos()) {
			if (partido.getId() == idPartido) {
				encontrado = partido;
				break;
			}
		}
		return encontrado;
	}

	public void listar(int opcion) {
		switch (opcion) {
			case 1:
				listadoEstandar();  // Listado para carga de archivos
				break;
			case 2:
				listadoTabla();   // Listado para carga de DB
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
		lista += "Los partidos cargados son : " + System.lineSeparator();
		lista += "---------------------------" + System.lineSeparator();

		for (Partido partido : partidos) {
			lista += partido + System.lineSeparator();
		}

		System.out.println(lista);
	}


	public void cargaDeDatos(int opcion, ListaEquipos listaequipos) {
		switch (opcion) {
			case 1:
				cargarDeArchivo(listaequipos);
			case 2:
				cargarDeDb(listaequipos);
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}

	public void listadoTabla() {
		SystemTextTerminal systerm = new SystemTextTerminal();
		TextIO textIO = new TextIO(systerm);
		TextTerminal terminal = textIO.getTextTerminal();
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("    Número    ", "    Descripción    ");
		at.addRule();

		for (Partido partido : partidos) {
			//at.addRow(equipo.getIdEquipo(), equipo.getNombre());
		}

		at.addRule();
		String rend = at.render();
		terminal.print(rend);
		System.out.println();
	}

	// cargar desde el archivo
	public void cargarDeArchivo(ListaEquipos listaequipos) {
		// para las lineas del archivo csv
		String datosPartido;
		// para los datos individuales de cada linea
		String vectorPartido[];
		// para el objeto en memoria
		Partido partido;

		int fila = 0;

		try {
			Scanner sc;
			//sc = new Scanner(new File("./Archivos/partidos.csv"));
			sc = new Scanner(new File(this.getPartidosCSV()));
			sc.useDelimiter(System.lineSeparator());   //setea el separador de los datos

			System.out.println("Los partidos cargados en el archivo son : ");
			System.out.println("-----------------------------------------");

			while (sc.hasNext()) {
				// levanta los datos de cada linea
				datosPartido = sc.next();
				System.out.println(datosPartido);  //muestra los datos levantados
				fila++;
				// si es la cabecera la descarto y no se considera para armar el listado
				if (fila == 1)
					continue;

				// Proceso auxiliar para convertir los string en vector
				// guarda en un vector los elementos individuales
				vectorPartido = datosPartido.split(",");

				// graba el equipo en memoria
				// convertir un string a un entero;
				int readIdPartido = Integer.parseInt(vectorPartido[0]);
				int readIdEquipo1 = Integer.parseInt(vectorPartido[1]);
				int readIdEquipo2 = Integer.parseInt(vectorPartido[2]);
				int readGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
				int readGolesEquipo2 = Integer.parseInt(vectorPartido[4]);

				Equipo equipo1 = listaequipos.getEquipo(readIdEquipo1);
				Equipo equipo2 = listaequipos.getEquipo(readIdEquipo2);

				// crea el objeto en memoria
				partido = new Partido(readIdPartido, equipo1, equipo2, readGolesEquipo1, readGolesEquipo2);
				// crea el objeto en memoria

				// llama al metodo add para grabar el equipo en la lista en memoria
				//this.addPartido(partido);
			}

			// closes the scanner
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	// cargar desde la base de datos
	public void cargarDeDb(ListaEquipos listaequipos) {
		// para las lineas del archivo csv
		String datosPartido;
		// para los datos individuales de cada linea
		String vectorPartido[];
		// para el objeto en memoria
		Partido partido;

		int fila = 0;

		try {
			Scanner sc = new Scanner(new File("./Archivos/partidos.csv"));
			sc.useDelimiter(System.lineSeparator());   //setea el separador de los datos

			System.out.println("Los partidos cargados en el archivo son : ");
			System.out.println("-----------------------------------------");

			while (sc.hasNext()) {
				// levanta los datos de cada linea
				datosPartido = sc.next();
				System.out.println(datosPartido);  //muestra los datos levantados
				fila++;
				// si es la cabecera la descarto y no se considera para armar el listado
				if (fila == 1)
					continue;

				// Proceso auxiliar para convertir los string en vector
				// guarda en un vector los elementos individuales
				vectorPartido = datosPartido.split(",");

				// graba el equipo en memoria
				// convertir un string a un entero;
				int readIdPartido = Integer.parseInt(vectorPartido[0]);
				int readIdEquipo1 = Integer.parseInt(vectorPartido[1]);
				int readIdEquipo2 = Integer.parseInt(vectorPartido[2]);
				int readGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
				int readGolesEquipo2 = Integer.parseInt(vectorPartido[4]);

				Equipo equipo1 = listaequipos.getEquipo(readIdEquipo1);
				Equipo equipo2 = listaequipos.getEquipo(readIdEquipo2);

				// crea el objeto en memoria
				partido = new Partido(readIdPartido, equipo1, equipo2, readGolesEquipo1, readGolesEquipo2);
				// crea el objeto en memoria

				// llama al metodo add para grabar el equipo en la lista en memoria
				this.addPartido(partido);
			}

			// closes the scanner
			sc.close();
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}
}