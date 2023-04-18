/*
 *
 *
 */
package com.mycompany.mitpmaven.model;

import com.mycompany.mitpmaven.lists.ListaPronosticos;
import com.mycompany.mitpmaven.repository.Identificable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author GRUPO 7
 */

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Participante implements Identificable {

	private long id;
	private String nombre;
	private ListaPronosticos pronosticos;

	public Participante(int id, String nombre) {
		this(id, nombre, new ListaPronosticos());
	}

	public Participante() {
		this(0, null, new ListaPronosticos());
	}
}
