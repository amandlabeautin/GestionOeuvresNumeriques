package fr.projectdescartes.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Editeur;

public interface EditeurRepository extends CrudRepository<Editeur, Long>{

	Iterable<Editeur> findAll(Sort sort);

}
