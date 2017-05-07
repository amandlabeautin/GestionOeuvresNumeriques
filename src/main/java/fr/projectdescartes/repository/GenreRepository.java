package fr.projectdescartes.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>{

	Iterable<Genre> findAll(Sort sort);

}
