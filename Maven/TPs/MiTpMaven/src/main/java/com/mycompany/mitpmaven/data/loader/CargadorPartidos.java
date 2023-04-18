package com.mycompany.mitpmaven.data.loader;

import com.mycompany.mitpmaven.lists.ListaEquipos;
import com.mycompany.mitpmaven.lists.ListaPartidos;
import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.model.Partido;
import com.mycompany.mitpmaven.repository.CommonRepository;
import com.mycompany.mitpmaven.utils.FileUtils;
import java.io.IOException;
import java.util.Scanner;

public class CargadorPartidos {

	private final CommonRepository<Equipo> equipoCommonRepository = new CommonRepository<>();

	public void cargaDeDatos(int opcion, ListaEquipos listaEquipos, ListaPartidos listaPartidos) {
		switch (opcion) {
			case 1:
				cargarDeArchivo(listaEquipos, listaPartidos);
			case 2:
				cargarDeDb(listaEquipos, listaPartidos);
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}

	private void cargarDeArchivo(ListaEquipos listaEquipos, ListaPartidos listaPartidos) {
		String datosPartido;
		String vectorPartido[];
		Partido partido;

		int fila = 0;

		try (Scanner sc = new Scanner(FileUtils.getFile(listaPartidos))) {
			sc.useDelimiter(System.lineSeparator());

			System.out.println("Los partidos cargados en el archivo son : ");
			System.out.println("-----------------------------------------");

			while (sc.hasNext()) {
				datosPartido = sc.next();
				System.out.println(datosPartido);
				fila++;
				if (fila == 1)
					continue;
				vectorPartido = datosPartido.split(",");

				int readIdPartido = Integer.parseInt(vectorPartido[0]);
				int readIdEquipo1 = Integer.parseInt(vectorPartido[1]);
				int readIdEquipo2 = Integer.parseInt(vectorPartido[2]);
				int readGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
				int readGolesEquipo2 = Integer.parseInt(vectorPartido[4]);

				Equipo equipo1 = equipoCommonRepository.findById(readIdEquipo1, listaEquipos.getEquipos()).get();
				Equipo equipo2 = equipoCommonRepository.findById(readIdEquipo2, listaEquipos.getEquipos()).get();

				partido = new Partido(readIdPartido, equipo1, equipo2, readGolesEquipo1, readGolesEquipo2);
				listaPartidos.addPartido(partido);
			}

			// closes the scanner
		} catch (IOException ex) {
			System.out.println("Mensaje: " + ex.getMessage());
		}
	}

	private void cargarDeDb(ListaEquipos listaEquipos, ListaPartidos listaequipos) {
//		String datosPartido;
//		String vectorPartido[];
//		Partido partido;
//
//		int fila = 0;
//
//		try {
//			Scanner sc = new Scanner(new File("./Archivos/partidos.csv"));
//			sc.useDelimiter(System.lineSeparator());
//
//			System.out.println("Los partidos cargados en el archivo son : ");
//			System.out.println("-----------------------------------------");
//
//			while (sc.hasNext()) {
//				// levanta los datos de cada linea
//				datosPartido = sc.next();
//				System.out.println(datosPartido);  //muestra los datos levantados
//				fila++;
//				// si es la cabecera la descarto y no se considera para armar el listado
//				if (fila == 1)
//					continue;
//
//				// Proceso auxiliar para convertir los string en vector
//				// guarda en un vector los elementos individuales
//				vectorPartido = datosPartido.split(",");
//
//				// graba el equipo en memoria
//				// convertir un string a un entero;
//				int readIdPartido = Integer.parseInt(vectorPartido[0]);
//				int readIdEquipo1 = Integer.parseInt(vectorPartido[1]);
//				int readIdEquipo2 = Integer.parseInt(vectorPartido[2]);
//				int readGolesEquipo1 = Integer.parseInt(vectorPartido[3]);
//				int readGolesEquipo2 = Integer.parseInt(vectorPartido[4]);
//
//				Equipo equipo1 = listaequipos.getEquipo(readIdEquipo1);
//				Equipo equipo2 = listaequipos.getEquipo(readIdEquipo2);
//
//				// crea el objeto en memoria
//				partido = new Partido(readIdPartido, equipo1, equipo2, readGolesEquipo1, readGolesEquipo2);
//				// crea el objeto en memoria
//
//				// llama al metodo add para grabar el equipo en la lista en memoria
//				this.addPartido(partido);
//			}
//
//			// closes the scanner
//			sc.close();
//		} catch (IOException ex) {
//			System.out.println("Mensaje: " + ex.getMessage());
//		}
	}
}
