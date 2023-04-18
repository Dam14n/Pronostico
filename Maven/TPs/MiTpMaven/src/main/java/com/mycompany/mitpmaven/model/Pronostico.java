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
public class Pronostico implements Identificable {
	private long id;
	private Participante participante;
	private Equipo equipo;
	private Partido partido;
	private char resultado;

	public Pronostico(int id, Equipo equipo, Partido partido, char resultado) {
		this.id = id;
		this.participante = null;
		this.equipo = equipo;
		this.partido = partido;
		this.resultado = resultado;
	}

	public int getPuntaje() {
        return 0;
    }
}
