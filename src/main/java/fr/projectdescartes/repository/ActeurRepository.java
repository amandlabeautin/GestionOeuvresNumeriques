package fr.projectdescartes.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Acteur;

public interface ActeurRepository extends CrudRepository<Acteur, Long>{

	Iterable<Acteur> findAll(Sort sort);
	
}
