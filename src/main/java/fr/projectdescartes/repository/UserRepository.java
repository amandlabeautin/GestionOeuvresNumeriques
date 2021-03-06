package fr.projectdescartes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.projectdescartes.domain.Download;
import fr.projectdescartes.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);

	User findByUsernameAndPassword(String login, String password);
	
	@Query("select c from Download c where c.user = :user and c.isvalidate = false")
	List<Download> findByUserAndNotValidate(@Param("user")User user);
}