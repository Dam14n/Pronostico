package com.mycompany.mitpmaven.data.printer;

import com.mycompany.mitpmaven.lists.ListaParticipantes;
import com.mycompany.mitpmaven.model.Participante;
import de.vandermeer.asciitable.AsciiTable;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.system.SystemTextTerminal;

public class ListadorParticipantes {

	public void listar(int opcion, ListaParticipantes listaParticipantes) {
		switch (opcion) {
			case 1:
				listadoEstandar(listaParticipantes);
				break;
			case 2:
				listadoTabla(listaParticipantes);
				break;
			default:
				System.out.println();
				System.out.println("Opción no implementada.");
				System.out.println();
		}
	}

	private void listadoEstandar(ListaParticipantes listaParticipantes) {
		String lista = "";

		lista += System.lineSeparator();
		lista += "Los participantes cargados son : " + System.lineSeparator();
		lista += "--------------------------------" + System.lineSeparator();

		for (Participante participante : listaParticipantes.getParticipantes()) {
			lista += participante + System.lineSeparator();
		}

		System.out.println(lista);
	}

	private void listadoTabla(ListaParticipantes listaParticipantes) {
		SystemTextTerminal systerm = new SystemTextTerminal();
		TextIO textIO = new TextIO(systerm);
		TextTerminal terminal = textIO.getTextTerminal();
		AsciiTable at = new AsciiTable();
		at.addRule();
		at.addRow("    Número    ", "    Descripción    ");
		at.addRule();

		for (Participante participante : listaParticipantes.getParticipantes()) {
			at.addRow(participante.getId(), participante.getNombre());
		}

		at.addRule();
		String rend = at.render();
		terminal.print(rend);
		System.out.println();
	}
}
