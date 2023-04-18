package com.mycompany.mitpmaven.data.printer;

import com.mycompany.mitpmaven.lists.ListaPronosticos;
import com.mycompany.mitpmaven.model.Pronostico;

public class ListadorPronostico {

	public String listar(ListaPronosticos listaPronosticos) {
		StringBuilder lista = new StringBuilder();
		for (Pronostico pronostico : listaPronosticos.getPronosticos()) {
			lista
				.append(System.lineSeparator())
				.append(pronostico);
		}

		return lista.toString();
	}
}
