package fr.projectdescartes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.projectdescartes.domain.Download;
import fr.projectdescartes.domain.User;

public interface DownloadRepository extends CrudRepository<Download, Long>{
	
	@Query("select c from Download c where c.user = :user and c.isvalidate = false")
	List<Download> findByUserAndNotValidate(@Param("user")User user);
	
	@Query("select c from Download c, Oeuvre e where c.id = :id and e.id = :idOeuvre and c.isvalidate = false")
	Download findById(@Param("id") Long id, @Param("idOeuvre") Long idOeuvre);
}
