/*
 */
package com.mycompany.mitpmaven.model;

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
public class Equipo {
	private final int id;
	private final String nombre;
	private final String descripcion;
}
