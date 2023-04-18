package com.mycompany.mitpmaven.repository;

import java.util.List;
import java.util.Optional;

public class CommonRepository<T extends Identificable> implements Repository<T> {

	/***
	 * Este método devuelve un item (o null) buscandolo por id
	 * @param id Identificador del equipo deseado
	 * @param items listado de items en donde buscar
	 * @return Optional con o sin el objeto encontrado
	 */
	@Override
	public Optional<T> findById(long id, List<T> items) {
		for (T item : items) {
			if (item.getId() == id) {
				return Optional.of(item);
			}
		}
		return Optional.empty();
	}
}
