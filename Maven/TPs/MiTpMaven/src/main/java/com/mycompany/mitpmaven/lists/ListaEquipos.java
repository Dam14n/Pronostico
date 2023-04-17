/*
 */
package com.mycompany.mitpmaven.lists;

/**
 * @author GRUPO 7
 */

import com.mycompany.mitpmaven.model.Equipo;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListaEquipos {
	private List<Equipo> equipos;
	private String equiposCSV;

	public ListaEquipos() {
		this(new ArrayList<>(), "./Archivos/equipos.csv");
	}


	public void addEquipo(Equipo equipo) {
		this.equipos.add(equipo);
	}


	public void removeEquipo(Equipo equipo) {
		this.equipos.remove(equipo);
	}

	/***
	 * Este método devuelve un Equipo (o null) buscandolo por id
	 * @param id Identificador del equipo deseado
	 * @return Objeto Equipo (o null si no se encuentra)
	 */
	public Equipo getEquipo(int id) {
		for (Equipo equipo : this.getEquipos()) {
			if (equipo.getId() == id) {
				return equipo;
			}
		}
		return null;
	}
}