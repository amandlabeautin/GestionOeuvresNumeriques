package fr.projectdescartes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.projectdescartes.domain.Commande;
import fr.projectdescartes.domain.User;

public interface CommandeRepository extends CrudRepository<Commande, Long>{
	
	@Query("select c from Commande c where c.user = :user and c.isvalidate = false")
	List<Commande> findByUserAndNotValidate(@Param("user")User user);
}
