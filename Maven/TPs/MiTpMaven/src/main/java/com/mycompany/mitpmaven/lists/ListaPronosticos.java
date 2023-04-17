/*
Clase ListaPronosticos para la entrega 2
 */
package com.mycompany.mitpmaven.lists;

import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.model.Partido;
import com.mycompany.mitpmaven.model.Pronostico;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ListaPronosticos {
	private List<Pronostico> pronosticos;
	private String pronosticosCSV;

	public ListaPronosticos() {
		this(new ArrayList<>(), "./Archivos/pronosticos.csv");
	}

	// add y remove elementos
	public void addPronostico(Pronostico p) {
		this.pronosticos.add(p);
	}

	public void removePronostico(Pronostico p) {
		this.pronosticos.remove(p);
	}

	public String listar() {
		StringBuilder lista = new StringBuilder();
		for (Pronostico pronostico : pronosticos) {
			lista
				.append(System.lineSeparator())
				.append(pronostico);
		}

		return lista.toString();
	}


	public void cargarDeArchivo(int idParticipante, ListaEquipos listaequipos, ListaPartidos listapartidos
	) {
		String datosPronostico;
		String vectorPronostico[];

		int fila = 0;

		try {
			Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
			sc.useDelimiter(System.lineSeparator());

			while (sc.hasNext()) {
				datosPronostico = sc.next();
				System.out.println(datosPronostico);
				fila++;
				if (fila == 1) {
					continue;
				}
				vectorPronostico = datosPronostico.split(",");

				int readIdPronostico = Integer.parseInt(vectorPronostico[0]);
				int readIdParticipante = Integer.parseInt(vectorPronostico[1]);
				int readIdPartido = Integer.parseInt(vectorPronostico[2]);
				int readIdEquipo = Integer.parseInt(vectorPronostico[3]);
				char readResultado = vectorPronostico[4].charAt(1);
				if (readIdParticipante == idParticipante) {
					Partido partido = listapartidos.getPartido(readIdPartido);
					Equipo equipo = listaequipos.getEquipo(readIdEquipo);
					Pronostico pronostico = new Pronostico(
						readIdPronostico,
						equipo,
						partido,
						readResultado
					);

					this.addPronostico(pronostico);
				}
			}
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	public void cargarDeArchivoTodos(ListaEquipos listaequipos, ListaPartidos listapartidos
	) {
		String datosPronostico;
		String vectorPronostico[];

		int fila = 0;

		try {
			Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
			sc.useDelimiter(System.lineSeparator());
			while (sc.hasNext()) {
				datosPronostico = sc.next();
				fila++;
				if (fila == 1) {
					continue;
				}

				vectorPronostico = datosPronostico.split(",");

				int readIdPronostico = Integer.parseInt(vectorPronostico[0]);
				int readIdParticipante = Integer.parseInt(vectorPronostico[1]);
				int readIdPartido = Integer.parseInt(vectorPronostico[2]);
				int readIdEquipo = Integer.parseInt(vectorPronostico[3]);
				char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo

				Partido partido = listapartidos.getPartido(readIdPartido);
				Equipo equipo = listaequipos.getEquipo(readIdEquipo);
				// crea el objeto en memoria
				//Pronostico pronostico = new Pronostico(
				//        readIdPronostico, // El id leido del archivo
				//        equipo, // El Equipo que obtuvimos de la lista
				//        partido, // El Partido que obtuvimos de la lista
				//        readResultado, // El resultado que leimos del archivo,
				//        readIdParticipante
				//);

				// llama al metodo add para grabar el equipo en la lista en memoria
				//this.addPronostico(pronostico);
			}

		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	public int getPuntaje() {
		return this.getPronosticos()
			.stream()
			.mapToInt(Pronostico::getPuntaje)
			.sum();
	}
}