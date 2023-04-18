/*
 */
package com.mycompany.mitpmaven.lists;

/**
 * @author GRUPO 7
 */

import com.mycompany.mitpmaven.model.Partido;
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
public class ListaPartidos implements FileLocator {

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

	@Override
	public String getFileLocation() {
		return this.partidosCSV;
	}

}