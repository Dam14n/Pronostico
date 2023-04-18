package com.mycompany.mitpmaven.data.loader;

import com.mycompany.mitpmaven.lists.ListaEquipos;
import com.mycompany.mitpmaven.lists.ListaParticipantes;
import com.mycompany.mitpmaven.lists.ListaPartidos;
import com.mycompany.mitpmaven.lists.ListaPronosticos;
import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.model.Partido;
import com.mycompany.mitpmaven.model.Pronostico;
import com.mycompany.mitpmaven.repository.CommonRepository;
import com.mycompany.mitpmaven.utils.FileUtils;
import java.io.IOException;
import java.util.Scanner;

public class CargadorPronosticos {

	private final CommonRepository<Equipo> equipoCommonRepository = new CommonRepository<>();
	private final CommonRepository<Partido> partidoCommonRepository = new CommonRepository<>();

	public void cargarDeArchivo(int idParticipante, ListaEquipos listaequipos, ListaPartidos listapartidos, ListaParticipantes listaParticipantes, ListaPronosticos listaPronosticos) {
		String datosPronostico;
		String vectorPronostico[];

		int fila = 0;

		try (Scanner sc = new Scanner(FileUtils.getFile(listaParticipantes))) {
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
					Partido partido = partidoCommonRepository.findById(readIdPartido, listapartidos.getPartidos()).get();
					Equipo equipo = equipoCommonRepository.findById(readIdEquipo, listaequipos.getEquipos()).get();
					Pronostico pronostico = new Pronostico(
						readIdPronostico,
						equipo,
						partido,
						readResultado
					);

					listaPronosticos.addPronostico(pronostico);
				}
			}
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	private void cargarDeArchivoTodos(ListaEquipos listaequipos, ListaPartidos listapartidos) {
//		String datosPronostico;
//		String vectorPronostico[];
//
//		int fila = 0;
//
//		try {
//			Scanner sc = new Scanner(new File(this.getPronosticosCSV()));
//			sc.useDelimiter(System.lineSeparator());
//			while (sc.hasNext()) {
//				datosPronostico = sc.next();
//				fila++;
//				if (fila == 1) {
//					continue;
//				}
//
//				vectorPronostico = datosPronostico.split(",");
//
//				int readIdPronostico = Integer.parseInt(vectorPronostico[0]);
//				int readIdParticipante = Integer.parseInt(vectorPronostico[1]);
//				int readIdPartido = Integer.parseInt(vectorPronostico[2]);
//				int readIdEquipo = Integer.parseInt(vectorPronostico[3]);
//				char readResultado = vectorPronostico[4].charAt(1);     // El primer caracter es una comilla delimitadora de campo
//
//				Partido partido = listapartidos.getPartido(readIdPartido);
//				Equipo equipo = listaequipos.getEquipo(readIdEquipo);
//				// crea el objeto en memoria
//				//Pronostico pronostico = new Pronostico(
//				//        readIdPronostico, // El id leido del archivo
//				//        equipo, // El Equipo que obtuvimos de la lista
//				//        partido, // El Partido que obtuvimos de la lista
//				//        readResultado, // El resultado que leimos del archivo,
//				//        readIdParticipante
//				//);
//
//				// llama al metodo add para grabar el equipo en la lista en memoria
//				//this.addPronostico(pronostico);
//			}
//
//		} catch (IOException ex) {
//			System.out.println("Mensaje: " + ex.getMessage());
//		}
	}
}
