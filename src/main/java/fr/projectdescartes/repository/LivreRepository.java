package fr.projectdescartes.repository;

import org.springframework.data.repository.CrudRepository;

import fr.projectdescartes.domain.Livre;

public interface LivreRepository extends CrudRepository<Livre, Long>{

}
