package com.mycompany.mitpmaven.data.printer;

import com.mycompany.mitpmaven.lists.ListaPartidos;
import com.mycompany.mitpmaven.model.Partido;
import de.vandermeer.asciitable.AsciiTable;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

public class ListadorPartidos {

	public void listar(int opcion, ListaPartidos listaPartidos) {
		switch (opcion) {
			case 1:
				listadoEstandar(listaPartidos);
				break;
			case 2:
				listadoTabla(listaPartidos);
				break;
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}

	public void listadoTabla(ListaPartidos listaPartidos) {
		SystemTextTerminal systerm = new SystemTextTerminal();
		TextIO textIO = new TextIO(systerm);
		TextTerminal terminal = textIO.getTextTerminal();
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("    Número    ", "    Descripción    ");
		at.addRule();

		for (Partido partido : listaPartidos.getPartidos()) {
			//at.addRow(equipo.getIdEquipo(), equipo.getNombre());
		}

		at.addRule();
		String rend = at.render();
		terminal.print(rend);
		System.out.println();
	}

	public void listadoEstandar(ListaPartidos listaPartidos) {
		String lista = "";

		lista += System.lineSeparator();
		lista += "Los partidos cargados son : " + System.lineSeparator();
		lista += "---------------------------" + System.lineSeparator();

		for (Partido partido : listaPartidos.getPartidos()) {
			lista += partido + System.lineSeparator();
		}

		System.out.println(lista);
	}
}
