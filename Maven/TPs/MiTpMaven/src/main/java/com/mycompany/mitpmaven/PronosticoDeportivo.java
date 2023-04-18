/*
Para entrega 2
 */
package com.mycompany.mitpmaven;

import com.mycompany.mitpmaven.console.Menu;
import com.mycompany.mitpmaven.data.loader.CargadorEquipos;
import com.mycompany.mitpmaven.data.loader.CargadorParticipantes;
import com.mycompany.mitpmaven.data.loader.CargadorPartidos;
import com.mycompany.mitpmaven.data.printer.ListadorEquipos;
import com.mycompany.mitpmaven.data.printer.ListadorParticipantes;
import com.mycompany.mitpmaven.data.printer.ListadorPartidos;
import com.mycompany.mitpmaven.lists.ListaEquipos;
import com.mycompany.mitpmaven.lists.ListaParticipantes;
import com.mycompany.mitpmaven.lists.ListaPartidos;
import com.mycompany.mitpmaven.lists.ListaPronosticos;

/**
 * @author aguzman
 */
public class PronosticoDeportivo {
	private final ListaEquipos equipos;
	private final ListaPartidos partidos;
	private final ListaParticipantes participantes;
	private final ListaPronosticos pronosticos;
	private final CargadorEquipos cargadorEquipos = new CargadorEquipos();
	private final CargadorParticipantes cargadorParticipantes = new CargadorParticipantes();
	private final CargadorPartidos cargadorPartidos = new CargadorPartidos();
	private final ListadorEquipos listadorEquipos = new ListadorEquipos();
	private final ListadorParticipantes listadorParticipantes = new ListadorParticipantes();
	private final ListadorPartidos listadorPartidos = new ListadorPartidos();

	public PronosticoDeportivo() {
		equipos = new ListaEquipos();
		partidos = new ListaPartidos();
		participantes = new ListaParticipantes();
		pronosticos = new ListaPronosticos();
	}

	public void play() {
		Menu menu = new Menu();
		int opcion = menu.runMenu();

		if ((opcion == 1) || (opcion == 2)) {
			cargadorEquipos.cargaDeDatos(opcion, equipos);
			listadorEquipos.listar(opcion, equipos.getEquipos());

			cargadorParticipantes.cargaDeDatos(opcion, participantes);
			listadorParticipantes.listar(opcion, participantes);

			cargadorPartidos.cargaDeDatos(opcion, equipos, partidos);
			listadorPartidos.listar(opcion, partidos);
		}
	}
}