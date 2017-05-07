package fr.projectdescartes.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Auteur;

public interface AuteurRepository extends CrudRepository<Auteur, Long>{

	Iterable<Auteur> findAll(Sort sort);

}
