/*
 */
package com.mycompany.mitpmaven.lists;

/**
 * @author GRUPO 7
 */

import com.mycompany.mitpmaven.model.Equipo;
import com.mycompany.mitpmaven.utils.FileLocator;
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
public class ListaEquipos implements FileLocator {
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

	@Override
	public String getFileLocation() {
		return this.equiposCSV;
	}
}