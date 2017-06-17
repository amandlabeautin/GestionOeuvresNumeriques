package fr.projectdescartes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projectdescartes.domain.Livre;
import fr.projectdescartes.domain.Oeuvre;

@Repository
public interface OeuvreRepository extends CrudRepository<Oeuvre, Long>{
	
	@Query("select o from Oeuvre o where discriminator = ?1")
	List<Oeuvre> findByType(@Param("typeValue")String typeValue);
	
	@Query("select o from Oeuvre o where discriminator = :typeValue and o.titre = :titre")
	List<Oeuvre> findByTypeAndTitle(@Param("typeValue")String typeValue, @Param("titre")String titre);
	
	@Query("select o from Oeuvre o where o.titre = :titre")
	Oeuvre findByTitre(@Param("titre")String titre);

	@Query("select id from Oeuvre where titre = :titre")
	int findByTitleForId(@Param("titre")String title);

	List<Livre> findByAuteurs_Name(@Param("author")String author);
}