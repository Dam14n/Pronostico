/*
 */
package com.mycompany.mitpmaven.model;

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
public class Equipo implements Identificable {
	private final long id;
	private final String nombre;
	private final String descripcion;
}
