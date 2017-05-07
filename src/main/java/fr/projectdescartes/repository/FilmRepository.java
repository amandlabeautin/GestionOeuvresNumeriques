package fr.projectdescartes.repository;

import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Film;

public interface FilmRepository extends CrudRepository<Film, Long>{

}
