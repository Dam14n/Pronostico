/*
Clase ListaPronosticos para la entrega 2
 */
package com.mycompany.mitpmaven.lists;

import com.mycompany.mitpmaven.model.Pronostico;
import com.mycompany.mitpmaven.utils.FileLocator;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ListaPronosticos implements FileLocator {
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

	public int getPuntaje() {
		return this.getPronosticos()
			.stream()
			.mapToInt(Pronostico::getPuntaje)
			.sum();
	}

	@Override
	public String getFileLocation() {
		return this.pronosticosCSV;
	}

}