package com.mycompany.mitpmaven.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Identificable> {

	Optional<T> findById(long id, List<T> items);
}
