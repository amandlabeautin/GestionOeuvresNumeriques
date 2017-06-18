package fr.projectdescartes.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.projectdescartes.domain.Acteur;
import fr.projectdescartes.domain.Film;

public interface ActeurRepository extends CrudRepository<Acteur, Long>{

	Iterable<Acteur> findAll(Sort sort);
	
	@Query("SELECT f FROM Film f INNER JOIN f.acteurs c WHERE c.name = (:acteur)")
	List<Film> findByName(@Param("acteur")String acteur);
	
}
