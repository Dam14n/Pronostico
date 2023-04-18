/*
 *
 *
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
public class Partido implements Identificable {

	public static final char SIN_RESULTADO = 'X';
	public static final char GANADOR = 'G';
	public static final char PERDEDOR = 'P';
	public static final char EMPATE = 'E';
	private long id;
	private Equipo equipo1;
	private Equipo equipo2;
	private Integer golesEquipo1;
	private Integer golesEquipo2;

	public char getResultado(Equipo equipo) {
		char resultado = SIN_RESULTADO;

		if (equipo.getNombre().equals(equipo1.getNombre())) {
			if (this.golesEquipo1 > this.golesEquipo2) {
				resultado = GANADOR;
			} else if (this.golesEquipo1 < this.golesEquipo2) {
				resultado = PERDEDOR;
			} else {
				resultado = EMPATE;
			}
		} else if (equipo.getNombre().equals(equipo2.getNombre())) {
			if (this.golesEquipo2 > this.golesEquipo1) {
				resultado = GANADOR;
			} else if (this.golesEquipo2 < this.golesEquipo1) {
				resultado = PERDEDOR;
			} else {
				resultado = EMPATE;
			}
		}

		return resultado;
	}
}
