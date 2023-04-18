/*
Clase ListaParticipantes para la entrega 2
 */
package com.mycompany.mitpmaven.lists;

import com.mycompany.mitpmaven.model.Participante;
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
public class ListaParticipantes implements FileLocator {
	private List<Participante> participantes;
	private String participantesCSV;

	public ListaParticipantes() {
		this(new ArrayList<>(), "./Archivos/participantes.csv");
	}

	public void addParticipante(Participante p) {
		this.participantes.add(p);
	}

	public void removeParticipante(Participante p) {
		this.participantes.remove(p);
	}

	@Override
	public String getFileLocation() {
		return this.participantesCSV;
	}


}
