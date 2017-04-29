package fr.projectdescartes.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OeuvreRepository extends CrudRepository<Oeuvre, Long>{
	
	@Query("SELECT o FROM Oeuvre o INNER JOIN o.acteurs a WHERE a IN (:acteurs)")
    List<Oeuvre> findByCategories(@Param("acteurs") Collection<Acteur> acteurs);
	
	@Query("select o from Oeuvre o where discriminator = ?1")
	List<Oeuvre> findByType(@Param("typeValue")String typeValue);
}