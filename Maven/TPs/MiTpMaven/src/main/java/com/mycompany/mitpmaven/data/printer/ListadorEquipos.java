package com.mycompany.mitpmaven.data.printer;

import com.mycompany.mitpmaven.model.Equipo;
import de.vandermeer.asciitable.AsciiTable;
import java.util.List;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

public class ListadorEquipos {

	public void listar(int opcion, List<Equipo> equipos) {
		switch (opcion) {
			case 1:
				listadoEstandar(equipos);
				break;
			case 2:
				listadoTabla(equipos);
				break;
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}

	private void listadoEstandar(List<Equipo> equipos) {
		StringBuilder builder = new StringBuilder();
		builder.append(System.lineSeparator())
			.append("Los equipos cargados son : " + System.lineSeparator())
			.append("Los equipos cargados son : " + System.lineSeparator())
			.append("--------------------------" + System.lineSeparator());

		for (Equipo equipo : equipos) {
			builder.append(equipo + System.lineSeparator());
		}
		System.out.println(builder);

	}

	private void listadoTabla(List<Equipo> equipos) {
		SystemTextTerminal systerm = new SystemTextTerminal();
		TextIO textIO = new TextIO(systerm);
		TextTerminal terminal = textIO.getTextTerminal();
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("    Número    ", "    Descripción    ");
		at.addRule();

		for (Equipo equipo : equipos) {
			at.addRow(equipo.getId(), equipo.getNombre());
		}

		at.addRule();
		String rend = at.render();
		terminal.print(rend);
		System.out.println();
	}
}
